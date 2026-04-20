// Generated from MicroC.g4 by ANTLR 4.8

    package compiler;

    import java.util.List;
    import java.util.LinkedList;
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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, IDENTIFIER=31, 
		INT_LITERAL=32, FLOAT_LITERAL=33, STR_LITERAL=34, COMMENT=35, WS=36;
	public static final int
		RULE_program = 0, RULE_decls = 1, RULE_var_decls = 2, RULE_id = 3, RULE_var_decl = 4, 
		RULE_str_decl = 5, RULE_base_type = 6, RULE_function = 7, RULE_statements = 8, 
		RULE_statement = 9, RULE_base_stmt = 10, RULE_local_var_decl = 11, RULE_read_stmt = 12, 
		RULE_print_stmt = 13, RULE_return_stmt = 14, RULE_assign_stmt = 15, RULE_if_stmt = 16, 
		RULE_else_stmt = 17, RULE_while_stmt = 18, RULE_block_stmt = 19, RULE_primary = 20, 
		RULE_unaryminus_expr = 21, RULE_expr = 22, RULE_term = 23, RULE_cond = 24, 
		RULE_and_cond = 25, RULE_not_cond = 26, RULE_cmpop = 27, RULE_mulop = 28, 
		RULE_addop = 29;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "decls", "var_decls", "id", "var_decl", "str_decl", "base_type", 
			"function", "statements", "statement", "base_stmt", "local_var_decl", 
			"read_stmt", "print_stmt", "return_stmt", "assign_stmt", "if_stmt", "else_stmt", 
			"while_stmt", "block_stmt", "primary", "unaryminus_expr", "expr", "term", 
			"cond", "and_cond", "not_cond", "cmpop", "mulop", "addop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'string'", "'='", "'int'", "'float'", "'main'", "'('", 
			"')'", "'{'", "'}'", "'read'", "'print'", "'return'", "'if'", "'else'", 
			"'while'", "'-'", "'||'", "'&&'", "'!'", "'<'", "'<='", "'>='", "'=='", 
			"'!='", "'>'", "'*'", "'/'", "'%'", "'+'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "IDENTIFIER", "INT_LITERAL", 
			"FLOAT_LITERAL", "STR_LITERAL", "COMMENT", "WS"
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

	     public void setSymbolTable(SymbolTable st) {
	          this.st = st;
	     }

	     public SymbolTable getSymbolTable() {
	          return st;
	     }

	     public ASTNode getAST() {
	          return ast;
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
			setState(60);
			decls();
			setState(61);
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
			setState(71);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				var_decl();
				setState(65);
				decls();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				str_decl();
				setState(68);
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
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				var_decl();
				setState(74);
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
			setState(79);
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
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
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
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			((Var_declContext)_localctx).base_type = base_type();
			setState(82);
			((Var_declContext)_localctx).id = id();
			setState(83);
			match(T__0);
			st.addVariable(((Var_declContext)_localctx).base_type.t, (((Var_declContext)_localctx).id!=null?_input.getText(((Var_declContext)_localctx).id.start,((Var_declContext)_localctx).id.stop):null));
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
			setState(86);
			match(T__1);
			setState(87);
			((Str_declContext)_localctx).id = id();
			setState(88);
			match(T__2);
			setState(89);
			((Str_declContext)_localctx).val = match(STR_LITERAL);
			setState(90);
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
			setState(97);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(T__3);
				((Base_typeContext)_localctx).t =  Scope.Type.INT;
				}
				break;
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(T__4);
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
		enterRule(_localctx, 14, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(T__3);
			setState(100);
			match(T__5);
			setState(101);
			match(T__6);
			setState(102);
			match(T__7);

			        st.pushScope();
			        st.currentScope().setName("main");
			    
			setState(104);
			match(T__8);
			setState(105);
			((FunctionContext)_localctx).statements = statements();
			setState(106);
			match(T__9);

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
		enterRule(_localctx, 16, RULE_statements);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
			case T__4:
			case T__8:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__15:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(109);
				((StatementsContext)_localctx).statement = statement();
				setState(110);
				((StatementsContext)_localctx).s = statements();
				((StatementsContext)_localctx).node =  new StatementListNode(((StatementsContext)_localctx).statement.node, ((StatementsContext)_localctx).s.node);
				}
				break;
			case T__9:
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
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__12:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				((StatementContext)_localctx).base_stmt = base_stmt();
				setState(117);
				match(T__0);
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).base_stmt.node;
				}
				break;
			case T__3:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				((StatementContext)_localctx).local_var_decl = local_var_decl();
				setState(121);
				match(T__0);
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).local_var_decl.node;
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(124);
				((StatementContext)_localctx).if_stmt = if_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).if_stmt.node;
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(127);
				((StatementContext)_localctx).while_stmt = while_stmt();
				((StatementContext)_localctx).node =  ((StatementContext)_localctx).while_stmt.node;
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(130);
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
		enterRule(_localctx, 20, RULE_base_stmt);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				((Base_stmtContext)_localctx).assign_stmt = assign_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).assign_stmt.node;
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(138);
				((Base_stmtContext)_localctx).read_stmt = read_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).read_stmt.node;
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				((Base_stmtContext)_localctx).print_stmt = print_stmt();
				((Base_stmtContext)_localctx).node =  ((Base_stmtContext)_localctx).print_stmt.node;
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(144);
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
		public Base_typeContext base_type() {
			return getRuleContext(Base_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
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
		enterRule(_localctx, 22, RULE_local_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			((Local_var_declContext)_localctx).base_type = base_type();
			setState(150);
			((Local_var_declContext)_localctx).id = id();

			        st.addVariable(((Local_var_declContext)_localctx).base_type.t, (((Local_var_declContext)_localctx).id!=null?_input.getText(((Local_var_declContext)_localctx).id.start,((Local_var_declContext)_localctx).id.stop):null));
			        ((Local_var_declContext)_localctx).node =  new EmptyStatementNode();
			    
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
		enterRule(_localctx, 24, RULE_read_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__10);
			setState(154);
			match(T__6);
			setState(155);
			((Read_stmtContext)_localctx).id = id();
			setState(156);
			match(T__7);
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
		enterRule(_localctx, 26, RULE_print_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__11);
			setState(160);
			match(T__6);
			setState(161);
			((Print_stmtContext)_localctx).expr = expr(0);
			setState(162);
			match(T__7);
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
		enterRule(_localctx, 28, RULE_return_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__12);
			setState(166);
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
		public IdContext id;
		public ExprContext expr;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		enterRule(_localctx, 30, RULE_assign_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			((Assign_stmtContext)_localctx).id = id();
			setState(170);
			match(T__2);
			setState(171);
			((Assign_stmtContext)_localctx).expr = expr(0);
			((Assign_stmtContext)_localctx).node =  new AssignNode(new VarNode((((Assign_stmtContext)_localctx).id!=null?_input.getText(((Assign_stmtContext)_localctx).id.start,((Assign_stmtContext)_localctx).id.stop):null)), ((Assign_stmtContext)_localctx).expr.node);
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
		enterRule(_localctx, 32, RULE_if_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__13);
			setState(175);
			match(T__6);
			setState(176);
			((If_stmtContext)_localctx).cond = cond(0);
			setState(177);
			match(T__7);
			setState(178);
			match(T__8);
			 st.pushScope(); 
			setState(180);
			((If_stmtContext)_localctx).thenStatements = statements();
			setState(181);
			match(T__9);
			 st.popScope(); 
			setState(183);
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
		enterRule(_localctx, 34, RULE_else_stmt);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				match(T__14);
				setState(187);
				match(T__8);
				 st.pushScope(); 
				setState(189);
				((Else_stmtContext)_localctx).elseStatements = statements();
				setState(190);
				match(T__9);
				 ((Else_stmtContext)_localctx).node =  ((Else_stmtContext)_localctx).elseStatements.node; st.popScope(); 
				}
				break;
			case T__3:
			case T__4:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__15:
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
		enterRule(_localctx, 36, RULE_while_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__15);
			setState(197);
			match(T__6);
			setState(198);
			((While_stmtContext)_localctx).cond = cond(0);
			setState(199);
			match(T__7);
			setState(200);
			match(T__8);
			 st.pushScope(); 
			setState(202);
			((While_stmtContext)_localctx).statements = statements();
			setState(203);
			match(T__9);
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
		enterRule(_localctx, 38, RULE_block_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			match(T__8);
			 st.pushScope(); 
			setState(208);
			((Block_stmtContext)_localctx).statements = statements();
			setState(209);
			match(T__9);
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
		enterRule(_localctx, 40, RULE_primary);
		try {
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				((PrimaryContext)_localctx).id = id();
				((PrimaryContext)_localctx).node =  new VarNode((((PrimaryContext)_localctx).id!=null?_input.getText(((PrimaryContext)_localctx).id.start,((PrimaryContext)_localctx).id.stop):null));
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				match(T__6);
				setState(216);
				((PrimaryContext)_localctx).expr = expr(0);
				setState(217);
				match(T__7);
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).expr.node;
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(220);
				((PrimaryContext)_localctx).unaryminus_expr = unaryminus_expr();
				((PrimaryContext)_localctx).node =  ((PrimaryContext)_localctx).unaryminus_expr.node;
				}
				break;
			case INT_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(223);
				((PrimaryContext)_localctx).il = match(INT_LITERAL);
				((PrimaryContext)_localctx).node =  new IntLitNode((((PrimaryContext)_localctx).il!=null?((PrimaryContext)_localctx).il.getText():null));
				}
				break;
			case FLOAT_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(225);
				((PrimaryContext)_localctx).fl = match(FLOAT_LITERAL);
				((PrimaryContext)_localctx).node =  new FloatLitNode((((PrimaryContext)_localctx).fl!=null?((PrimaryContext)_localctx).fl.getText():null));
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
		enterRule(_localctx, 42, RULE_unaryminus_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229);
			match(T__16);
			setState(230);
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
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(234);
			((ExprContext)_localctx).term = term(0);
			((ExprContext)_localctx).node =  ((ExprContext)_localctx).term.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
					setState(237);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(238);
					((ExprContext)_localctx).addop = addop();
					setState(239);
					((ExprContext)_localctx).term = term(0);
					 ((ExprContext)_localctx).node =  new BinaryOpNode(((ExprContext)_localctx).e1.node, ((ExprContext)_localctx).term.node, (((ExprContext)_localctx).addop!=null?_input.getText(((ExprContext)_localctx).addop.start,((ExprContext)_localctx).addop.stop):null));  
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(248);
			((TermContext)_localctx).primary = primary();
			((TermContext)_localctx).node =  ((TermContext)_localctx).primary.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(258);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
					setState(251);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(252);
					((TermContext)_localctx).mulop = mulop();
					setState(253);
					((TermContext)_localctx).primary = primary();
					 ((TermContext)_localctx).node =  new BinaryOpNode(((TermContext)_localctx).t1.node, ((TermContext)_localctx).primary.node, (((TermContext)_localctx).mulop!=null?_input.getText(((TermContext)_localctx).mulop.start,((TermContext)_localctx).mulop.stop):null));  
					}
					} 
				}
				setState(260);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(262);
			((CondContext)_localctx).and_cond = and_cond(0);
			((CondContext)_localctx).node =  ((CondContext)_localctx).and_cond.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(272);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
					setState(265);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(266);
					match(T__17);
					setState(267);
					((CondContext)_localctx).c2 = ((CondContext)_localctx).and_cond = and_cond(0);
					((CondContext)_localctx).node =  new LogicalOrNode(((CondContext)_localctx).c1.node, ((CondContext)_localctx).c2.node);
					}
					} 
				}
				setState(274);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_and_cond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(276);
			((And_condContext)_localctx).not_cond = not_cond();
			((And_condContext)_localctx).node =  ((And_condContext)_localctx).not_cond.node;
			}
			_ctx.stop = _input.LT(-1);
			setState(286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
					setState(279);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(280);
					match(T__18);
					setState(281);
					((And_condContext)_localctx).c2 = ((And_condContext)_localctx).not_cond = not_cond();
					((And_condContext)_localctx).node =  new LogicalAndNode(((And_condContext)_localctx).c1.node, ((And_condContext)_localctx).c2.node);
					}
					} 
				}
				setState(288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
		enterRule(_localctx, 52, RULE_not_cond);
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				match(T__19);
				setState(290);
				((Not_condContext)_localctx).not_cond = not_cond();
				((Not_condContext)_localctx).node =  new LogicalNotNode(((Not_condContext)_localctx).not_cond.node);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				match(T__6);
				setState(294);
				((Not_condContext)_localctx).cond = cond(0);
				setState(295);
				match(T__7);
				((Not_condContext)_localctx).node =  ((Not_condContext)_localctx).cond.node;
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				((Not_condContext)_localctx).e1 = expr(0);
				setState(299);
				((Not_condContext)_localctx).cmpop = cmpop();
				setState(300);
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
		enterRule(_localctx, 54, RULE_cmpop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25))) != 0)) ) {
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
		enterRule(_localctx, 56, RULE_mulop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28))) != 0)) ) {
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
		enterRule(_localctx, 58, RULE_addop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309);
			_la = _input.LA(1);
			if ( !(_la==T__16 || _la==T__29) ) {
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
		case 22:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 23:
			return term_sempred((TermContext)_localctx, predIndex);
		case 24:
			return cond_sempred((CondContext)_localctx, predIndex);
		case 25:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u013a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3J\n\3\3\4\3\4\3\4\3\4\5\4P\n\4\3"+
		"\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b"+
		"\5\bd\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\5\nu\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u0088\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\5\f\u0096\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00c5\n\23\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u00e6\n\26\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\7\30\u00f5\n\30\f\30\16\30\u00f8\13\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0103\n\31\f\31\16\31\u0106\13\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0111\n\32\f\32\16"+
		"\32\u0114\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u011f"+
		"\n\33\f\33\16\33\u0122\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\5\34\u0132\n\34\3\35\3\35\3\36\3\36\3\37"+
		"\3\37\3\37\2\6.\60\62\64 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<\2\5\3\2\27\34\3\2\35\37\4\2\23\23  \2\u0132\2>\3\2"+
		"\2\2\4I\3\2\2\2\6O\3\2\2\2\bQ\3\2\2\2\nS\3\2\2\2\fX\3\2\2\2\16c\3\2\2"+
		"\2\20e\3\2\2\2\22t\3\2\2\2\24\u0087\3\2\2\2\26\u0095\3\2\2\2\30\u0097"+
		"\3\2\2\2\32\u009b\3\2\2\2\34\u00a1\3\2\2\2\36\u00a7\3\2\2\2 \u00ab\3\2"+
		"\2\2\"\u00b0\3\2\2\2$\u00c4\3\2\2\2&\u00c6\3\2\2\2(\u00d0\3\2\2\2*\u00e5"+
		"\3\2\2\2,\u00e7\3\2\2\2.\u00eb\3\2\2\2\60\u00f9\3\2\2\2\62\u0107\3\2\2"+
		"\2\64\u0115\3\2\2\2\66\u0131\3\2\2\28\u0133\3\2\2\2:\u0135\3\2\2\2<\u0137"+
		"\3\2\2\2>?\5\4\3\2?@\5\20\t\2@A\b\2\1\2A\3\3\2\2\2BC\5\n\6\2CD\5\4\3\2"+
		"DJ\3\2\2\2EF\5\f\7\2FG\5\4\3\2GJ\3\2\2\2HJ\3\2\2\2IB\3\2\2\2IE\3\2\2\2"+
		"IH\3\2\2\2J\5\3\2\2\2KL\5\n\6\2LM\5\6\4\2MP\3\2\2\2NP\3\2\2\2OK\3\2\2"+
		"\2ON\3\2\2\2P\7\3\2\2\2QR\7!\2\2R\t\3\2\2\2ST\5\16\b\2TU\5\b\5\2UV\7\3"+
		"\2\2VW\b\6\1\2W\13\3\2\2\2XY\7\4\2\2YZ\5\b\5\2Z[\7\5\2\2[\\\7$\2\2\\]"+
		"\7\3\2\2]^\b\7\1\2^\r\3\2\2\2_`\7\6\2\2`d\b\b\1\2ab\7\7\2\2bd\b\b\1\2"+
		"c_\3\2\2\2ca\3\2\2\2d\17\3\2\2\2ef\7\6\2\2fg\7\b\2\2gh\7\t\2\2hi\7\n\2"+
		"\2ij\b\t\1\2jk\7\13\2\2kl\5\22\n\2lm\7\f\2\2mn\b\t\1\2n\21\3\2\2\2op\5"+
		"\24\13\2pq\5\22\n\2qr\b\n\1\2ru\3\2\2\2su\b\n\1\2to\3\2\2\2ts\3\2\2\2"+
		"u\23\3\2\2\2vw\5\26\f\2wx\7\3\2\2xy\b\13\1\2y\u0088\3\2\2\2z{\5\30\r\2"+
		"{|\7\3\2\2|}\b\13\1\2}\u0088\3\2\2\2~\177\5\"\22\2\177\u0080\b\13\1\2"+
		"\u0080\u0088\3\2\2\2\u0081\u0082\5&\24\2\u0082\u0083\b\13\1\2\u0083\u0088"+
		"\3\2\2\2\u0084\u0085\5(\25\2\u0085\u0086\b\13\1\2\u0086\u0088\3\2\2\2"+
		"\u0087v\3\2\2\2\u0087z\3\2\2\2\u0087~\3\2\2\2\u0087\u0081\3\2\2\2\u0087"+
		"\u0084\3\2\2\2\u0088\25\3\2\2\2\u0089\u008a\5 \21\2\u008a\u008b\b\f\1"+
		"\2\u008b\u0096\3\2\2\2\u008c\u008d\5\32\16\2\u008d\u008e\b\f\1\2\u008e"+
		"\u0096\3\2\2\2\u008f\u0090\5\34\17\2\u0090\u0091\b\f\1\2\u0091\u0096\3"+
		"\2\2\2\u0092\u0093\5\36\20\2\u0093\u0094\b\f\1\2\u0094\u0096\3\2\2\2\u0095"+
		"\u0089\3\2\2\2\u0095\u008c\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0092\3\2"+
		"\2\2\u0096\27\3\2\2\2\u0097\u0098\5\16\b\2\u0098\u0099\5\b\5\2\u0099\u009a"+
		"\b\r\1\2\u009a\31\3\2\2\2\u009b\u009c\7\r\2\2\u009c\u009d\7\t\2\2\u009d"+
		"\u009e\5\b\5\2\u009e\u009f\7\n\2\2\u009f\u00a0\b\16\1\2\u00a0\33\3\2\2"+
		"\2\u00a1\u00a2\7\16\2\2\u00a2\u00a3\7\t\2\2\u00a3\u00a4\5.\30\2\u00a4"+
		"\u00a5\7\n\2\2\u00a5\u00a6\b\17\1\2\u00a6\35\3\2\2\2\u00a7\u00a8\7\17"+
		"\2\2\u00a8\u00a9\5.\30\2\u00a9\u00aa\b\20\1\2\u00aa\37\3\2\2\2\u00ab\u00ac"+
		"\5\b\5\2\u00ac\u00ad\7\5\2\2\u00ad\u00ae\5.\30\2\u00ae\u00af\b\21\1\2"+
		"\u00af!\3\2\2\2\u00b0\u00b1\7\20\2\2\u00b1\u00b2\7\t\2\2\u00b2\u00b3\5"+
		"\62\32\2\u00b3\u00b4\7\n\2\2\u00b4\u00b5\7\13\2\2\u00b5\u00b6\b\22\1\2"+
		"\u00b6\u00b7\5\22\n\2\u00b7\u00b8\7\f\2\2\u00b8\u00b9\b\22\1\2\u00b9\u00ba"+
		"\5$\23\2\u00ba\u00bb\b\22\1\2\u00bb#\3\2\2\2\u00bc\u00bd\7\21\2\2\u00bd"+
		"\u00be\7\13\2\2\u00be\u00bf\b\23\1\2\u00bf\u00c0\5\22\n\2\u00c0\u00c1"+
		"\7\f\2\2\u00c1\u00c2\b\23\1\2\u00c2\u00c5\3\2\2\2\u00c3\u00c5\b\23\1\2"+
		"\u00c4\u00bc\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5%\3\2\2\2\u00c6\u00c7\7"+
		"\22\2\2\u00c7\u00c8\7\t\2\2\u00c8\u00c9\5\62\32\2\u00c9\u00ca\7\n\2\2"+
		"\u00ca\u00cb\7\13\2\2\u00cb\u00cc\b\24\1\2\u00cc\u00cd\5\22\n\2\u00cd"+
		"\u00ce\7\f\2\2\u00ce\u00cf\b\24\1\2\u00cf\'\3\2\2\2\u00d0\u00d1\7\13\2"+
		"\2\u00d1\u00d2\b\25\1\2\u00d2\u00d3\5\22\n\2\u00d3\u00d4\7\f\2\2\u00d4"+
		"\u00d5\b\25\1\2\u00d5)\3\2\2\2\u00d6\u00d7\5\b\5\2\u00d7\u00d8\b\26\1"+
		"\2\u00d8\u00e6\3\2\2\2\u00d9\u00da\7\t\2\2\u00da\u00db\5.\30\2\u00db\u00dc"+
		"\7\n\2\2\u00dc\u00dd\b\26\1\2\u00dd\u00e6\3\2\2\2\u00de\u00df\5,\27\2"+
		"\u00df\u00e0\b\26\1\2\u00e0\u00e6\3\2\2\2\u00e1\u00e2\7\"\2\2\u00e2\u00e6"+
		"\b\26\1\2\u00e3\u00e4\7#\2\2\u00e4\u00e6\b\26\1\2\u00e5\u00d6\3\2\2\2"+
		"\u00e5\u00d9\3\2\2\2\u00e5\u00de\3\2\2\2\u00e5\u00e1\3\2\2\2\u00e5\u00e3"+
		"\3\2\2\2\u00e6+\3\2\2\2\u00e7\u00e8\7\23\2\2\u00e8\u00e9\5.\30\2\u00e9"+
		"\u00ea\b\27\1\2\u00ea-\3\2\2\2\u00eb\u00ec\b\30\1\2\u00ec\u00ed\5\60\31"+
		"\2\u00ed\u00ee\b\30\1\2\u00ee\u00f6\3\2\2\2\u00ef\u00f0\f\3\2\2\u00f0"+
		"\u00f1\5<\37\2\u00f1\u00f2\5\60\31\2\u00f2\u00f3\b\30\1\2\u00f3\u00f5"+
		"\3\2\2\2\u00f4\u00ef\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7/\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\b\31\1\2"+
		"\u00fa\u00fb\5*\26\2\u00fb\u00fc\b\31\1\2\u00fc\u0104\3\2\2\2\u00fd\u00fe"+
		"\f\3\2\2\u00fe\u00ff\5:\36\2\u00ff\u0100\5*\26\2\u0100\u0101\b\31\1\2"+
		"\u0101\u0103\3\2\2\2\u0102\u00fd\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0102"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105\61\3\2\2\2\u0106\u0104\3\2\2\2\u0107"+
		"\u0108\b\32\1\2\u0108\u0109\5\64\33\2\u0109\u010a\b\32\1\2\u010a\u0112"+
		"\3\2\2\2\u010b\u010c\f\4\2\2\u010c\u010d\7\24\2\2\u010d\u010e\5\64\33"+
		"\2\u010e\u010f\b\32\1\2\u010f\u0111\3\2\2\2\u0110\u010b\3\2\2\2\u0111"+
		"\u0114\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113\63\3\2\2"+
		"\2\u0114\u0112\3\2\2\2\u0115\u0116\b\33\1\2\u0116\u0117\5\66\34\2\u0117"+
		"\u0118\b\33\1\2\u0118\u0120\3\2\2\2\u0119\u011a\f\4\2\2\u011a\u011b\7"+
		"\25\2\2\u011b\u011c\5\66\34\2\u011c\u011d\b\33\1\2\u011d\u011f\3\2\2\2"+
		"\u011e\u0119\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0120\u0121"+
		"\3\2\2\2\u0121\65\3\2\2\2\u0122\u0120\3\2\2\2\u0123\u0124\7\26\2\2\u0124"+
		"\u0125\5\66\34\2\u0125\u0126\b\34\1\2\u0126\u0132\3\2\2\2\u0127\u0128"+
		"\7\t\2\2\u0128\u0129\5\62\32\2\u0129\u012a\7\n\2\2\u012a\u012b\b\34\1"+
		"\2\u012b\u0132\3\2\2\2\u012c\u012d\5.\30\2\u012d\u012e\58\35\2\u012e\u012f"+
		"\5.\30\2\u012f\u0130\b\34\1\2\u0130\u0132\3\2\2\2\u0131\u0123\3\2\2\2"+
		"\u0131\u0127\3\2\2\2\u0131\u012c\3\2\2\2\u0132\67\3\2\2\2\u0133\u0134"+
		"\t\2\2\2\u01349\3\2\2\2\u0135\u0136\t\3\2\2\u0136;\3\2\2\2\u0137\u0138"+
		"\t\4\2\2\u0138=\3\2\2\2\17IOct\u0087\u0095\u00c4\u00e5\u00f6\u0104\u0112"+
		"\u0120\u0131";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}