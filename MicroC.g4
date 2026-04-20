grammar MicroC;

@header {
    package compiler;

    import java.util.List;
    import java.util.LinkedList;
    import java.util.Map;
    import java.util.HashMap;
    import ast.*;

}

@members {
     private SymbolTable st; //Symbol table for the program
     private ASTNode ast;    //AST for the program
     private Map<String, InlineFunction> inlineFunctions = new HashMap<String, InlineFunction>();

     public void setSymbolTable(SymbolTable st) {
          this.st = st;
     }

     public SymbolTable getSymbolTable() {
          return st;
     }

     public ASTNode getAST() {
          return ast;
     }

     private void defineInlineFunction(String name, Scope.Type parameterType, String parameterName, ExpressionNode body) {
          inlineFunctions.put(name, new InlineFunction(name, parameterType, parameterName, body));
     }

     private ExpressionNode inlineCall(String name, ExpressionNode arg) {
          InlineFunction function = inlineFunctions.get(name);
          if (function == null) {
               throw new Error("Unknown helper function: " + name);
          }
          return ExpressionCloner.substitute(function.getBody(), function.getParameterName(), arg);
     }
}


/* Full MicroC program */
program : decls helper_functions function {ast = $function.node;};


/* Declarations */
decls : var_decl decls
      | str_decl decls 
      | /* empty */ ;

var_decls : var_decl var_decls 
          | /* empty */ ;


/* Identifiers and types */
id : IDENTIFIER ;
		  
var_decl : base_type id ';' 
    {st.addVariable($base_type.t, $id.text);}
    | base_type id '[' len=INT_LITERAL ']' ';'
    {st.addArray($base_type.t, $id.text, Integer.parseInt($len.text));};

str_decl : 'string' id '=' val= STR_LITERAL ';' 
    {st.addVariable(Scope.Type.STRING, $id.text, $val.text);};

base_type returns [Scope.Type t] : 'int' {$t = Scope.Type.INT;} 
                                 | 'float' {$t = Scope.Type.FLOAT;};


/* Functions */
helper_functions : helper_function helper_functions
                 | /* empty */ ;

helper_function
    : ret=base_type fname=id '(' paramType=base_type param=id ')'
      {
          st.pushScope();
          st.currentScope().setName($fname.text);
          st.addArgument($paramType.t, $param.text);
      }
      '{' 'return' expr ';' '}'
      {
          defineInlineFunction($fname.text, $paramType.t, $param.text, $expr.node);
          st.popScope();
      };

function returns [StatementListNode node] : 'int' 'main' '(' ')'
    {
        st.pushScope();
        st.currentScope().setName("main");
    }
    '{' statements '}'
    {
        $node = $statements.node;
        st.popScope();
    };

		 		 
/* Statements */
statements returns [StatementListNode node] : statement s=statements {$node = new StatementListNode($statement.node, $s.node);}
           | /* empty */ {$node = new StatementListNode();};
			
statement returns [StatementNode node] : base_stmt ';' {$node = $base_stmt.node;}
          | local_var_decl ';' {$node = $local_var_decl.node;}
		  | if_stmt {$node = $if_stmt.node;}
		  | while_stmt {$node = $while_stmt.node;}
          | for_stmt {$node = $for_stmt.node;}
          | block_stmt {$node = $block_stmt.node;};
		  
base_stmt returns [StatementNode node] : assign_stmt {$node = $assign_stmt.node;}
          | read_stmt {$node = $read_stmt.node;} 
          | print_stmt {$node = $print_stmt.node;} 
          | return_stmt {$node = $return_stmt.node;};

local_var_decl returns [StatementNode node]
    : base_type id
    {
        st.addVariable($base_type.t, $id.text);
        $node = new EmptyStatementNode();
    }
    | base_type id '=' expr
    {
        st.addVariable($base_type.t, $id.text);
        $node = new AssignNode(new VarNode($id.text), $expr.node);
    };
		 
read_stmt returns [ReadNode node] : 'read' '(' id ')' {$node = new ReadNode(new VarNode($id.text));} ;

print_stmt returns [WriteNode node] : 'print' '(' expr ')' {$node = new WriteNode($expr.node);};

return_stmt returns [ReturnNode node] : 'return' expr {$node = new ReturnNode($expr.node);};

assign_stmt returns [AssignNode node] : lhs=lvalue '=' expr {$node = new AssignNode($lhs.node, $expr.node);};

if_stmt returns [IfStatementNode node] : 'if' '(' cond ')' '{'
    { st.pushScope(); }
    thenStatements=statements '}'
    { st.popScope(); }
    else_stmt 
    {$node = new IfStatementNode($cond.node, $thenStatements.node, $else_stmt.node);};

else_stmt returns [StatementListNode node] : 'else' '{'
            { st.pushScope(); }
            elseStatements=statements '}'
            { $node = $elseStatements.node; st.popScope(); }
          | /* empty */ {$node = new StatementListNode();};

while_stmt returns [WhileNode node] : 'while' '(' cond ')' '{'
    { st.pushScope(); }
    statements '}'
    { $node = new WhileNode($cond.node, $statements.node); st.popScope(); };

for_stmt returns [StatementNode node]
    : 'for' '(' init=for_assign_opt ';' test=cond ';' step=for_assign_opt ')' '{'
      { st.pushScope(); }
      body=statements '}'
      {
          StatementListNode loopBody = $body.node;
          if (!($step.node instanceof EmptyStatementNode)) {
              loopBody = new StatementListNode(loopBody, $step.node);
          }

          StatementNode loweredLoop = new WhileNode($test.node, loopBody);
          if ($init.node instanceof EmptyStatementNode) {
              $node = new BlockNode(new StatementListNode(loweredLoop));
          } else {
              $node = new BlockNode(new StatementListNode(new StatementListNode($init.node), loweredLoop));
          }
          st.popScope();
      };

for_assign_opt returns [StatementNode node]
    : assign_stmt {$node = $assign_stmt.node;}
    | /* empty */ {$node = new EmptyStatementNode();};

lvalue returns [TypedASTNode node]
    : id {$node = new VarNode($id.text);}
    | array_access {$node = $array_access.node;};

array_access returns [ArrayAccessNode node]
    : id '[' expr ']' {$node = new ArrayAccessNode($id.text, $expr.node);};

block_stmt returns [BlockNode node] : '{'
    { st.pushScope(); }
    statements '}'
    { $node = new BlockNode($statements.node); st.popScope(); };
	
 
/* Expressions */
primary returns [ExpressionNode node] : call=id '(' arg=expr ')' {$node = inlineCall($call.text, $arg.node);}
        | array_access {$node = $array_access.node;}
        | id {$node = new VarNode($id.text);}
        | '(' expr ')' {$node = $expr.node;}
        | unaryminus_expr {$node = $unaryminus_expr.node;}
        | il = INT_LITERAL {$node = new IntLitNode($il.text);}
        | fl = FLOAT_LITERAL {$node = new FloatLitNode($fl.text);};


unaryminus_expr returns [ExpressionNode node] : '-' expr {$node = new UnaryOpNode($expr.node,"-"); }; 

/* This is left recursive, but ANTLR will clean this up */ 
expr returns [ExpressionNode node] : term {$node = $term.node;}
     | e1 = expr addop term { $node = new BinaryOpNode($e1.node, $term.node, $addop.text);  }; 

/* This is left recursive, but ANTLR will clean this up */
term returns [ExpressionNode node] : primary {$node = $primary.node;}
     | t1 = term mulop primary { $node = new BinaryOpNode($t1.node, $primary.node, $mulop.text);  }; 

cond returns [ConditionNode node]
    : c1=cond '||' c2=and_cond {$node = new LogicalOrNode($c1.node, $c2.node);}
    | and_cond {$node = $and_cond.node;};

and_cond returns [ConditionNode node]
    : c1=and_cond '&&' c2=not_cond {$node = new LogicalAndNode($c1.node, $c2.node);}
    | not_cond {$node = $not_cond.node;};

not_cond returns [ConditionNode node]
    : '!' not_cond {$node = new LogicalNotNode($not_cond.node);}
    | '(' cond ')' {$node = $cond.node;}
    | e1=expr cmpop e2=expr {$node = new CondNode($e1.node, $e2.node, $cmpop.text);};

cmpop : '<' | '<=' | '>=' | '==' | '!=' | '>' ;

mulop : '*' | '/' | '%' ;

addop : '+' | '-' ;


/* Tokens */

IDENTIFIER : LETTER (LETTER | DIGIT)* ;

INT_LITERAL : DIGIT+;

FLOAT_LITERAL : DIGIT* '.' DIGIT+;

STR_LITERAL : '"' (~('"'))* '"' ;

COMMENT : '/*' .*? '*/' -> skip;

WS : [ \t\n\r]+ -> skip;

fragment LETTER : ('a'..'z' | 'A'..'Z') ;

fragment DIGIT : ('0'..'9') ;
