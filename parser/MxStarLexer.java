// Generated from MxStar.g4 by ANTLR 4.6
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MxStarLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"Bool", "Int", "String", "Null", "Void", "True", "False", "If", "Else", 
		"For", "While", "Break", "Continue", "Return", "New", "Class", "This", 
		"Add", "Sub", "Mul", "Div", "Mod", "DbAdd", "DbSub", "And", "Or", "Xor", 
		"Not", "LSh", "RSh", "LAnd", "LOr", "LNot", "Les", "LesEq", "Gre", "GreEq", 
		"Eq", "NEq", "Assign", "Identifier", "Integer", "StringValue", "Char", 
		"WhiteSpace", "Comment", "BlockComment"
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


	public MxStarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "MxStar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\29\u0158\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3"+
		"\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*"+
		"\3+\3+\3,\3,\3-\3-\3-\3.\3.\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\7\63\u011c\n\63\f\63\16\63\u011f\13\63\3\64\3\64\7\64"+
		"\u0123\n\64\f\64\16\64\u0126\13\64\3\64\5\64\u0129\n\64\3\65\3\65\7\65"+
		"\u012d\n\65\f\65\16\65\u0130\13\65\3\65\3\65\3\66\3\66\3\66\5\66\u0137"+
		"\n\66\3\67\6\67\u013a\n\67\r\67\16\67\u013b\3\67\3\67\38\38\38\38\78\u0144"+
		"\n8\f8\168\u0147\138\38\38\39\39\39\39\79\u014f\n9\f9\169\u0152\139\3"+
		"9\39\39\39\39\3\u0150\2:\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65i\66k\2m\67o8q9\3\2\n\4\2C\\c|\5\2\62;C\\c|\3\2\63;\3\2\62"+
		";\6\2\f\f\17\17$$^^\6\2$$^^pptt\5\2\13\f\17\17\"\"\3\2\f\f\u015e\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2"+
		"\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2"+
		"\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2m\3\2\2\2\2o\3\2\2\2\2q"+
		"\3\2\2\2\3s\3\2\2\2\5u\3\2\2\2\7w\3\2\2\2\ty\3\2\2\2\13{\3\2\2\2\r}\3"+
		"\2\2\2\17\177\3\2\2\2\21\u0081\3\2\2\2\23\u0083\3\2\2\2\25\u0085\3\2\2"+
		"\2\27\u008a\3\2\2\2\31\u008e\3\2\2\2\33\u0095\3\2\2\2\35\u009a\3\2\2\2"+
		"\37\u009f\3\2\2\2!\u00a4\3\2\2\2#\u00aa\3\2\2\2%\u00ad\3\2\2\2\'\u00b2"+
		"\3\2\2\2)\u00b6\3\2\2\2+\u00bc\3\2\2\2-\u00c2\3\2\2\2/\u00cb\3\2\2\2\61"+
		"\u00d2\3\2\2\2\63\u00d6\3\2\2\2\65\u00dc\3\2\2\2\67\u00e1\3\2\2\29\u00e3"+
		"\3\2\2\2;\u00e5\3\2\2\2=\u00e7\3\2\2\2?\u00e9\3\2\2\2A\u00eb\3\2\2\2C"+
		"\u00ee\3\2\2\2E\u00f1\3\2\2\2G\u00f3\3\2\2\2I\u00f5\3\2\2\2K\u00f7\3\2"+
		"\2\2M\u00f9\3\2\2\2O\u00fc\3\2\2\2Q\u00ff\3\2\2\2S\u0102\3\2\2\2U\u0105"+
		"\3\2\2\2W\u0107\3\2\2\2Y\u0109\3\2\2\2[\u010c\3\2\2\2]\u010e\3\2\2\2_"+
		"\u0111\3\2\2\2a\u0114\3\2\2\2c\u0117\3\2\2\2e\u0119\3\2\2\2g\u0128\3\2"+
		"\2\2i\u012a\3\2\2\2k\u0136\3\2\2\2m\u0139\3\2\2\2o\u013f\3\2\2\2q\u014a"+
		"\3\2\2\2st\7}\2\2t\4\3\2\2\2uv\7\177\2\2v\6\3\2\2\2wx\7.\2\2x\b\3\2\2"+
		"\2yz\7]\2\2z\n\3\2\2\2{|\7_\2\2|\f\3\2\2\2}~\7*\2\2~\16\3\2\2\2\177\u0080"+
		"\7+\2\2\u0080\20\3\2\2\2\u0081\u0082\7\60\2\2\u0082\22\3\2\2\2\u0083\u0084"+
		"\7=\2\2\u0084\24\3\2\2\2\u0085\u0086\7d\2\2\u0086\u0087\7q\2\2\u0087\u0088"+
		"\7q\2\2\u0088\u0089\7n\2\2\u0089\26\3\2\2\2\u008a\u008b\7k\2\2\u008b\u008c"+
		"\7p\2\2\u008c\u008d\7v\2\2\u008d\30\3\2\2\2\u008e\u008f\7u\2\2\u008f\u0090"+
		"\7v\2\2\u0090\u0091\7t\2\2\u0091\u0092\7k\2\2\u0092\u0093\7p\2\2\u0093"+
		"\u0094\7i\2\2\u0094\32\3\2\2\2\u0095\u0096\7p\2\2\u0096\u0097\7w\2\2\u0097"+
		"\u0098\7n\2\2\u0098\u0099\7n\2\2\u0099\34\3\2\2\2\u009a\u009b\7x\2\2\u009b"+
		"\u009c\7q\2\2\u009c\u009d\7k\2\2\u009d\u009e\7f\2\2\u009e\36\3\2\2\2\u009f"+
		"\u00a0\7v\2\2\u00a0\u00a1\7t\2\2\u00a1\u00a2\7w\2\2\u00a2\u00a3\7g\2\2"+
		"\u00a3 \3\2\2\2\u00a4\u00a5\7h\2\2\u00a5\u00a6\7c\2\2\u00a6\u00a7\7n\2"+
		"\2\u00a7\u00a8\7u\2\2\u00a8\u00a9\7g\2\2\u00a9\"\3\2\2\2\u00aa\u00ab\7"+
		"k\2\2\u00ab\u00ac\7h\2\2\u00ac$\3\2\2\2\u00ad\u00ae\7g\2\2\u00ae\u00af"+
		"\7n\2\2\u00af\u00b0\7u\2\2\u00b0\u00b1\7g\2\2\u00b1&\3\2\2\2\u00b2\u00b3"+
		"\7h\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7t\2\2\u00b5(\3\2\2\2\u00b6\u00b7"+
		"\7y\2\2\u00b7\u00b8\7j\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7n\2\2\u00ba"+
		"\u00bb\7g\2\2\u00bb*\3\2\2\2\u00bc\u00bd\7d\2\2\u00bd\u00be\7t\2\2\u00be"+
		"\u00bf\7g\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7m\2\2\u00c1,\3\2\2\2\u00c2"+
		"\u00c3\7e\2\2\u00c3\u00c4\7q\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6\7v\2\2"+
		"\u00c6\u00c7\7k\2\2\u00c7\u00c8\7p\2\2\u00c8\u00c9\7w\2\2\u00c9\u00ca"+
		"\7g\2\2\u00ca.\3\2\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce"+
		"\7v\2\2\u00ce\u00cf\7w\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1\7p\2\2\u00d1"+
		"\60\3\2\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4\7g\2\2\u00d4\u00d5\7y\2\2\u00d5"+
		"\62\3\2\2\2\u00d6\u00d7\7e\2\2\u00d7\u00d8\7n\2\2\u00d8\u00d9\7c\2\2\u00d9"+
		"\u00da\7u\2\2\u00da\u00db\7u\2\2\u00db\64\3\2\2\2\u00dc\u00dd\7v\2\2\u00dd"+
		"\u00de\7j\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7u\2\2\u00e0\66\3\2\2\2\u00e1"+
		"\u00e2\7-\2\2\u00e28\3\2\2\2\u00e3\u00e4\7/\2\2\u00e4:\3\2\2\2\u00e5\u00e6"+
		"\7,\2\2\u00e6<\3\2\2\2\u00e7\u00e8\7\61\2\2\u00e8>\3\2\2\2\u00e9\u00ea"+
		"\7\'\2\2\u00ea@\3\2\2\2\u00eb\u00ec\7-\2\2\u00ec\u00ed\7-\2\2\u00edB\3"+
		"\2\2\2\u00ee\u00ef\7/\2\2\u00ef\u00f0\7/\2\2\u00f0D\3\2\2\2\u00f1\u00f2"+
		"\7(\2\2\u00f2F\3\2\2\2\u00f3\u00f4\7~\2\2\u00f4H\3\2\2\2\u00f5\u00f6\7"+
		"`\2\2\u00f6J\3\2\2\2\u00f7\u00f8\7\u0080\2\2\u00f8L\3\2\2\2\u00f9\u00fa"+
		"\7>\2\2\u00fa\u00fb\7>\2\2\u00fbN\3\2\2\2\u00fc\u00fd\7@\2\2\u00fd\u00fe"+
		"\7@\2\2\u00feP\3\2\2\2\u00ff\u0100\7(\2\2\u0100\u0101\7(\2\2\u0101R\3"+
		"\2\2\2\u0102\u0103\7~\2\2\u0103\u0104\7~\2\2\u0104T\3\2\2\2\u0105\u0106"+
		"\7#\2\2\u0106V\3\2\2\2\u0107\u0108\7>\2\2\u0108X\3\2\2\2\u0109\u010a\7"+
		">\2\2\u010a\u010b\7?\2\2\u010bZ\3\2\2\2\u010c\u010d\7@\2\2\u010d\\\3\2"+
		"\2\2\u010e\u010f\7@\2\2\u010f\u0110\7?\2\2\u0110^\3\2\2\2\u0111\u0112"+
		"\7?\2\2\u0112\u0113\7?\2\2\u0113`\3\2\2\2\u0114\u0115\7#\2\2\u0115\u0116"+
		"\7?\2\2\u0116b\3\2\2\2\u0117\u0118\7?\2\2\u0118d\3\2\2\2\u0119\u011d\t"+
		"\2\2\2\u011a\u011c\t\3\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d"+
		"\u011b\3\2\2\2\u011d\u011e\3\2\2\2\u011ef\3\2\2\2\u011f\u011d\3\2\2\2"+
		"\u0120\u0124\t\4\2\2\u0121\u0123\t\5\2\2\u0122\u0121\3\2\2\2\u0123\u0126"+
		"\3\2\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0129\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0127\u0129\7\62\2\2\u0128\u0120\3\2\2\2\u0128\u0127\3"+
		"\2\2\2\u0129h\3\2\2\2\u012a\u012e\7$\2\2\u012b\u012d\5k\66\2\u012c\u012b"+
		"\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2\2\2\u012f"+
		"\u0131\3\2\2\2\u0130\u012e\3\2\2\2\u0131\u0132\7$\2\2\u0132j\3\2\2\2\u0133"+
		"\u0137\n\6\2\2\u0134\u0135\7^\2\2\u0135\u0137\t\7\2\2\u0136\u0133\3\2"+
		"\2\2\u0136\u0134\3\2\2\2\u0137l\3\2\2\2\u0138\u013a\t\b\2\2\u0139\u0138"+
		"\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u013d\3\2\2\2\u013d\u013e\b\67\2\2\u013en\3\2\2\2\u013f\u0140\7\61\2"+
		"\2\u0140\u0141\7\61\2\2\u0141\u0145\3\2\2\2\u0142\u0144\n\t\2\2\u0143"+
		"\u0142\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145\u0146\3\2"+
		"\2\2\u0146\u0148\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\b8\2\2\u0149"+
		"p\3\2\2\2\u014a\u014b\7\61\2\2\u014b\u014c\7,\2\2\u014c\u0150\3\2\2\2"+
		"\u014d\u014f\13\2\2\2\u014e\u014d\3\2\2\2\u014f\u0152\3\2\2\2\u0150\u0151"+
		"\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0153\3\2\2\2\u0152\u0150\3\2\2\2\u0153"+
		"\u0154\7,\2\2\u0154\u0155\7\61\2\2\u0155\u0156\3\2\2\2\u0156\u0157\b9"+
		"\2\2\u0157r\3\2\2\2\13\2\u011d\u0124\u0128\u012e\u0136\u013b\u0145\u0150"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}