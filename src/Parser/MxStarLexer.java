// Generated from D:/MxStar-Compiler/src/Parser\MxStar.g4 by ANTLR 4.9
package Parser;
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
	static { RuntimeMetaData.checkVersion("4.9", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, BoolValue=8, Bool=9, 
		Int=10, String=11, Null=12, Void=13, True=14, False=15, If=16, Else=17, 
		For=18, While=19, Break=20, Continue=21, Return=22, New=23, Class=24, 
		This=25, Add=26, Sub=27, Mul=28, Div=29, Mod=30, DbAdd=31, DbSub=32, And=33, 
		Or=34, Xor=35, Not=36, LSh=37, RSh=38, LAnd=39, LOr=40, LNot=41, Les=42, 
		LesEq=43, Gre=44, GreEq=45, Eq=46, NEq=47, Assign=48, LeftBracket=49, 
		RightBracket=50, Identifier=51, Integer=52, StringValue=53, WhiteSpace=54, 
		Comment=55, BlockComment=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "BoolValue", 
			"Bool", "Int", "String", "Null", "Void", "True", "False", "If", "Else", 
			"For", "While", "Break", "Continue", "Return", "New", "Class", "This", 
			"Add", "Sub", "Mul", "Div", "Mod", "DbAdd", "DbSub", "And", "Or", "Xor", 
			"Not", "LSh", "RSh", "LAnd", "LOr", "LNot", "Les", "LesEq", "Gre", "GreEq", 
			"Eq", "NEq", "Assign", "LeftBracket", "RightBracket", "Identifier", "Integer", 
			"StringValue", "Char", "WhiteSpace", "Comment", "BlockComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "';'", "','", "'('", "')'", "'.'", null, "'bool'", 
			"'int'", "'string'", "'null'", "'void'", "'true'", "'false'", "'if'", 
			"'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", "'new'", 
			"'class'", "'this'", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", 
			"'&'", "'|'", "'^'", "'~'", "'<<'", "'>>'", "'&&'", "'||'", "'!'", "'<'", 
			"'<='", "'>'", "'>='", "'=='", "'!='", "'='", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "BoolValue", "Bool", 
			"Int", "String", "Null", "Void", "True", "False", "If", "Else", "For", 
			"While", "Break", "Continue", "Return", "New", "Class", "This", "Add", 
			"Sub", "Mul", "Div", "Mod", "DbAdd", "DbSub", "And", "Or", "Xor", "Not", 
			"LSh", "RSh", "LAnd", "LOr", "LNot", "Les", "LesEq", "Gre", "GreEq", 
			"Eq", "NEq", "Assign", "LeftBracket", "RightBracket", "Identifier", "Integer", 
			"StringValue", "WhiteSpace", "Comment", "BlockComment"
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
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u0165\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\5\t\u008d\n\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3"+
		"&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3,\3,\3,\3-\3-\3.\3.\3"+
		".\3/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\7\64"+
		"\u0129\n\64\f\64\16\64\u012c\13\64\3\65\3\65\7\65\u0130\n\65\f\65\16\65"+
		"\u0133\13\65\3\65\5\65\u0136\n\65\3\66\3\66\7\66\u013a\n\66\f\66\16\66"+
		"\u013d\13\66\3\66\3\66\3\67\3\67\3\67\5\67\u0144\n\67\38\68\u0147\n8\r"+
		"8\168\u0148\38\38\39\39\39\39\79\u0151\n9\f9\169\u0154\139\39\39\3:\3"+
		":\3:\3:\7:\u015c\n:\f:\16:\u015f\13:\3:\3:\3:\3:\3:\3\u015d\2;\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m\2o8q9s:\3"+
		"\2\n\4\2C\\c|\6\2\62;C\\aac|\3\2\63;\3\2\62;\6\2\f\f\17\17$$^^\6\2$$^"+
		"^pptt\5\2\13\f\17\17\"\"\3\2\f\f\2\u016c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)"+
		"\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2"+
		"\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2"+
		"A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3"+
		"\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2"+
		"\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2"+
		"g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u\3"+
		"\2\2\2\5w\3\2\2\2\7y\3\2\2\2\t{\3\2\2\2\13}\3\2\2\2\r\177\3\2\2\2\17\u0081"+
		"\3\2\2\2\21\u008c\3\2\2\2\23\u008e\3\2\2\2\25\u0093\3\2\2\2\27\u0097\3"+
		"\2\2\2\31\u009e\3\2\2\2\33\u00a3\3\2\2\2\35\u00a8\3\2\2\2\37\u00ad\3\2"+
		"\2\2!\u00b3\3\2\2\2#\u00b6\3\2\2\2%\u00bb\3\2\2\2\'\u00bf\3\2\2\2)\u00c5"+
		"\3\2\2\2+\u00cb\3\2\2\2-\u00d4\3\2\2\2/\u00db\3\2\2\2\61\u00df\3\2\2\2"+
		"\63\u00e5\3\2\2\2\65\u00ea\3\2\2\2\67\u00ec\3\2\2\29\u00ee\3\2\2\2;\u00f0"+
		"\3\2\2\2=\u00f2\3\2\2\2?\u00f4\3\2\2\2A\u00f7\3\2\2\2C\u00fa\3\2\2\2E"+
		"\u00fc\3\2\2\2G\u00fe\3\2\2\2I\u0100\3\2\2\2K\u0102\3\2\2\2M\u0105\3\2"+
		"\2\2O\u0108\3\2\2\2Q\u010b\3\2\2\2S\u010e\3\2\2\2U\u0110\3\2\2\2W\u0112"+
		"\3\2\2\2Y\u0115\3\2\2\2[\u0117\3\2\2\2]\u011a\3\2\2\2_\u011d\3\2\2\2a"+
		"\u0120\3\2\2\2c\u0122\3\2\2\2e\u0124\3\2\2\2g\u0126\3\2\2\2i\u0135\3\2"+
		"\2\2k\u0137\3\2\2\2m\u0143\3\2\2\2o\u0146\3\2\2\2q\u014c\3\2\2\2s\u0157"+
		"\3\2\2\2uv\7}\2\2v\4\3\2\2\2wx\7\177\2\2x\6\3\2\2\2yz\7=\2\2z\b\3\2\2"+
		"\2{|\7.\2\2|\n\3\2\2\2}~\7*\2\2~\f\3\2\2\2\177\u0080\7+\2\2\u0080\16\3"+
		"\2\2\2\u0081\u0082\7\60\2\2\u0082\20\3\2\2\2\u0083\u0084\7v\2\2\u0084"+
		"\u0085\7t\2\2\u0085\u0086\7w\2\2\u0086\u008d\7g\2\2\u0087\u0088\7h\2\2"+
		"\u0088\u0089\7c\2\2\u0089\u008a\7n\2\2\u008a\u008b\7u\2\2\u008b\u008d"+
		"\7g\2\2\u008c\u0083\3\2\2\2\u008c\u0087\3\2\2\2\u008d\22\3\2\2\2\u008e"+
		"\u008f\7d\2\2\u008f\u0090\7q\2\2\u0090\u0091\7q\2\2\u0091\u0092\7n\2\2"+
		"\u0092\24\3\2\2\2\u0093\u0094\7k\2\2\u0094\u0095\7p\2\2\u0095\u0096\7"+
		"v\2\2\u0096\26\3\2\2\2\u0097\u0098\7u\2\2\u0098\u0099\7v\2\2\u0099\u009a"+
		"\7t\2\2\u009a\u009b\7k\2\2\u009b\u009c\7p\2\2\u009c\u009d\7i\2\2\u009d"+
		"\30\3\2\2\2\u009e\u009f\7p\2\2\u009f\u00a0\7w\2\2\u00a0\u00a1\7n\2\2\u00a1"+
		"\u00a2\7n\2\2\u00a2\32\3\2\2\2\u00a3\u00a4\7x\2\2\u00a4\u00a5\7q\2\2\u00a5"+
		"\u00a6\7k\2\2\u00a6\u00a7\7f\2\2\u00a7\34\3\2\2\2\u00a8\u00a9\7v\2\2\u00a9"+
		"\u00aa\7t\2\2\u00aa\u00ab\7w\2\2\u00ab\u00ac\7g\2\2\u00ac\36\3\2\2\2\u00ad"+
		"\u00ae\7h\2\2\u00ae\u00af\7c\2\2\u00af\u00b0\7n\2\2\u00b0\u00b1\7u\2\2"+
		"\u00b1\u00b2\7g\2\2\u00b2 \3\2\2\2\u00b3\u00b4\7k\2\2\u00b4\u00b5\7h\2"+
		"\2\u00b5\"\3\2\2\2\u00b6\u00b7\7g\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7"+
		"u\2\2\u00b9\u00ba\7g\2\2\u00ba$\3\2\2\2\u00bb\u00bc\7h\2\2\u00bc\u00bd"+
		"\7q\2\2\u00bd\u00be\7t\2\2\u00be&\3\2\2\2\u00bf\u00c0\7y\2\2\u00c0\u00c1"+
		"\7j\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7g\2\2\u00c4"+
		"(\3\2\2\2\u00c5\u00c6\7d\2\2\u00c6\u00c7\7t\2\2\u00c7\u00c8\7g\2\2\u00c8"+
		"\u00c9\7c\2\2\u00c9\u00ca\7m\2\2\u00ca*\3\2\2\2\u00cb\u00cc\7e\2\2\u00cc"+
		"\u00cd\7q\2\2\u00cd\u00ce\7p\2\2\u00ce\u00cf\7v\2\2\u00cf\u00d0\7k\2\2"+
		"\u00d0\u00d1\7p\2\2\u00d1\u00d2\7w\2\2\u00d2\u00d3\7g\2\2\u00d3,\3\2\2"+
		"\2\u00d4\u00d5\7t\2\2\u00d5\u00d6\7g\2\2\u00d6\u00d7\7v\2\2\u00d7\u00d8"+
		"\7w\2\2\u00d8\u00d9\7t\2\2\u00d9\u00da\7p\2\2\u00da.\3\2\2\2\u00db\u00dc"+
		"\7p\2\2\u00dc\u00dd\7g\2\2\u00dd\u00de\7y\2\2\u00de\60\3\2\2\2\u00df\u00e0"+
		"\7e\2\2\u00e0\u00e1\7n\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7u\2\2\u00e3"+
		"\u00e4\7u\2\2\u00e4\62\3\2\2\2\u00e5\u00e6\7v\2\2\u00e6\u00e7\7j\2\2\u00e7"+
		"\u00e8\7k\2\2\u00e8\u00e9\7u\2\2\u00e9\64\3\2\2\2\u00ea\u00eb\7-\2\2\u00eb"+
		"\66\3\2\2\2\u00ec\u00ed\7/\2\2\u00ed8\3\2\2\2\u00ee\u00ef\7,\2\2\u00ef"+
		":\3\2\2\2\u00f0\u00f1\7\61\2\2\u00f1<\3\2\2\2\u00f2\u00f3\7\'\2\2\u00f3"+
		">\3\2\2\2\u00f4\u00f5\7-\2\2\u00f5\u00f6\7-\2\2\u00f6@\3\2\2\2\u00f7\u00f8"+
		"\7/\2\2\u00f8\u00f9\7/\2\2\u00f9B\3\2\2\2\u00fa\u00fb\7(\2\2\u00fbD\3"+
		"\2\2\2\u00fc\u00fd\7~\2\2\u00fdF\3\2\2\2\u00fe\u00ff\7`\2\2\u00ffH\3\2"+
		"\2\2\u0100\u0101\7\u0080\2\2\u0101J\3\2\2\2\u0102\u0103\7>\2\2\u0103\u0104"+
		"\7>\2\2\u0104L\3\2\2\2\u0105\u0106\7@\2\2\u0106\u0107\7@\2\2\u0107N\3"+
		"\2\2\2\u0108\u0109\7(\2\2\u0109\u010a\7(\2\2\u010aP\3\2\2\2\u010b\u010c"+
		"\7~\2\2\u010c\u010d\7~\2\2\u010dR\3\2\2\2\u010e\u010f\7#\2\2\u010fT\3"+
		"\2\2\2\u0110\u0111\7>\2\2\u0111V\3\2\2\2\u0112\u0113\7>\2\2\u0113\u0114"+
		"\7?\2\2\u0114X\3\2\2\2\u0115\u0116\7@\2\2\u0116Z\3\2\2\2\u0117\u0118\7"+
		"@\2\2\u0118\u0119\7?\2\2\u0119\\\3\2\2\2\u011a\u011b\7?\2\2\u011b\u011c"+
		"\7?\2\2\u011c^\3\2\2\2\u011d\u011e\7#\2\2\u011e\u011f\7?\2\2\u011f`\3"+
		"\2\2\2\u0120\u0121\7?\2\2\u0121b\3\2\2\2\u0122\u0123\7]\2\2\u0123d\3\2"+
		"\2\2\u0124\u0125\7_\2\2\u0125f\3\2\2\2\u0126\u012a\t\2\2\2\u0127\u0129"+
		"\t\3\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a\u0128\3\2\2\2\u012a"+
		"\u012b\3\2\2\2\u012bh\3\2\2\2\u012c\u012a\3\2\2\2\u012d\u0131\t\4\2\2"+
		"\u012e\u0130\t\5\2\2\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0136\3\2\2\2\u0133\u0131\3\2\2\2\u0134"+
		"\u0136\7\62\2\2\u0135\u012d\3\2\2\2\u0135\u0134\3\2\2\2\u0136j\3\2\2\2"+
		"\u0137\u013b\7$\2\2\u0138\u013a\5m\67\2\u0139\u0138\3\2\2\2\u013a\u013d"+
		"\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\u013e\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013e\u013f\7$\2\2\u013fl\3\2\2\2\u0140\u0144\n\6\2\2\u0141"+
		"\u0142\7^\2\2\u0142\u0144\t\7\2\2\u0143\u0140\3\2\2\2\u0143\u0141\3\2"+
		"\2\2\u0144n\3\2\2\2\u0145\u0147\t\b\2\2\u0146\u0145\3\2\2\2\u0147\u0148"+
		"\3\2\2\2\u0148\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\3\2\2\2\u014a"+
		"\u014b\b8\2\2\u014bp\3\2\2\2\u014c\u014d\7\61\2\2\u014d\u014e\7\61\2\2"+
		"\u014e\u0152\3\2\2\2\u014f\u0151\n\t\2\2\u0150\u014f\3\2\2\2\u0151\u0154"+
		"\3\2\2\2\u0152\u0150\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0155\3\2\2\2\u0154"+
		"\u0152\3\2\2\2\u0155\u0156\b9\2\2\u0156r\3\2\2\2\u0157\u0158\7\61\2\2"+
		"\u0158\u0159\7,\2\2\u0159\u015d\3\2\2\2\u015a\u015c\13\2\2\2\u015b\u015a"+
		"\3\2\2\2\u015c\u015f\3\2\2\2\u015d\u015e\3\2\2\2\u015d\u015b\3\2\2\2\u015e"+
		"\u0160\3\2\2\2\u015f\u015d\3\2\2\2\u0160\u0161\7,\2\2\u0161\u0162\7\61"+
		"\2\2\u0162\u0163\3\2\2\2\u0163\u0164\b:\2\2\u0164t\3\2\2\2\f\2\u008c\u012a"+
		"\u0131\u0135\u013b\u0143\u0148\u0152\u015d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}