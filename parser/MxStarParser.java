// Generated from MxStar.g4 by ANTLR 4.6
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		Bool=10, Int=11, String=12, Null=13, Void=14, True=15, False=16, If=17, 
		Else=18, For=19, While=20, Break=21, Continue=22, Return=23, New=24, Class=25, 
		This=26, Add=27, Sub=28, Mul=29, Div=30, Mod=31, DbAdd=32, DbSub=33, And=34, 
		Or=35, Xor=36, Not=37, LSh=38, RSh=39, LAnd=40, LOr=41, LNot=42, Les=43, 
		LesEq=44, Gre=45, GreEq=46, Eq=47, NEq=48, Assign=49, Identifier=50, Integer=51, 
		StringValue=52, WhiteSpace=53, Comment=54, BlockComment=55;
	public static final int
		RULE_program = 0, RULE_programUnit = 1, RULE_classDef = 2, RULE_varDef = 3, 
		RULE_type = 4, RULE_funcDef = 5, RULE_funcType = 6, RULE_onevarDef = 7, 
		RULE_expr = 8, RULE_atomExpression = 9, RULE_creator = 10, RULE_parameters = 11, 
		RULE_parameter = 12, RULE_block = 13, RULE_statement = 14, RULE_forStatement = 15, 
		RULE_ifStatement = 16, RULE_whileStatement = 17;
	public static final String[] ruleNames = {
		"program", "programUnit", "classDef", "varDef", "type", "funcDef", "funcType", 
		"onevarDef", "expr", "atomExpression", "creator", "parameters", "parameter", 
		"block", "statement", "forStatement", "ifStatement", "whileStatement"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "','", "'['", "']'", "'('", "')'", "'.'", "';'", "'bool'", 
		"'int'", "'string'", "'null'", "'void'", "'true'", "'false'", "'if'", 
		"'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", "'new'", 
		"'class'", "'this'", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", 
		"'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'&&'", "'||'", "'!'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'!='", "'='"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "Bool", "Int", 
		"String", "Null", "Void", "True", "False", "If", "Else", "For", "While", 
		"Break", "Continue", "Return", "New", "Class", "This", "Add", "Sub", "Mul", 
		"Div", "Mod", "DbAdd", "DbSub", "And", "Or", "Xor", "Not", "LSh", "RSh", 
		"LAnd", "LOr", "LNot", "Les", "LesEq", "Gre", "GreEq", "Eq", "NEq", "Assign", 
		"Identifier", "Integer", "StringValue", "WhiteSpace", "Comment", "BlockComment"
	};
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
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MxStarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(MxStarParser.EOF, 0); }
		public List<ProgramUnitContext> programUnit() {
			return getRuleContexts(ProgramUnitContext.class);
		}
		public ProgramUnitContext programUnit(int i) {
			return getRuleContext(ProgramUnitContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Class) | (1L << Identifier))) != 0)) {
				{
				{
				setState(36);
				programUnit();
				}
				}
				setState(41);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(42);
			match(EOF);
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

	public static class ProgramUnitContext extends ParserRuleContext {
		public ClassDefContext classDef() {
			return getRuleContext(ClassDefContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public FuncDefContext funcDef() {
			return getRuleContext(FuncDefContext.class,0);
		}
		public ProgramUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterProgramUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitProgramUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitProgramUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramUnitContext programUnit() throws RecognitionException {
		ProgramUnitContext _localctx = new ProgramUnitContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programUnit);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				classDef();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				varDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				funcDef();
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

	public static class ClassDefContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(MxStarParser.Class, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public List<VarDefContext> varDef() {
			return getRuleContexts(VarDefContext.class);
		}
		public VarDefContext varDef(int i) {
			return getRuleContext(VarDefContext.class,i);
		}
		public List<FuncDefContext> funcDef() {
			return getRuleContexts(FuncDefContext.class);
		}
		public FuncDefContext funcDef(int i) {
			return getRuleContext(FuncDefContext.class,i);
		}
		public ClassDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterClassDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitClassDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitClassDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDefContext classDef() throws RecognitionException {
		ClassDefContext _localctx = new ClassDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(Class);
			setState(50);
			match(Identifier);
			setState(51);
			match(T__0);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Void) | (1L << Identifier))) != 0)) {
				{
				setState(54);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(52);
					varDef();
					}
					break;
				case 2:
					{
					setState(53);
					funcDef();
					}
					break;
				}
				}
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(59);
			match(T__1);
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

	public static class VarDefContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<OnevarDefContext> onevarDef() {
			return getRuleContexts(OnevarDefContext.class);
		}
		public OnevarDefContext onevarDef(int i) {
			return getRuleContext(OnevarDefContext.class,i);
		}
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(61);
			type();
			setState(62);
			onevarDef();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(63);
				match(T__2);
				setState(64);
				onevarDef();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode Bool() { return getToken(MxStarParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxStarParser.Int, 0); }
		public TerminalNode String() { return getToken(MxStarParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(71);
				match(T__3);
				setState(72);
				match(T__4);
				}
				}
				setState(77);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class FuncDefContext extends ParserRuleContext {
		public FuncTypeContext funcType() {
			return getRuleContext(FuncTypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FuncDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDefContext funcDef() throws RecognitionException {
		FuncDefContext _localctx = new FuncDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			funcType();
			setState(79);
			match(Identifier);
			{
			setState(80);
			match(T__5);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
				{
				setState(81);
				parameters();
				}
			}

			setState(84);
			match(T__6);
			}
			setState(86);
			block();
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

	public static class FuncTypeContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Void() { return getToken(MxStarParser.Void, 0); }
		public FuncTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncTypeContext funcType() throws RecognitionException {
		FuncTypeContext _localctx = new FuncTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_funcType);
		try {
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Bool:
			case Int:
			case String:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				type();
				}
				break;
			case Void:
				enterOuterAlt(_localctx, 2);
				{
				setState(89);
				match(Void);
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

	public static class OnevarDefContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MxStarParser.Assign, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public OnevarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onevarDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterOnevarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitOnevarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitOnevarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OnevarDefContext onevarDef() throws RecognitionException {
		OnevarDefContext _localctx = new OnevarDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_onevarDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(Identifier);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Assign) {
				{
				setState(93);
				match(Assign);
				setState(94);
				expr(0);
				}
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrefixExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Not() { return getToken(MxStarParser.Not, 0); }
		public TerminalNode LNot() { return getToken(MxStarParser.LNot, 0); }
		public TerminalNode DbAdd() { return getToken(MxStarParser.DbAdd, 0); }
		public TerminalNode DbSub() { return getToken(MxStarParser.DbSub, 0); }
		public TerminalNode Add() { return getToken(MxStarParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxStarParser.Sub, 0); }
		public PrefixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubscriptExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubscriptExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSubscriptExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSubscriptExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSubscriptExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public MemberExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitMemberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode DbAdd() { return getToken(MxStarParser.DbAdd, 0); }
		public TerminalNode DbSub() { return getToken(MxStarParser.DbSub, 0); }
		public SuffixExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterSuffixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitSuffixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitSuffixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomExprContext extends ExprContext {
		public AtomExpressionContext atomExpression() {
			return getRuleContext(AtomExpressionContext.class,0);
		}
		public AtomExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAtomExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAtomExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAtomExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Mul() { return getToken(MxStarParser.Mul, 0); }
		public TerminalNode Div() { return getToken(MxStarParser.Div, 0); }
		public TerminalNode Mod() { return getToken(MxStarParser.Mod, 0); }
		public TerminalNode Add() { return getToken(MxStarParser.Add, 0); }
		public TerminalNode Sub() { return getToken(MxStarParser.Sub, 0); }
		public TerminalNode LSh() { return getToken(MxStarParser.LSh, 0); }
		public TerminalNode RSh() { return getToken(MxStarParser.RSh, 0); }
		public TerminalNode Les() { return getToken(MxStarParser.Les, 0); }
		public TerminalNode LesEq() { return getToken(MxStarParser.LesEq, 0); }
		public TerminalNode Gre() { return getToken(MxStarParser.Gre, 0); }
		public TerminalNode GreEq() { return getToken(MxStarParser.GreEq, 0); }
		public TerminalNode Eq() { return getToken(MxStarParser.Eq, 0); }
		public TerminalNode NEq() { return getToken(MxStarParser.NEq, 0); }
		public TerminalNode And() { return getToken(MxStarParser.And, 0); }
		public TerminalNode Xor() { return getToken(MxStarParser.Xor, 0); }
		public TerminalNode Or() { return getToken(MxStarParser.Or, 0); }
		public TerminalNode LAnd() { return getToken(MxStarParser.LAnd, 0); }
		public TerminalNode LOr() { return getToken(MxStarParser.LOr, 0); }
		public BinaryExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CreatorExprContext extends ExprContext {
		public TerminalNode New() { return getToken(MxStarParser.New, 0); }
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public CreatorExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterCreatorExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitCreatorExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitCreatorExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Assign() { return getToken(MxStarParser.Assign, 0); }
		public AssignExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new AtomExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(98);
				atomExpression();
				}
				break;
			case 2:
				{
				_localctx = new CreatorExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(99);
				match(New);
				setState(100);
				creator();
				}
				break;
			case 3:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(101);
				match(Identifier);
				{
				setState(102);
				match(T__5);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) {
					{
					setState(103);
					parameters();
					}
				}

				setState(106);
				match(T__6);
				}
				}
				break;
			case 4:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(107);
				match(T__5);
				setState(108);
				expr(0);
				setState(109);
				match(T__6);
				}
				break;
			case 5:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Add) | (1L << Sub) | (1L << DbAdd) | (1L << DbSub) | (1L << Not) | (1L << LNot))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(112);
				expr(12);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(158);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(115);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(116);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Mul) | (1L << Div) | (1L << Mod))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(117);
						expr(12);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(118);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(119);
						_la = _input.LA(1);
						if ( !(_la==Add || _la==Sub) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(120);
						expr(11);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(121);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(122);
						_la = _input.LA(1);
						if ( !(_la==LSh || _la==RSh) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(123);
						expr(10);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(124);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(125);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Les) | (1L << LesEq) | (1L << Gre) | (1L << GreEq))) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(126);
						expr(9);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(127);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(128);
						_la = _input.LA(1);
						if ( !(_la==Eq || _la==NEq) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(129);
						expr(8);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(131);
						match(And);
						setState(132);
						expr(7);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(133);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(134);
						match(Xor);
						setState(135);
						expr(6);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(136);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(137);
						match(Or);
						setState(138);
						expr(5);
						}
						break;
					case 9:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(139);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(140);
						match(LAnd);
						setState(141);
						expr(4);
						}
						break;
					case 10:
						{
						_localctx = new BinaryExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(143);
						match(LOr);
						setState(144);
						expr(3);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(145);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(146);
						match(Assign);
						setState(147);
						expr(1);
						}
						break;
					case 12:
						{
						_localctx = new MemberExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(148);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(149);
						match(T__7);
						setState(150);
						match(Identifier);
						}
						break;
					case 13:
						{
						_localctx = new SubscriptExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(152);
						match(T__3);
						setState(153);
						expr(0);
						setState(154);
						match(T__4);
						}
						break;
					case 14:
						{
						_localctx = new SuffixExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(157);
						_la = _input.LA(1);
						if ( !(_la==DbAdd || _la==DbSub) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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

	public static class AtomExpressionContext extends ParserRuleContext {
		public AtomExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomExpression; }
	 
		public AtomExpressionContext() { }
		public void copyFrom(AtomExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StringExprContext extends AtomExpressionContext {
		public TerminalNode StringValue() { return getToken(MxStarParser.StringValue, 0); }
		public StringExprContext(AtomExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitStringExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitStringExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisExprContext extends AtomExpressionContext {
		public TerminalNode This() { return getToken(MxStarParser.This, 0); }
		public ThisExprContext(AtomExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterThisExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitThisExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitThisExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntExprContext extends AtomExpressionContext {
		public TerminalNode Integer() { return getToken(MxStarParser.Integer, 0); }
		public IntExprContext(AtomExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIntExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIntExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullExprContext extends AtomExpressionContext {
		public TerminalNode Null() { return getToken(MxStarParser.Null, 0); }
		public NullExprContext(AtomExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNullExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNullExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNullExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolExprContext extends AtomExpressionContext {
		public TerminalNode True() { return getToken(MxStarParser.True, 0); }
		public TerminalNode False() { return getToken(MxStarParser.False, 0); }
		public BoolExprContext(AtomExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBoolExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBoolExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBoolExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierExprContext extends AtomExpressionContext {
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public IdentifierExprContext(AtomExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIdentifierExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIdentifierExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIdentifierExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomExpressionContext atomExpression() throws RecognitionException {
		AtomExpressionContext _localctx = new AtomExpressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_atomExpression);
		int _la;
		try {
			setState(169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Integer:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(Integer);
				}
				break;
			case Identifier:
				_localctx = new IdentifierExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				match(Identifier);
				}
				break;
			case StringValue:
				_localctx = new StringExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
				match(StringValue);
				}
				break;
			case True:
			case False:
				_localctx = new BoolExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(166);
				_la = _input.LA(1);
				if ( !(_la==True || _la==False) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case This:
				_localctx = new ThisExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(167);
				match(This);
				}
				break;
			case Null:
				_localctx = new NullExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(168);
				match(Null);
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

	public static class CreatorContext extends ParserRuleContext {
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
	 
		public CreatorContext() { }
		public void copyFrom(CreatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RestCreatorContext extends CreatorContext {
		public TerminalNode Bool() { return getToken(MxStarParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxStarParser.Int, 0); }
		public TerminalNode String() { return getToken(MxStarParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public RestCreatorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterRestCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitRestCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitRestCreator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayCreatorContext extends CreatorContext {
		public TerminalNode Bool() { return getToken(MxStarParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxStarParser.Int, 0); }
		public TerminalNode String() { return getToken(MxStarParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayCreatorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterArrayCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitArrayCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitArrayCreator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorCreatorContext extends CreatorContext {
		public TerminalNode Bool() { return getToken(MxStarParser.Bool, 0); }
		public TerminalNode Int() { return getToken(MxStarParser.Int, 0); }
		public TerminalNode String() { return getToken(MxStarParser.String, 0); }
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ErrorCreatorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterErrorCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitErrorCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitErrorCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_creator);
		int _la;
		try {
			int _alt;
			setState(215);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new ErrorCreatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(176); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(172);
						match(T__3);
						setState(173);
						expr(0);
						setState(174);
						match(T__4);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(178); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(182); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(180);
						match(T__3);
						setState(181);
						match(T__4);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(184); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(190); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(186);
						match(T__3);
						setState(187);
						expr(0);
						setState(188);
						match(T__4);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(192); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new ArrayCreatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(199); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(195);
						match(T__3);
						setState(196);
						expr(0);
						setState(197);
						match(T__4);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(201); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(203);
						match(T__3);
						setState(204);
						match(T__4);
						}
						} 
					}
					setState(209);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new RestCreatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(210);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Bool) | (1L << Int) | (1L << String) | (1L << Identifier))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(213);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(211);
					match(T__5);
					setState(212);
					match(T__6);
					}
					break;
				}
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

	public static class ParametersContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			parameter();
			setState(222);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(218);
				match(T__2);
				setState(219);
				parameter();
				}
				}
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(MxStarParser.Identifier, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			type();
			setState(226);
			match(Identifier);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(228);
			match(T__0);
			setState(232);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__5) | (1L << T__8) | (1L << Bool) | (1L << Int) | (1L << String) | (1L << Null) | (1L << True) | (1L << False) | (1L << If) | (1L << For) | (1L << While) | (1L << Break) | (1L << Continue) | (1L << Return) | (1L << New) | (1L << This) | (1L << Add) | (1L << Sub) | (1L << DbAdd) | (1L << DbSub) | (1L << Not) | (1L << LNot) | (1L << Identifier) | (1L << Integer) | (1L << StringValue))) != 0)) {
				{
				{
				setState(229);
				statement();
				}
				}
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(235);
			match(T__1);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatementContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public IfStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullStatContext extends StatementContext {
		public NullStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterNullStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitNullStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitNullStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStatContext extends StatementContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitExprStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatContext extends StatementContext {
		public TerminalNode Return() { return getToken(MxStarParser.Return, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatContext extends StatementContext {
		public TerminalNode Continue() { return getToken(MxStarParser.Continue, 0); }
		public ContinueStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterContinueStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitContinueStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VardefStatContext extends StatementContext {
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public VardefStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterVardefStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitVardefStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitVardefStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatContext extends StatementContext {
		public TerminalNode Break() { return getToken(MxStarParser.Break, 0); }
		public BreakStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitBreakStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatContext extends StatementContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatementContext {
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public WhileStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_statement);
		int _la;
		try {
			setState(257);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new VardefStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				varDef();
				setState(238);
				match(T__8);
				}
				break;
			case 2:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(240);
				match(Break);
				setState(241);
				match(T__8);
				}
				break;
			case 3:
				_localctx = new ContinueStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(242);
				match(Continue);
				setState(243);
				match(T__8);
				}
				break;
			case 4:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(244);
				match(Return);
				setState(246);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Add) | (1L << Sub) | (1L << DbAdd) | (1L << DbSub) | (1L << Not) | (1L << LNot) | (1L << Identifier) | (1L << Integer) | (1L << StringValue))) != 0)) {
					{
					setState(245);
					expr(0);
					}
				}

				setState(248);
				match(T__8);
				}
				break;
			case 5:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(249);
				block();
				}
				break;
			case 6:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(250);
				expr(0);
				setState(251);
				match(T__8);
				}
				break;
			case 7:
				_localctx = new NullStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(253);
				match(T__8);
				}
				break;
			case 8:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(254);
				forStatement();
				}
				break;
			case 9:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(255);
				ifStatement();
				}
				break;
			case 10:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(256);
				whileStatement();
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

	public static class ForStatementContext extends ParserRuleContext {
		public ExprContext init;
		public ExprContext cond;
		public ExprContext change;
		public TerminalNode For() { return getToken(MxStarParser.For, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitForStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			match(For);
			setState(260);
			match(T__5);
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Add) | (1L << Sub) | (1L << DbAdd) | (1L << DbSub) | (1L << Not) | (1L << LNot) | (1L << Identifier) | (1L << Integer) | (1L << StringValue))) != 0)) {
				{
				setState(261);
				((ForStatementContext)_localctx).init = expr(0);
				}
			}

			setState(264);
			match(T__8);
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Add) | (1L << Sub) | (1L << DbAdd) | (1L << DbSub) | (1L << Not) | (1L << LNot) | (1L << Identifier) | (1L << Integer) | (1L << StringValue))) != 0)) {
				{
				setState(265);
				((ForStatementContext)_localctx).cond = expr(0);
				}
			}

			setState(268);
			match(T__8);
			setState(270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << Null) | (1L << True) | (1L << False) | (1L << New) | (1L << This) | (1L << Add) | (1L << Sub) | (1L << DbAdd) | (1L << DbSub) | (1L << Not) | (1L << LNot) | (1L << Identifier) | (1L << Integer) | (1L << StringValue))) != 0)) {
				{
				setState(269);
				((ForStatementContext)_localctx).change = expr(0);
				}
			}

			setState(272);
			match(T__6);
			setState(273);
			statement();
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

	public static class IfStatementContext extends ParserRuleContext {
		public StatementContext trueStat;
		public StatementContext falseStat;
		public TerminalNode If() { return getToken(MxStarParser.If, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode Else() { return getToken(MxStarParser.Else, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
			match(If);
			setState(276);
			match(T__5);
			setState(277);
			expr(0);
			setState(278);
			match(T__6);
			setState(279);
			((IfStatementContext)_localctx).trueStat = statement();
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(280);
				match(Else);
				setState(281);
				((IfStatementContext)_localctx).falseStat = statement();
				}
				break;
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

	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(MxStarParser.While, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MxStarListener ) ((MxStarListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MxStarVisitor ) return ((MxStarVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(While);
			setState(285);
			match(T__5);
			setState(286);
			expr(0);
			setState(287);
			match(T__6);
			setState(288);
			statement();
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
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 11);
		case 1:
			return precpred(_ctx, 10);
		case 2:
			return precpred(_ctx, 9);
		case 3:
			return precpred(_ctx, 8);
		case 4:
			return precpred(_ctx, 7);
		case 5:
			return precpred(_ctx, 6);
		case 6:
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		case 9:
			return precpred(_ctx, 2);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 17);
		case 12:
			return precpred(_ctx, 14);
		case 13:
			return precpred(_ctx, 13);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\39\u0125\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\5\3\62\n\3"+
		"\3\4\3\4\3\4\3\4\3\4\7\49\n\4\f\4\16\4<\13\4\3\4\3\4\3\5\3\5\3\5\3\5\7"+
		"\5D\n\5\f\5\16\5G\13\5\3\6\3\6\3\6\7\6L\n\6\f\6\16\6O\13\6\3\7\3\7\3\7"+
		"\3\7\5\7U\n\7\3\7\3\7\3\7\3\7\3\b\3\b\5\b]\n\b\3\t\3\t\3\t\5\tb\n\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nk\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nt\n"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\n\u00a1\n\n\f\n\16\n\u00a4\13\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ac\n\13\3\f\3\f\3\f\3\f\3\f\6\f\u00b3"+
		"\n\f\r\f\16\f\u00b4\3\f\3\f\6\f\u00b9\n\f\r\f\16\f\u00ba\3\f\3\f\3\f\3"+
		"\f\6\f\u00c1\n\f\r\f\16\f\u00c2\3\f\3\f\3\f\3\f\3\f\6\f\u00ca\n\f\r\f"+
		"\16\f\u00cb\3\f\3\f\7\f\u00d0\n\f\f\f\16\f\u00d3\13\f\3\f\3\f\3\f\5\f"+
		"\u00d8\n\f\5\f\u00da\n\f\3\r\3\r\3\r\7\r\u00df\n\r\f\r\16\r\u00e2\13\r"+
		"\3\16\3\16\3\16\3\17\3\17\7\17\u00e9\n\17\f\17\16\17\u00ec\13\17\3\17"+
		"\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f9\n\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0104\n\20\3\21\3\21\3\21"+
		"\5\21\u0109\n\21\3\21\3\21\5\21\u010d\n\21\3\21\3\21\5\21\u0111\n\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u011d\n\22\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\2\3\22\24\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$\2\13\4\2\f\16\64\64\6\2\35\36\"#\'\',,\3\2\37!\3\2\35\36"+
		"\3\2()\3\2-\60\3\2\61\62\3\2\"#\3\2\21\22\u014c\2)\3\2\2\2\4\61\3\2\2"+
		"\2\6\63\3\2\2\2\b?\3\2\2\2\nH\3\2\2\2\fP\3\2\2\2\16\\\3\2\2\2\20^\3\2"+
		"\2\2\22s\3\2\2\2\24\u00ab\3\2\2\2\26\u00d9\3\2\2\2\30\u00db\3\2\2\2\32"+
		"\u00e3\3\2\2\2\34\u00e6\3\2\2\2\36\u0103\3\2\2\2 \u0105\3\2\2\2\"\u0115"+
		"\3\2\2\2$\u011e\3\2\2\2&(\5\4\3\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3"+
		"\2\2\2*,\3\2\2\2+)\3\2\2\2,-\7\2\2\3-\3\3\2\2\2.\62\5\6\4\2/\62\5\b\5"+
		"\2\60\62\5\f\7\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2\2\63"+
		"\64\7\33\2\2\64\65\7\64\2\2\65:\7\3\2\2\669\5\b\5\2\679\5\f\7\28\66\3"+
		"\2\2\28\67\3\2\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;=\3\2\2\2<:\3\2\2\2="+
		">\7\4\2\2>\7\3\2\2\2?@\5\n\6\2@E\5\20\t\2AB\7\5\2\2BD\5\20\t\2CA\3\2\2"+
		"\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GE\3\2\2\2HM\t\2\2\2IJ\7\6"+
		"\2\2JL\7\7\2\2KI\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\13\3\2\2\2OM\3"+
		"\2\2\2PQ\5\16\b\2QR\7\64\2\2RT\7\b\2\2SU\5\30\r\2TS\3\2\2\2TU\3\2\2\2"+
		"UV\3\2\2\2VW\7\t\2\2WX\3\2\2\2XY\5\34\17\2Y\r\3\2\2\2Z]\5\n\6\2[]\7\20"+
		"\2\2\\Z\3\2\2\2\\[\3\2\2\2]\17\3\2\2\2^a\7\64\2\2_`\7\63\2\2`b\5\22\n"+
		"\2a_\3\2\2\2ab\3\2\2\2b\21\3\2\2\2cd\b\n\1\2dt\5\24\13\2ef\7\32\2\2ft"+
		"\5\26\f\2gh\7\64\2\2hj\7\b\2\2ik\5\30\r\2ji\3\2\2\2jk\3\2\2\2kl\3\2\2"+
		"\2lt\7\t\2\2mn\7\b\2\2no\5\22\n\2op\7\t\2\2pt\3\2\2\2qr\t\3\2\2rt\5\22"+
		"\n\16sc\3\2\2\2se\3\2\2\2sg\3\2\2\2sm\3\2\2\2sq\3\2\2\2t\u00a2\3\2\2\2"+
		"uv\f\r\2\2vw\t\4\2\2w\u00a1\5\22\n\16xy\f\f\2\2yz\t\5\2\2z\u00a1\5\22"+
		"\n\r{|\f\13\2\2|}\t\6\2\2}\u00a1\5\22\n\f~\177\f\n\2\2\177\u0080\t\7\2"+
		"\2\u0080\u00a1\5\22\n\13\u0081\u0082\f\t\2\2\u0082\u0083\t\b\2\2\u0083"+
		"\u00a1\5\22\n\n\u0084\u0085\f\b\2\2\u0085\u0086\7$\2\2\u0086\u00a1\5\22"+
		"\n\t\u0087\u0088\f\7\2\2\u0088\u0089\7&\2\2\u0089\u00a1\5\22\n\b\u008a"+
		"\u008b\f\6\2\2\u008b\u008c\7%\2\2\u008c\u00a1\5\22\n\7\u008d\u008e\f\5"+
		"\2\2\u008e\u008f\7*\2\2\u008f\u00a1\5\22\n\6\u0090\u0091\f\4\2\2\u0091"+
		"\u0092\7+\2\2\u0092\u00a1\5\22\n\5\u0093\u0094\f\3\2\2\u0094\u0095\7\63"+
		"\2\2\u0095\u00a1\5\22\n\3\u0096\u0097\f\23\2\2\u0097\u0098\7\n\2\2\u0098"+
		"\u00a1\7\64\2\2\u0099\u009a\f\20\2\2\u009a\u009b\7\6\2\2\u009b\u009c\5"+
		"\22\n\2\u009c\u009d\7\7\2\2\u009d\u00a1\3\2\2\2\u009e\u009f\f\17\2\2\u009f"+
		"\u00a1\t\t\2\2\u00a0u\3\2\2\2\u00a0x\3\2\2\2\u00a0{\3\2\2\2\u00a0~\3\2"+
		"\2\2\u00a0\u0081\3\2\2\2\u00a0\u0084\3\2\2\2\u00a0\u0087\3\2\2\2\u00a0"+
		"\u008a\3\2\2\2\u00a0\u008d\3\2\2\2\u00a0\u0090\3\2\2\2\u00a0\u0093\3\2"+
		"\2\2\u00a0\u0096\3\2\2\2\u00a0\u0099\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a4\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\23\3\2\2"+
		"\2\u00a4\u00a2\3\2\2\2\u00a5\u00ac\7\65\2\2\u00a6\u00ac\7\64\2\2\u00a7"+
		"\u00ac\7\66\2\2\u00a8\u00ac\t\n\2\2\u00a9\u00ac\7\34\2\2\u00aa\u00ac\7"+
		"\17\2\2\u00ab\u00a5\3\2\2\2\u00ab\u00a6\3\2\2\2\u00ab\u00a7\3\2\2\2\u00ab"+
		"\u00a8\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00aa\3\2\2\2\u00ac\25\3\2\2"+
		"\2\u00ad\u00b2\t\2\2\2\u00ae\u00af\7\6\2\2\u00af\u00b0\5\22\n\2\u00b0"+
		"\u00b1\7\7\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00ae\3\2\2\2\u00b3\u00b4\3\2"+
		"\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b7\7\6\2\2\u00b7\u00b9\7\7\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\u00c0\3\2\2\2\u00bc"+
		"\u00bd\7\6\2\2\u00bd\u00be\5\22\n\2\u00be\u00bf\7\7\2\2\u00bf\u00c1\3"+
		"\2\2\2\u00c0\u00bc\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2"+
		"\u00c3\3\2\2\2\u00c3\u00da\3\2\2\2\u00c4\u00c9\t\2\2\2\u00c5\u00c6\7\6"+
		"\2\2\u00c6\u00c7\5\22\n\2\u00c7\u00c8\7\7\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c5\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00d1\3\2\2\2\u00cd\u00ce\7\6\2\2\u00ce\u00d0\7\7\2\2\u00cf"+
		"\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2"+
		"\2\2\u00d2\u00da\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00d7\t\2\2\2\u00d5"+
		"\u00d6\7\b\2\2\u00d6\u00d8\7\t\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00da\3\2\2\2\u00d9\u00ad\3\2\2\2\u00d9\u00c4\3\2\2\2\u00d9"+
		"\u00d4\3\2\2\2\u00da\27\3\2\2\2\u00db\u00e0\5\32\16\2\u00dc\u00dd\7\5"+
		"\2\2\u00dd\u00df\5\32\16\2\u00de\u00dc\3\2\2\2\u00df\u00e2\3\2\2\2\u00e0"+
		"\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\31\3\2\2\2\u00e2\u00e0\3\2\2"+
		"\2\u00e3\u00e4\5\n\6\2\u00e4\u00e5\7\64\2\2\u00e5\33\3\2\2\2\u00e6\u00ea"+
		"\7\3\2\2\u00e7\u00e9\5\36\20\2\u00e8\u00e7\3\2\2\2\u00e9\u00ec\3\2\2\2"+
		"\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00ea"+
		"\3\2\2\2\u00ed\u00ee\7\4\2\2\u00ee\35\3\2\2\2\u00ef\u00f0\5\b\5\2\u00f0"+
		"\u00f1\7\13\2\2\u00f1\u0104\3\2\2\2\u00f2\u00f3\7\27\2\2\u00f3\u0104\7"+
		"\13\2\2\u00f4\u00f5\7\30\2\2\u00f5\u0104\7\13\2\2\u00f6\u00f8\7\31\2\2"+
		"\u00f7\u00f9\5\22\n\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u0104\7\13\2\2\u00fb\u0104\5\34\17\2\u00fc\u00fd\5\22\n"+
		"\2\u00fd\u00fe\7\13\2\2\u00fe\u0104\3\2\2\2\u00ff\u0104\7\13\2\2\u0100"+
		"\u0104\5 \21\2\u0101\u0104\5\"\22\2\u0102\u0104\5$\23\2\u0103\u00ef\3"+
		"\2\2\2\u0103\u00f2\3\2\2\2\u0103\u00f4\3\2\2\2\u0103\u00f6\3\2\2\2\u0103"+
		"\u00fb\3\2\2\2\u0103\u00fc\3\2\2\2\u0103\u00ff\3\2\2\2\u0103\u0100\3\2"+
		"\2\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2\2\2\u0104\37\3\2\2\2\u0105\u0106"+
		"\7\25\2\2\u0106\u0108\7\b\2\2\u0107\u0109\5\22\n\2\u0108\u0107\3\2\2\2"+
		"\u0108\u0109\3\2\2\2\u0109\u010a\3\2\2\2\u010a\u010c\7\13\2\2\u010b\u010d"+
		"\5\22\n\2\u010c\u010b\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\3\2\2\2"+
		"\u010e\u0110\7\13\2\2\u010f\u0111\5\22\n\2\u0110\u010f\3\2\2\2\u0110\u0111"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0113\7\t\2\2\u0113\u0114\5\36\20\2"+
		"\u0114!\3\2\2\2\u0115\u0116\7\23\2\2\u0116\u0117\7\b\2\2\u0117\u0118\5"+
		"\22\n\2\u0118\u0119\7\t\2\2\u0119\u011c\5\36\20\2\u011a\u011b\7\24\2\2"+
		"\u011b\u011d\5\36\20\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d#"+
		"\3\2\2\2\u011e\u011f\7\26\2\2\u011f\u0120\7\b\2\2\u0120\u0121\5\22\n\2"+
		"\u0121\u0122\7\t\2\2\u0122\u0123\5\36\20\2\u0123%\3\2\2\2\37)\618:EMT"+
		"\\ajs\u00a0\u00a2\u00ab\u00b4\u00ba\u00c2\u00cb\u00d1\u00d7\u00d9\u00e0"+
		"\u00ea\u00f8\u0103\u0108\u010c\u0110\u011c";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}