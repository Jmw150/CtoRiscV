// Generated from MicroC.g4 by ANTLR 4.8

    package compiler;

    import java.util.List;
    import java.util.LinkedList;
    import java.util.Map;
    import java.util.HashMap;
    import ast.*;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroCParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, IDENTIFIER=34, INT_LITERAL=35, FLOAT_LITERAL=36, STR_LITERAL=37, 
		COMMENT=38, WS=39;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_var_decls = 2, RULE_id = 3, RULE_var_decl = 4, 
		RULE_str_decl = 5, RULE_base_type = 6, RULE_helper_functions = 7, RULE_helper_function = 8, 
		RULE_function = 9, RULE_statements = 10, RULE_statement = 11, RULE_base_stmt = 12, 
		RULE_local_var_decl = 13, RULE_read_stmt = 14, RULE_print_stmt = 15, RULE_return_stmt = 16, 
		RULE_assign_stmt = 17, RULE_if_stmt = 18, RULE_else_stmt = 19, RULE_while_stmt = 20, 
		RULE_for_stmt = 21, RULE_for_assign_opt = 22, RULE_lvalue = 23, RULE_array_access = 24, 
		RULE_block_stmt = 25, RULE_primary = 26, RULE_unaryminus_expr = 27, RULE_expr = 28, 
		RULE_term = 29, RULE_cond = 30, RULE_and_cond = 31, RULE_not_cond = 32, 
		RULE_cmpop = 33, RULE_mulop = 34, RULE_addop = 35;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decls", "var_decls", "id", "var_decl", "str_decl", "base_type", 
			"helper_functions", "helper_function", "function", "statements", "statement", 
			"base_stmt", "local_var_decl", "read_stmt", "print_stmt", "return_stmt", 
			"assign_stmt", "if_stmt", "else_stmt", "while_stmt", "for_stmt", "for_assign_opt", 
			"lvalue", "array_access", "block_stmt", "primary", "unaryminus_expr", 
			"expr", "term", "cond", "and_cond", "not_cond", "cmpop", "mulop", "addop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'['", "']'", "'string'", "'='", "'int'", "'float'", "'('", 
			"')'", "'{'", "'return'", "'}'", "'main'", "'read'", "'print'", "'if'", 
			"'else'", "'while'", "'for'", "'-'", "'||'", "'&&'", "'!'", "'<'", "'<='", 
			"'>='", "'=='", "'!='", "'>'", "'*'", "'/'", "'%'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "IDENTIFIER", 
			"INT_LITERAL", "FLOAT_LITERAL", "STR_LITERAL", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MicroC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


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

	public MicroCParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public FunctionContext function;
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public Helper_functionsContext helper_functions() {
			return getRuleContext(Helper_functionsContext.class,0);
		}
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			decls();
			setState(73);
			helper_functions();
			setState(74);
			((ProgramContext)_localctx).function = function();
			ast = ((ProgramContext)_localctx).function.node;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclsContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public DeclsContext decls() {
			return getRuleContext(DeclsContext.class,0);
		}
		public Str_declContext str_decl() {
			return getRuleContext(Str_declContext.class,0);
		}
		public DeclsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterDecls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitDecls(this);
		}
	}

	public final DeclsContext decls() throws RecognitionException {
		DeclsContext _localctx = new DeclsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_decls);
		try {
			setState(84);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				var_decl();
				setState(78);
				decls();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				str_decl();
				setState(81);
				decls();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declsContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_declsContext var_decls() {
			return getRuleContext(Var_declsContext.class,0);
		}
		public Var_declsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterVar_decls(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitVar_decls(this);
		}
	}

	public final Var_declsContext var_decls() throws RecognitionException {
		Var_declsContext _localctx = new Var_declsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_var_decls);
		try {
			setState(90);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				var_decl();
				setState(87);
				var_decls();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(MicroCParser.IDENTIFIER, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public Base_typeContext base_type;
		public IdContext id;
		public Token len;
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode INT_LITERAL() { return getToken(MicroCParser.INT_LITERAL, 0); }
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitVar_decl(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_var_decl);
		try {
			setState(107);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				((Var_declContext)_localctx).base_type = base_type();
				setState(95);
				((Var_declContext)_localctx).id = id();
				setState(96);
				match(T__0);
				st.addVariable(((Var_declContext)_localctx).base_type.t, (((Var_declContext)_localctx).id!=null?_input.getText(((Var_declContext)_localctx).id.start,((Var_declContext)_localctx).id.stop):null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				((Var_declContext)_localctx).base_type = base_type();
				setState(100);
				((Var_declContext)_localctx).id = id();
				setState(101);
				match(T__1);
				setState(102);
				((Var_declContext)_localctx).len = match(INT_LITERAL);
				setState(103);
				match(T__2);
				setState(104);
				match(T__0);
				st.addArray(((Var_declContext)_localctx).base_type.t, (((Var_declContext)_localctx).id!=null?_input.getText(((Var_declContext)_localctx).id.start,((Var_declContext)_localctx).id.stop):null), Integer.parseInt((((Var_declContext)_localctx).len!=null?((Var_declContext)_localctx).len.getText():null)));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Str_declContext extends ParserRuleContext {
		public IdContext id;
		public Token val;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode STR_LITERAL() { return getToken(MicroCParser.STR_LITERAL, 0); }
		public Str_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterStr_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitStr_decl(this);
		}
	}

	public final Str_declContext str_decl() throws RecognitionException {
		Str_declContext _localctx = new Str_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_str_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(T__3);
			setState(110);
			((Str_declContext)_localctx).id = id();
			setState(111);
			match(T__4);
			setState(112);
			((Str_declContext)_localctx).val = match(STR_LITERAL);
			setState(113);
			match(T__0);
			st.addVariable(Scope.Type.STRING, (((Str_declContext)_localctx).id!=null?_input.getText(((Str_declContext)_localctx).id.start,((Str_declContext)_localctx).id.stop):null), (((Str_declContext)_localctx).val!=null?((Str_declContext)_localctx).val.getText():null));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_typeContext extends ParserRuleContext {
		public Scope.Type t;
		public Base_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBase_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBase_type(this);
		}
	}

	public final Base_typeContext base_type() throws RecognitionException {
		Base_typeContext _localctx = new Base_typeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_base_type);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(T__5);
				((Base_typeContext)_localctx).t =  Scope.Type.INT;
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(118);
				match(T__6);
				((Base_typeContext)_localctx).t =  Scope.Type.FLOAT;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Helper_functionsContext extends ParserRuleContext {
		public Helper_functionContext helper_function() {
			return getRuleContext(Helper_functionContext.class,0);
		}
		public Helper_functionsContext helper_functions() {
			return getRuleContext(Helper_functionsContext.class,0);
		}
		public Helper_functionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_helper_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterHelper_functions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitHelper_functions(this);
		}
	}

	public final Helper_functionsContext helper_functions() throws RecognitionException {
		Helper_functionsContext _localctx = new Helper_functionsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_helper_functions);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				helper_function();
				setState(123);
				helper_functions();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Helper_functionContext extends ParserRuleContext {
		public Base_typeContext ret;
		public IdContext fname;
		public Base_typeContext paramType;
		public IdContext param;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<Base_typeContext> base_type() {
			return getRuleContexts(Base_typeContext.class);
		}
		public Base_typeContext base_type(int i) {
			return getRuleContext(Base_typeContext.class,i);
		}
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public Helper_functionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_helper_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterHelper_function(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitHelper_function(this);
		}
	}

	public final Helper_functionContext helper_function() throws RecognitionException {
		Helper_functionContext _localctx = new Helper_functionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_helper_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			((Helper_functionContext)_localctx).ret = base_type();
			setState(129);
			((Helper_functionContext)_localctx).fname = id();
			setState(130);
			match(T__7);
			setState(131);
			((Helper_functionContext)_localctx).paramType = base_type();
			setState(132);
			((Helper_functionContext)_localctx).param = id();
			setState(133);
			match(T__8);

			          st.pushScope();
			          st.currentScope().setName((((Helper_functionContext)_localctx).fname!=null?_input.getText(((Helper_functionContext)_localctx).fname.start,((Helper_functionContext)_localctx).fname.stop):null));
			          st.addArgument(((Helper_functionContext)_localctx).paramType.t, (((Helper_functionContext)_localctx).param!=null?_input.getText(((Helper_functionContext)_localctx).param.start,((Helper_functionContext)_localctx).param.stop):null));
			      
			setState(135);
			match(T__9);
			setState(136);
			match(T__10);
			setState(137);
			((Helper_functionContext)_localctx).expr = expr(0);
			setState(138);
			match(T__0);
			setState(139);
			match(T__11);

			          defineInlineFunction((((Helper_functionContext)_localctx).fname!=null?_input.getText(((Helper_functionContext)_localctx).fname.start,((Helper_functionContext)_localctx).fname.stop):null), ((Helper_functionContext)_localctx).paramType.t, (((Helper_functionContext)_localctx).param!=null?_input.getText(((Helper_functionContext)_localctx).param.start,((Helper_functionContext)_localctx).param.stop):null), ((Helper_functionContext)_localctx).expr.node);
			          st.popScope();
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public StatementListNode node;
		public StatementsContext statements;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(T__5);
			setState(143);
			match(T__12);
			setState(144);
			match(T__7);
			setState(145);
			match(T__8);

			        st.pushScope();
			        st.currentScope().setName("main");
			    
			setState(147);
			match(T__9);
			setState(148);
			((FunctionContext)_localctx).statements = statements();
			setState(149);
			match(T__11);

			        ((FunctionContext)_localctx).node =  ((FunctionContext)_localctx).statements.node;
			        st.popScope();
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public StatementListNode node;
		public StatementContext statement;
		public StatementsContext s;
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statements);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
			case T__6:
			case T__9:
			case T__10:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__18:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				((StatementsContext)_localctx).statement = statement();
				setState(153);
				((StatementsContext)_localctx).s = statements();
				((StatementsContext)_localctx).node =  new StatementListNode(((StatementsContext)_localctx).statement.node, ((StatementsContext)_localctx).s.node);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 2);
				{
				((StatementsContext)_localctx).node =  new StatementListNode();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementNode node;
		public Base_stmtContext base_stmt;
		public Local_var_declContext local_var_decl;
		public If_stmtContext if_stmt;
		public While_stmtContext while_stmt;
		public For_stmtContext for_stmt;
		public Block_stmtContext block_stmt;
		public Base_stmtContext base_stmt() {
			return getRuleContext(Base_stmtContext.class,0);
		}
		public Local_var_declContext local_var_decl() {
			return getRuleContext(Local_var_declContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Block_stmtContext block_stmt() {
			return getRuleContext(Block_stmtContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_statement);
		try {
			setState(179);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__13:
			case T__14:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				((StatementContext)_localctx).base_stmt = base_stmt();
				setState(160);
				match(T__0);
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).base_stmt.node;
				}
				break;
			case T__5:
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(163);
				((StatementContext)_localctx).local_var_decl = local_var_decl();
				setState(164);
				match(T__0);
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).local_var_decl.node;
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 3);
				{
				setState(167);
				((StatementContext)_localctx).if_stmt = if_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).if_stmt.node;
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 4);
				{
				setState(170);
				((StatementContext)_localctx).while_stmt = while_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).while_stmt.node;
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 5);
				{
				setState(173);
				((StatementContext)_localctx).for_stmt = for_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).for_stmt.node;
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(176);
				((StatementContext)_localctx).block_stmt = block_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).block_stmt.node;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Base_stmtContext extends ParserRuleContext {
		public StatementNode node;
		public Assign_stmtContext assign_stmt;
		public Read_stmtContext read_stmt;
		public Print_stmtContext print_stmt;
		public Return_stmtContext return_stmt;
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public Read_stmtContext read_stmt() {
			return getRuleContext(Read_stmtContext.class,0);
		}
		public Print_stmtContext print_stmt() {
			return getRuleContext(Print_stmtContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Base_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_base_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBase_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBase_stmt(this);
		}
	}

	public final Base_stmtContext base_stmt() throws RecognitionException {
		Base_stmtContext _localctx = new Base_stmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_base_stmt);
		try {
			setState(193);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(181);
				((Base_stmtContext)_localctx).assign_stmt = assign_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).assign_stmt.node;
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				((Base_stmtContext)_localctx).read_stmt = read_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).read_stmt.node;
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 3);
				{
				setState(187);
				((Base_stmtContext)_localctx).print_stmt = print_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).print_stmt.node;
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 4);
				{
				setState(190);
				((Base_stmtContext)_localctx).return_stmt = return_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).return_stmt.node;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Local_var_declContext extends ParserRuleContext {
		public StatementNode node;
		public Base_typeContext base_type;
		public IdContext id;
		public ExprContext expr;
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Local_var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterLocal_var_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitLocal_var_decl(this);
		}
	}

	public final Local_var_declContext local_var_decl() throws RecognitionException {
		Local_var_declContext _localctx = new Local_var_declContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_local_var_decl);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				((Local_var_declContext)_localctx).base_type = base_type();
				setState(196);
				((Local_var_declContext)_localctx).id = id();

				        st.addVariable(((Local_var_declContext)_localctx).base_type.t, (((Local_var_declContext)_localctx).id!=null?_input.getText(((Local_var_declContext)_localctx).id.start,((Local_var_declContext)_localctx).id.stop):null));
				        ((Local_var_declContext)_localctx).node =  new EmptyStatementNode();
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				((Local_var_declContext)_localctx).base_type = base_type();
				setState(200);
				((Local_var_declContext)_localctx).id = id();
				setState(201);
				match(T__4);
				setState(202);
				((Local_var_declContext)_localctx).expr = expr(0);

				        st.addVariable(((Local_var_declContext)_localctx).base_type.t, (((Local_var_declContext)_localctx).id!=null?_input.getText(((Local_var_declContext)_localctx).id.start,((Local_var_declContext)_localctx).id.stop):null));
				        ((Local_var_declContext)_localctx).node =  new AssignNode(new VarNode((((Local_var_declContext)_localctx).id!=null?_input.getText(((Local_var_declContext)_localctx).id.start,((Local_var_declContext)_localctx).id.stop):null)), ((Local_var_declContext)_localctx).expr.node);
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Read_stmtContext extends ParserRuleContext {
		public ReadNode node;
		public IdContext id;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Read_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_read_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterRead_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitRead_stmt(this);
		}
	}

	public final Read_stmtContext read_stmt() throws RecognitionException {
		Read_stmtContext _localctx = new Read_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__13);
			setState(208);
			match(T__7);
			setState(209);
			((Read_stmtContext)_localctx).id = id();
			setState(210);
			match(T__8);
			((Read_stmtContext)_localctx).node =  new ReadNode(new VarNode((((Read_stmtContext)_localctx).id!=null?_input.getText(((Read_stmtContext)_localctx).id.start,((Read_stmtContext)_localctx).id.stop):null)));
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Print_stmtContext extends ParserRuleContext {
		public WriteNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Print_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterPrint_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitPrint_stmt(this);
		}
	}

	public final Print_stmtContext print_stmt() throws RecognitionException {
		Print_stmtContext _localctx = new Print_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_print_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__14);
			setState(214);
			match(T__7);
			setState(215);
			((Print_stmtContext)_localctx).expr = expr(0);
			setState(216);
			match(T__8);
			((Print_stmtContext)_localctx).node =  new WriteNode(((Print_stmtContext)_localctx).expr.node);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return_stmtContext extends ParserRuleContext {
		public ReturnNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitReturn_stmt(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(T__10);
			setState(220);
			((Return_stmtContext)_localctx).expr = expr(0);
			((Return_stmtContext)_localctx).node =  new ReturnNode(((Return_stmtContext)_localctx).expr.node);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assign_stmtContext extends ParserRuleContext {
		public AssignNode node;
		public LvalueContext lhs;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAssign_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAssign_stmt(this);
		}
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			((Assign_stmtContext)_localctx).lhs = lvalue();
			setState(224);
			match(T__4);
			setState(225);
			((Assign_stmtContext)_localctx).expr = expr(0);
			((Assign_stmtContext)_localctx).node =  new AssignNode(((Assign_stmtContext)_localctx).lhs.node, ((Assign_stmtContext)_localctx).expr.node);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_stmtContext extends ParserRuleContext {
		public IfStatementNode node;
		public CondContext cond;
		public StatementsContext thenStatements;
		public Else_stmtContext else_stmt;
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public Else_stmtContext else_stmt() {
			return getRuleContext(Else_stmtContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitIf_stmt(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__15);
			setState(229);
			match(T__7);
			setState(230);
			((If_stmtContext)_localctx).cond = cond(0);
			setState(231);
			match(T__8);
			setState(232);
			match(T__9);
			 st.pushScope(); 
			setState(234);
			((If_stmtContext)_localctx).thenStatements = statements();
			setState(235);
			match(T__11);
			 st.popScope(); 
			setState(237);
			((If_stmtContext)_localctx).else_stmt = else_stmt();
			((If_stmtContext)_localctx).node =  new IfStatementNode(((If_stmtContext)_localctx).cond.node, ((If_stmtContext)_localctx).thenStatements.node, ((If_stmtContext)_localctx).else_stmt.node);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Else_stmtContext extends ParserRuleContext {
		public StatementListNode node;
		public StatementsContext elseStatements;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Else_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterElse_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitElse_stmt(this);
		}
	}

	public final Else_stmtContext else_stmt() throws RecognitionException {
		Else_stmtContext _localctx = new Else_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_else_stmt);
		try {
			setState(248);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(240);
				match(T__16);
				setState(241);
				match(T__9);
				 st.pushScope(); 
				setState(243);
				((Else_stmtContext)_localctx).elseStatements = statements();
				setState(244);
				match(T__11);
				 ((Else_stmtContext)_localctx).node =  ((Else_stmtContext)_localctx).elseStatements.node; st.popScope(); 
				}
				break;
			case T__5:
			case T__6:
			case T__9:
			case T__10:
			case T__11:
			case T__13:
			case T__14:
			case T__15:
			case T__17:
			case T__18:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				((Else_stmtContext)_localctx).node =  new StatementListNode();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_stmtContext extends ParserRuleContext {
		public WhileNode node;
		public CondContext cond;
		public StatementsContext statements;
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitWhile_stmt(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(T__17);
			setState(251);
			match(T__7);
			setState(252);
			((While_stmtContext)_localctx).cond = cond(0);
			setState(253);
			match(T__8);
			setState(254);
			match(T__9);
			 st.pushScope(); 
			setState(256);
			((While_stmtContext)_localctx).statements = statements();
			setState(257);
			match(T__11);
			 ((While_stmtContext)_localctx).node =  new WhileNode(((While_stmtContext)_localctx).cond.node, ((While_stmtContext)_localctx).statements.node); st.popScope(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_stmtContext extends ParserRuleContext {
		public StatementNode node;
		public For_assign_optContext init;
		public CondContext test;
		public For_assign_optContext step;
		public StatementsContext body;
		public List<For_assign_optContext> for_assign_opt() {
			return getRuleContexts(For_assign_optContext.class);
		}
		public For_assign_optContext for_assign_opt(int i) {
			return getRuleContext(For_assign_optContext.class,i);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitFor_stmt(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_for_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__18);
			setState(261);
			match(T__7);
			setState(262);
			((For_stmtContext)_localctx).init = for_assign_opt();
			setState(263);
			match(T__0);
			setState(264);
			((For_stmtContext)_localctx).test = cond(0);
			setState(265);
			match(T__0);
			setState(266);
			((For_stmtContext)_localctx).step = for_assign_opt();
			setState(267);
			match(T__8);
			setState(268);
			match(T__9);
			 st.pushScope(); 
			setState(270);
			((For_stmtContext)_localctx).body = statements();
			setState(271);
			match(T__11);

			          StatementListNode loopBody = ((For_stmtContext)_localctx).body.node;
			          if (!(((For_stmtContext)_localctx).step.node instanceof EmptyStatementNode)) {
			              loopBody = new StatementListNode(loopBody, ((For_stmtContext)_localctx).step.node);
			          }

			          StatementNode loweredLoop = new WhileNode(((For_stmtContext)_localctx).test.node, loopBody);
			          if (((For_stmtContext)_localctx).init.node instanceof EmptyStatementNode) {
			              ((For_stmtContext)_localctx).node =  new BlockNode(new StatementListNode(loweredLoop));
			          } else {
			              ((For_stmtContext)_localctx).node =  new BlockNode(new StatementListNode(new StatementListNode(((For_stmtContext)_localctx).init.node), loweredLoop));
			          }
			          st.popScope();
			      
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_assign_optContext extends ParserRuleContext {
		public StatementNode node;
		public Assign_stmtContext assign_stmt;
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public For_assign_optContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_assign_opt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterFor_assign_opt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitFor_assign_opt(this);
		}
	}

	public final For_assign_optContext for_assign_opt() throws RecognitionException {
		For_assign_optContext _localctx = new For_assign_optContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_for_assign_opt);
		try {
			setState(278);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				((For_assign_optContext)_localctx).assign_stmt = assign_stmt();
				((For_assign_optContext)_localctx).node =  ((For_assign_optContext)_localctx).assign_stmt.node;
				}
				break;
			case T__0:
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				((For_assign_optContext)_localctx).node =  new EmptyStatementNode();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LvalueContext extends ParserRuleContext {
		public TypedASTNode node;
		public IdContext id;
		public Array_accessContext array_access;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitLvalue(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		LvalueContext _localctx = new LvalueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_lvalue);
		try {
			setState(286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(280);
				((LvalueContext)_localctx).id = id();
				((LvalueContext)_localctx).node =  new VarNode((((LvalueContext)_localctx).id!=null?_input.getText(((LvalueContext)_localctx).id.start,((LvalueContext)_localctx).id.stop):null));
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(283);
				((LvalueContext)_localctx).array_access = array_access();
				((LvalueContext)_localctx).node =  ((LvalueContext)_localctx).array_access.node;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Array_accessContext extends ParserRuleContext {
		public ArrayAccessNode node;
		public IdContext id;
		public ExprContext expr;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Array_accessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_access; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterArray_access(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitArray_access(this);
		}
	}

	public final Array_accessContext array_access() throws RecognitionException {
		Array_accessContext _localctx = new Array_accessContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_array_access);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			((Array_accessContext)_localctx).id = id();
			setState(289);
			match(T__1);
			setState(290);
			((Array_accessContext)_localctx).expr = expr(0);
			setState(291);
			match(T__2);
			((Array_accessContext)_localctx).node =  new ArrayAccessNode((((Array_accessContext)_localctx).id!=null?_input.getText(((Array_accessContext)_localctx).id.start,((Array_accessContext)_localctx).id.stop):null), ((Array_accessContext)_localctx).expr.node);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_stmtContext extends ParserRuleContext {
		public BlockNode node;
		public StatementsContext statements;
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public Block_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterBlock_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitBlock_stmt(this);
		}
	}

	public final Block_stmtContext block_stmt() throws RecognitionException {
		Block_stmtContext _localctx = new Block_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_block_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			match(T__9);
			 st.pushScope(); 
			setState(296);
			((Block_stmtContext)_localctx).statements = statements();
			setState(297);
			match(T__11);
			 ((Block_stmtContext)_localctx).node =  new BlockNode(((Block_stmtContext)_localctx).statements.node); st.popScope(); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public ExpressionNode node;
		public IdContext call;
		public ExprContext arg;
		public Array_accessContext array_access;
		public IdContext id;
		public ExprContext expr;
		public Unaryminus_exprContext unaryminus_expr;
		public Token il;
		public Token fl;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Array_accessContext array_access() {
			return getRuleContext(Array_accessContext.class,0);
		}
		public Unaryminus_exprContext unaryminus_expr() {
			return getRuleContext(Unaryminus_exprContext.class,0);
		}
		public TerminalNode INT_LITERAL() { return getToken(MicroCParser.INT_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(MicroCParser.FLOAT_LITERAL, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_primary);
		try {
			setState(324);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(300);
				((PrimaryContext)_localctx).call = id();
				setState(301);
				match(T__7);
				setState(302);
				((PrimaryContext)_localctx).arg = expr(0);
				setState(303);
				match(T__8);
				((PrimaryContext)_localctx).node =  inlineCall((((PrimaryContext)_localctx).call!=null?_input.getText(((PrimaryContext)_localctx).call.start,((PrimaryContext)_localctx).call.stop):null), ((PrimaryContext)_localctx).arg.node);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(306);
				((PrimaryContext)_localctx).array_access = array_access();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).array_access.node;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(309);
				((PrimaryContext)_localctx).id = id();
				((PrimaryContext)_localctx).node =  new VarNode((((PrimaryContext)_localctx).id!=null?_input.getText(((PrimaryContext)_localctx).id.start,((PrimaryContext)_localctx).id.stop):null));
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				match(T__7);
				setState(313);
				((PrimaryContext)_localctx).expr = expr(0);
				setState(314);
				match(T__8);
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).expr.node;
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(317);
				((PrimaryContext)_localctx).unaryminus_expr = unaryminus_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).unaryminus_expr.node;
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(320);
				((PrimaryContext)_localctx).il = match(INT_LITERAL);
				((PrimaryContext)_localctx).node =  new IntLitNode((((PrimaryContext)_localctx).il!=null?((PrimaryContext)_localctx).il.getText():null));
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(322);
				((PrimaryContext)_localctx).fl = match(FLOAT_LITERAL);
				((PrimaryContext)_localctx).node =  new FloatLitNode((((PrimaryContext)_localctx).fl!=null?((PrimaryContext)_localctx).fl.getText():null));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Unaryminus_exprContext extends ParserRuleContext {
		public ExpressionNode node;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unaryminus_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryminus_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterUnaryminus_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitUnaryminus_expr(this);
		}
	}

	public final Unaryminus_exprContext unaryminus_expr() throws RecognitionException {
		Unaryminus_exprContext _localctx = new Unaryminus_exprContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_unaryminus_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(T__19);
			setState(327);
			((Unaryminus_exprContext)_localctx).expr = expr(0);
			((Unaryminus_exprContext)_localctx).node =  new UnaryOpNode(((Unaryminus_exprContext)_localctx).expr.node,"-"); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExpressionNode node;
		public ExprContext e1;
		public TermContext term;
		public AddopContext addop;
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public AddopContext addop() {
			return getRuleContext(AddopContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(331);
			((ExprContext)_localctx).term = term(0);
			((ExprContext)_localctx).node =  ((ExprContext)_localctx).term.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expr);
					setState(334);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(335);
					((ExprContext)_localctx).addop = addop();
					setState(336);
					((ExprContext)_localctx).term = term(0);
					 ((ExprContext)_localctx).node =  new BinaryOpNode(((ExprContext)_localctx).e1.node, ((ExprContext)_localctx).term.node, (((ExprContext)_localctx).addop!=null?_input.getText(((ExprContext)_localctx).addop.start,((ExprContext)_localctx).addop.stop):null));  
					}
					} 
				}
				setState(343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public ExpressionNode node;
		public TermContext t1;
		public PrimaryContext primary;
		public MulopContext mulop;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public MulopContext mulop() {
			return getRuleContext(MulopContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(345);
			((TermContext)_localctx).primary = primary();
			((TermContext)_localctx).node =  ((TermContext)_localctx).primary.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(355);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					_localctx.t1 = _prevctx;
					_localctx.t1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(348);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(349);
					((TermContext)_localctx).mulop = mulop();
					setState(350);
					((TermContext)_localctx).primary = primary();
					 ((TermContext)_localctx).node =  new BinaryOpNode(((TermContext)_localctx).t1.node, ((TermContext)_localctx).primary.node, (((TermContext)_localctx).mulop!=null?_input.getText(((TermContext)_localctx).mulop.start,((TermContext)_localctx).mulop.stop):null));  
					}
					} 
				}
				setState(357);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CondContext extends ParserRuleContext {
		public ConditionNode node;
		public CondContext c1;
		public And_condContext and_cond;
		public And_condContext c2;
		public And_condContext and_cond() {
			return getRuleContext(And_condContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitCond(this);
		}
	}

	public final CondContext cond() throws RecognitionException {
		return cond(0);
	}

	private CondContext cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CondContext _localctx = new CondContext(_ctx, _parentState);
		CondContext _prevctx = _localctx;
		int _startState = 60;
		enterRecursionRule(_localctx, 60, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(359);
			((CondContext)_localctx).and_cond = and_cond(0);
			((CondContext)_localctx).node =  ((CondContext)_localctx).and_cond.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(369);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new CondContext(_parentctx, _parentState);
					_localctx.c1 = _prevctx;
					_localctx.c1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_cond);
					setState(362);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(363);
					match(T__20);
					setState(364);
					((CondContext)_localctx).c2 = ((CondContext)_localctx).and_cond = and_cond(0);
					((CondContext)_localctx).node =  new LogicalOrNode(((CondContext)_localctx).c1.node, ((CondContext)_localctx).c2.node);
					}
					} 
				}
				setState(371);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class And_condContext extends ParserRuleContext {
		public ConditionNode node;
		public And_condContext c1;
		public Not_condContext not_cond;
		public Not_condContext c2;
		public Not_condContext not_cond() {
			return getRuleContext(Not_condContext.class,0);
		}
		public And_condContext and_cond() {
			return getRuleContext(And_condContext.class,0);
		}
		public And_condContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAnd_cond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAnd_cond(this);
		}
	}

	public final And_condContext and_cond() throws RecognitionException {
		return and_cond(0);
	}

	private And_condContext and_cond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		And_condContext _localctx = new And_condContext(_ctx, _parentState);
		And_condContext _prevctx = _localctx;
		int _startState = 62;
		enterRecursionRule(_localctx, 62, RULE_and_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(373);
			((And_condContext)_localctx).not_cond = not_cond();
			((And_condContext)_localctx).node =  ((And_condContext)_localctx).not_cond.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(383);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_condContext(_parentctx, _parentState);
					_localctx.c1 = _prevctx;
					_localctx.c1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_and_cond);
					setState(376);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(377);
					match(T__21);
					setState(378);
					((And_condContext)_localctx).c2 = ((And_condContext)_localctx).not_cond = not_cond();
					((And_condContext)_localctx).node =  new LogicalAndNode(((And_condContext)_localctx).c1.node, ((And_condContext)_localctx).c2.node);
					}
					} 
				}
				setState(385);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Not_condContext extends ParserRuleContext {
		public ConditionNode node;
		public Not_condContext not_cond;
		public CondContext cond;
		public ExprContext e1;
		public CmpopContext cmpop;
		public ExprContext e2;
		public Not_condContext not_cond() {
			return getRuleContext(Not_condContext.class,0);
		}
		public CondContext cond() {
			return getRuleContext(CondContext.class,0);
		}
		public CmpopContext cmpop() {
			return getRuleContext(CmpopContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Not_condContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_not_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterNot_cond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitNot_cond(this);
		}
	}

	public final Not_condContext not_cond() throws RecognitionException {
		Not_condContext _localctx = new Not_condContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_not_cond);
		try {
			setState(400);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(386);
				match(T__22);
				setState(387);
				((Not_condContext)_localctx).not_cond = not_cond();
				((Not_condContext)_localctx).node =  new LogicalNotNode(((Not_condContext)_localctx).not_cond.node);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(390);
				match(T__7);
				setState(391);
				((Not_condContext)_localctx).cond = cond(0);
				setState(392);
				match(T__8);
				((Not_condContext)_localctx).node =  ((Not_condContext)_localctx).cond.node;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(395);
				((Not_condContext)_localctx).e1 = expr(0);
				setState(396);
				((Not_condContext)_localctx).cmpop = cmpop();
				setState(397);
				((Not_condContext)_localctx).e2 = expr(0);
				((Not_condContext)_localctx).node =  new CondNode(((Not_condContext)_localctx).e1.node, ((Not_condContext)_localctx).e2.node, (((Not_condContext)_localctx).cmpop!=null?_input.getText(((Not_condContext)_localctx).cmpop.start,((Not_condContext)_localctx).cmpop.stop):null));
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CmpopContext extends ParserRuleContext {
		public CmpopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmpop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterCmpop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitCmpop(this);
		}
	}

	public final CmpopContext cmpop() throws RecognitionException {
		CmpopContext _localctx = new CmpopContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_cmpop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(402);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MulopContext extends ParserRuleContext {
		public MulopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterMulop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitMulop(this);
		}
	}

	public final MulopContext mulop() throws RecognitionException {
		MulopContext _localctx = new MulopContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__29) | (1L << T__30) | (1L << T__31))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddopContext extends ParserRuleContext {
		public AddopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).enterAddop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroCListener ) ((MicroCListener)listener).exitAddop(this);
		}
	}

	public final AddopContext addop() throws RecognitionException {
		AddopContext _localctx = new AddopContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(406);
			_la = _input.LA(1);
			if ( !(_la==T__19 || _la==T__32) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 29:
			return term_sempred((TermContext)_localctx, predIndex);
		case 30:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 31:
			return and_cond_sempred((And_condContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean cond_sempred(CondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean and_cond_sempred(And_condContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u019b\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3W\n\3\3\4\3\4\3\4\3\4\5\4]\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6n\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\5\b{\n\b\3\t\3\t\3\t\3\t\5\t\u0081\n\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00a0\n\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5"+
		"\r\u00b6\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\5\16\u00c4\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\5\17\u00d0\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\5\25\u00fb\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\5\30\u0119\n\30\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\5\31\u0121\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0147\n\34"+
		"\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\7\36"+
		"\u0156\n\36\f\36\16\36\u0159\13\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\7\37\u0164\n\37\f\37\16\37\u0167\13\37\3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \7 \u0172\n \f \16 \u0175\13 \3!\3!\3!\3!\3!\3!\3!\3!\3!\7!\u0180"+
		"\n!\f!\16!\u0183\13!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3"+
		"\"\3\"\5\"\u0193\n\"\3#\3#\3$\3$\3%\3%\3%\2\6:<>@&\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\5\3\2\32\37\3\2 \""+
		"\4\2\26\26##\2\u0195\2J\3\2\2\2\4V\3\2\2\2\6\\\3\2\2\2\b^\3\2\2\2\nm\3"+
		"\2\2\2\fo\3\2\2\2\16z\3\2\2\2\20\u0080\3\2\2\2\22\u0082\3\2\2\2\24\u0090"+
		"\3\2\2\2\26\u009f\3\2\2\2\30\u00b5\3\2\2\2\32\u00c3\3\2\2\2\34\u00cf\3"+
		"\2\2\2\36\u00d1\3\2\2\2 \u00d7\3\2\2\2\"\u00dd\3\2\2\2$\u00e1\3\2\2\2"+
		"&\u00e6\3\2\2\2(\u00fa\3\2\2\2*\u00fc\3\2\2\2,\u0106\3\2\2\2.\u0118\3"+
		"\2\2\2\60\u0120\3\2\2\2\62\u0122\3\2\2\2\64\u0128\3\2\2\2\66\u0146\3\2"+
		"\2\28\u0148\3\2\2\2:\u014c\3\2\2\2<\u015a\3\2\2\2>\u0168\3\2\2\2@\u0176"+
		"\3\2\2\2B\u0192\3\2\2\2D\u0194\3\2\2\2F\u0196\3\2\2\2H\u0198\3\2\2\2J"+
		"K\5\4\3\2KL\5\20\t\2LM\5\24\13\2MN\b\2\1\2N\3\3\2\2\2OP\5\n\6\2PQ\5\4"+
		"\3\2QW\3\2\2\2RS\5\f\7\2ST\5\4\3\2TW\3\2\2\2UW\3\2\2\2VO\3\2\2\2VR\3\2"+
		"\2\2VU\3\2\2\2W\5\3\2\2\2XY\5\n\6\2YZ\5\6\4\2Z]\3\2\2\2[]\3\2\2\2\\X\3"+
		"\2\2\2\\[\3\2\2\2]\7\3\2\2\2^_\7$\2\2_\t\3\2\2\2`a\5\16\b\2ab\5\b\5\2"+
		"bc\7\3\2\2cd\b\6\1\2dn\3\2\2\2ef\5\16\b\2fg\5\b\5\2gh\7\4\2\2hi\7%\2\2"+
		"ij\7\5\2\2jk\7\3\2\2kl\b\6\1\2ln\3\2\2\2m`\3\2\2\2me\3\2\2\2n\13\3\2\2"+
		"\2op\7\6\2\2pq\5\b\5\2qr\7\7\2\2rs\7\'\2\2st\7\3\2\2tu\b\7\1\2u\r\3\2"+
		"\2\2vw\7\b\2\2w{\b\b\1\2xy\7\t\2\2y{\b\b\1\2zv\3\2\2\2zx\3\2\2\2{\17\3"+
		"\2\2\2|}\5\22\n\2}~\5\20\t\2~\u0081\3\2\2\2\177\u0081\3\2\2\2\u0080|\3"+
		"\2\2\2\u0080\177\3\2\2\2\u0081\21\3\2\2\2\u0082\u0083\5\16\b\2\u0083\u0084"+
		"\5\b\5\2\u0084\u0085\7\n\2\2\u0085\u0086\5\16\b\2\u0086\u0087\5\b\5\2"+
		"\u0087\u0088\7\13\2\2\u0088\u0089\b\n\1\2\u0089\u008a\7\f\2\2\u008a\u008b"+
		"\7\r\2\2\u008b\u008c\5:\36\2\u008c\u008d\7\3\2\2\u008d\u008e\7\16\2\2"+
		"\u008e\u008f\b\n\1\2\u008f\23\3\2\2\2\u0090\u0091\7\b\2\2\u0091\u0092"+
		"\7\17\2\2\u0092\u0093\7\n\2\2\u0093\u0094\7\13\2\2\u0094\u0095\b\13\1"+
		"\2\u0095\u0096\7\f\2\2\u0096\u0097\5\26\f\2\u0097\u0098\7\16\2\2\u0098"+
		"\u0099\b\13\1\2\u0099\25\3\2\2\2\u009a\u009b\5\30\r\2\u009b\u009c\5\26"+
		"\f\2\u009c\u009d\b\f\1\2\u009d\u00a0\3\2\2\2\u009e\u00a0\b\f\1\2\u009f"+
		"\u009a\3\2\2\2\u009f\u009e\3\2\2\2\u00a0\27\3\2\2\2\u00a1\u00a2\5\32\16"+
		"\2\u00a2\u00a3\7\3\2\2\u00a3\u00a4\b\r\1\2\u00a4\u00b6\3\2\2\2\u00a5\u00a6"+
		"\5\34\17\2\u00a6\u00a7\7\3\2\2\u00a7\u00a8\b\r\1\2\u00a8\u00b6\3\2\2\2"+
		"\u00a9\u00aa\5&\24\2\u00aa\u00ab\b\r\1\2\u00ab\u00b6\3\2\2\2\u00ac\u00ad"+
		"\5*\26\2\u00ad\u00ae\b\r\1\2\u00ae\u00b6\3\2\2\2\u00af\u00b0\5,\27\2\u00b0"+
		"\u00b1\b\r\1\2\u00b1\u00b6\3\2\2\2\u00b2\u00b3\5\64\33\2\u00b3\u00b4\b"+
		"\r\1\2\u00b4\u00b6\3\2\2\2\u00b5\u00a1\3\2\2\2\u00b5\u00a5\3\2\2\2\u00b5"+
		"\u00a9\3\2\2\2\u00b5\u00ac\3\2\2\2\u00b5\u00af\3\2\2\2\u00b5\u00b2\3\2"+
		"\2\2\u00b6\31\3\2\2\2\u00b7\u00b8\5$\23\2\u00b8\u00b9\b\16\1\2\u00b9\u00c4"+
		"\3\2\2\2\u00ba\u00bb\5\36\20\2\u00bb\u00bc\b\16\1\2\u00bc\u00c4\3\2\2"+
		"\2\u00bd\u00be\5 \21\2\u00be\u00bf\b\16\1\2\u00bf\u00c4\3\2\2\2\u00c0"+
		"\u00c1\5\"\22\2\u00c1\u00c2\b\16\1\2\u00c2\u00c4\3\2\2\2\u00c3\u00b7\3"+
		"\2\2\2\u00c3\u00ba\3\2\2\2\u00c3\u00bd\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4"+
		"\33\3\2\2\2\u00c5\u00c6\5\16\b\2\u00c6\u00c7\5\b\5\2\u00c7\u00c8\b\17"+
		"\1\2\u00c8\u00d0\3\2\2\2\u00c9\u00ca\5\16\b\2\u00ca\u00cb\5\b\5\2\u00cb"+
		"\u00cc\7\7\2\2\u00cc\u00cd\5:\36\2\u00cd\u00ce\b\17\1\2\u00ce\u00d0\3"+
		"\2\2\2\u00cf\u00c5\3\2\2\2\u00cf\u00c9\3\2\2\2\u00d0\35\3\2\2\2\u00d1"+
		"\u00d2\7\20\2\2\u00d2\u00d3\7\n\2\2\u00d3\u00d4\5\b\5\2\u00d4\u00d5\7"+
		"\13\2\2\u00d5\u00d6\b\20\1\2\u00d6\37\3\2\2\2\u00d7\u00d8\7\21\2\2\u00d8"+
		"\u00d9\7\n\2\2\u00d9\u00da\5:\36\2\u00da\u00db\7\13\2\2\u00db\u00dc\b"+
		"\21\1\2\u00dc!\3\2\2\2\u00dd\u00de\7\r\2\2\u00de\u00df\5:\36\2\u00df\u00e0"+
		"\b\22\1\2\u00e0#\3\2\2\2\u00e1\u00e2\5\60\31\2\u00e2\u00e3\7\7\2\2\u00e3"+
		"\u00e4\5:\36\2\u00e4\u00e5\b\23\1\2\u00e5%\3\2\2\2\u00e6\u00e7\7\22\2"+
		"\2\u00e7\u00e8\7\n\2\2\u00e8\u00e9\5> \2\u00e9\u00ea\7\13\2\2\u00ea\u00eb"+
		"\7\f\2\2\u00eb\u00ec\b\24\1\2\u00ec\u00ed\5\26\f\2\u00ed\u00ee\7\16\2"+
		"\2\u00ee\u00ef\b\24\1\2\u00ef\u00f0\5(\25\2\u00f0\u00f1\b\24\1\2\u00f1"+
		"\'\3\2\2\2\u00f2\u00f3\7\23\2\2\u00f3\u00f4\7\f\2\2\u00f4\u00f5\b\25\1"+
		"\2\u00f5\u00f6\5\26\f\2\u00f6\u00f7\7\16\2\2\u00f7\u00f8\b\25\1\2\u00f8"+
		"\u00fb\3\2\2\2\u00f9\u00fb\b\25\1\2\u00fa\u00f2\3\2\2\2\u00fa\u00f9\3"+
		"\2\2\2\u00fb)\3\2\2\2\u00fc\u00fd\7\24\2\2\u00fd\u00fe\7\n\2\2\u00fe\u00ff"+
		"\5> \2\u00ff\u0100\7\13\2\2\u0100\u0101\7\f\2\2\u0101\u0102\b\26\1\2\u0102"+
		"\u0103\5\26\f\2\u0103\u0104\7\16\2\2\u0104\u0105\b\26\1\2\u0105+\3\2\2"+
		"\2\u0106\u0107\7\25\2\2\u0107\u0108\7\n\2\2\u0108\u0109\5.\30\2\u0109"+
		"\u010a\7\3\2\2\u010a\u010b\5> \2\u010b\u010c\7\3\2\2\u010c\u010d\5.\30"+
		"\2\u010d\u010e\7\13\2\2\u010e\u010f\7\f\2\2\u010f\u0110\b\27\1\2\u0110"+
		"\u0111\5\26\f\2\u0111\u0112\7\16\2\2\u0112\u0113\b\27\1\2\u0113-\3\2\2"+
		"\2\u0114\u0115\5$\23\2\u0115\u0116\b\30\1\2\u0116\u0119\3\2\2\2\u0117"+
		"\u0119\b\30\1\2\u0118\u0114\3\2\2\2\u0118\u0117\3\2\2\2\u0119/\3\2\2\2"+
		"\u011a\u011b\5\b\5\2\u011b\u011c\b\31\1\2\u011c\u0121\3\2\2\2\u011d\u011e"+
		"\5\62\32\2\u011e\u011f\b\31\1\2\u011f\u0121\3\2\2\2\u0120\u011a\3\2\2"+
		"\2\u0120\u011d\3\2\2\2\u0121\61\3\2\2\2\u0122\u0123\5\b\5\2\u0123\u0124"+
		"\7\4\2\2\u0124\u0125\5:\36\2\u0125\u0126\7\5\2\2\u0126\u0127\b\32\1\2"+
		"\u0127\63\3\2\2\2\u0128\u0129\7\f\2\2\u0129\u012a\b\33\1\2\u012a\u012b"+
		"\5\26\f\2\u012b\u012c\7\16\2\2\u012c\u012d\b\33\1\2\u012d\65\3\2\2\2\u012e"+
		"\u012f\5\b\5\2\u012f\u0130\7\n\2\2\u0130\u0131\5:\36\2\u0131\u0132\7\13"+
		"\2\2\u0132\u0133\b\34\1\2\u0133\u0147\3\2\2\2\u0134\u0135\5\62\32\2\u0135"+
		"\u0136\b\34\1\2\u0136\u0147\3\2\2\2\u0137\u0138\5\b\5\2\u0138\u0139\b"+
		"\34\1\2\u0139\u0147\3\2\2\2\u013a\u013b\7\n\2\2\u013b\u013c\5:\36\2\u013c"+
		"\u013d\7\13\2\2\u013d\u013e\b\34\1\2\u013e\u0147\3\2\2\2\u013f\u0140\5"+
		"8\35\2\u0140\u0141\b\34\1\2\u0141\u0147\3\2\2\2\u0142\u0143\7%\2\2\u0143"+
		"\u0147\b\34\1\2\u0144\u0145\7&\2\2\u0145\u0147\b\34\1\2\u0146\u012e\3"+
		"\2\2\2\u0146\u0134\3\2\2\2\u0146\u0137\3\2\2\2\u0146\u013a\3\2\2\2\u0146"+
		"\u013f\3\2\2\2\u0146\u0142\3\2\2\2\u0146\u0144\3\2\2\2\u0147\67\3\2\2"+
		"\2\u0148\u0149\7\26\2\2\u0149\u014a\5:\36\2\u014a\u014b\b\35\1\2\u014b"+
		"9\3\2\2\2\u014c\u014d\b\36\1\2\u014d\u014e\5<\37\2\u014e\u014f\b\36\1"+
		"\2\u014f\u0157\3\2\2\2\u0150\u0151\f\3\2\2\u0151\u0152\5H%\2\u0152\u0153"+
		"\5<\37\2\u0153\u0154\b\36\1\2\u0154\u0156\3\2\2\2\u0155\u0150\3\2\2\2"+
		"\u0156\u0159\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158;\3"+
		"\2\2\2\u0159\u0157\3\2\2\2\u015a\u015b\b\37\1\2\u015b\u015c\5\66\34\2"+
		"\u015c\u015d\b\37\1\2\u015d\u0165\3\2\2\2\u015e\u015f\f\3\2\2\u015f\u0160"+
		"\5F$\2\u0160\u0161\5\66\34\2\u0161\u0162\b\37\1\2\u0162\u0164\3\2\2\2"+
		"\u0163\u015e\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166"+
		"\3\2\2\2\u0166=\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u0169\b \1\2\u0169\u016a"+
		"\5@!\2\u016a\u016b\b \1\2\u016b\u0173\3\2\2\2\u016c\u016d\f\4\2\2\u016d"+
		"\u016e\7\27\2\2\u016e\u016f\5@!\2\u016f\u0170\b \1\2\u0170\u0172\3\2\2"+
		"\2\u0171\u016c\3\2\2\2\u0172\u0175\3\2\2\2\u0173\u0171\3\2\2\2\u0173\u0174"+
		"\3\2\2\2\u0174?\3\2\2\2\u0175\u0173\3\2\2\2\u0176\u0177\b!\1\2\u0177\u0178"+
		"\5B\"\2\u0178\u0179\b!\1\2\u0179\u0181\3\2\2\2\u017a\u017b\f\4\2\2\u017b"+
		"\u017c\7\30\2\2\u017c\u017d\5B\"\2\u017d\u017e\b!\1\2\u017e\u0180\3\2"+
		"\2\2\u017f\u017a\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182A\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0185\7\31\2\2"+
		"\u0185\u0186\5B\"\2\u0186\u0187\b\"\1\2\u0187\u0193\3\2\2\2\u0188\u0189"+
		"\7\n\2\2\u0189\u018a\5> \2\u018a\u018b\7\13\2\2\u018b\u018c\b\"\1\2\u018c"+
		"\u0193\3\2\2\2\u018d\u018e\5:\36\2\u018e\u018f\5D#\2\u018f\u0190\5:\36"+
		"\2\u0190\u0191\b\"\1\2\u0191\u0193\3\2\2\2\u0192\u0184\3\2\2\2\u0192\u0188"+
		"\3\2\2\2\u0192\u018d\3\2\2\2\u0193C\3\2\2\2\u0194\u0195\t\2\2\2\u0195"+
		"E\3\2\2\2\u0196\u0197\t\3\2\2\u0197G\3\2\2\2\u0198\u0199\t\4\2\2\u0199"+
		"I\3\2\2\2\24V\\mz\u0080\u009f\u00b5\u00c3\u00cf\u00fa\u0118\u0120\u0146"+
		"\u0157\u0165\u0173\u0181\u0192";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}