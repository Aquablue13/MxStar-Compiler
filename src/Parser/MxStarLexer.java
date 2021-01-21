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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, Bool=8, Int=9, 
		String=10, Null=11, Void=12, True=13, False=14, If=15, Else=16, For=17, 
		While=18, Break=19, Continue=20, Return=21, New=22, Class=23, This=24, 
		Add=25, Sub=26, Mul=27, Div=28, Mod=29, DbAdd=30, DbSub=31, And=32, Or=33, 
		Xor=34, Not=35, LSh=36, RSh=37, LAnd=38, LOr=39, LNot=40, Les=41, LesEq=42, 
		Gre=43, GreEq=44, Eq=45, NEq=46, Assign=47, LeftBracket=48, RightBracket=49, 
		Identifier=50, Integer=51, StringValue=52, BoolValue=53, WhiteSpace=54, 
		Comment=55, BlockComment=56;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "Bool", "Int", 
			"String", "Null", "Void", "True", "False", "If", "Else", "For", "While", 
			"Break", "Continue", "Return", "New", "Class", "This", "Add", "Sub", 
			"Mul", "Div", "Mod", "DbAdd", "DbSub", "And", "Or", "Xor", "Not", "LSh", 
			"RSh", "LAnd", "LOr", "LNot", "Les", "LesEq", "Gre", "GreEq", "Eq", "NEq", 
			"Assign", "LeftBracket", "RightBracket", "Identifier", "Integer", "StringValue", 
			"BoolValue", "Char", "WhiteSpace", "Comment", "BlockComment"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "','", "'('", "')'", "'.'", "';'", "'bool'", "'int'", 
			"'string'", "'null'", "'void'", "'true'", "'false'", "'if'", "'else'", 
			"'for'", "'while'", "'break'", "'continue'", "'return'", "'new'", "'class'", 
			"'this'", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'&'", "'|'", 
			"'^'", "'~'", "'<<'", "'>>'", "'&&'", "'||'", "'!'", "'<'", "'<='", "'>'", 
			"'>='", "'=='", "'!='", "'='", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "Bool", "Int", "String", 
			"Null", "Void", "True", "False", "If", "Else", "For", "While", "Break", 
			"Continue", "Return", "New", "Class", "This", "Add", "Sub", "Mul", "Div", 
			"Mod", "DbAdd", "DbSub", "And", "Or", "Xor", "Not", "LSh", "RSh", "LAnd", 
			"LOr", "LNot", "Les", "LesEq", "Gre", "GreEq", "Eq", "NEq", "Assign", 
			"LeftBracket", "RightBracket", "Identifier", "Integer", "StringValue", 
			"BoolValue", "WhiteSpace", "Comment", "BlockComment"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2:\u015e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\3\3\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27"+
		"\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*"+
		"\3*\3+\3+\3+\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3/\3\60\3\60\3\61\3\61\3\62"+
		"\3\62\3\63\3\63\7\63\u011e\n\63\f\63\16\63\u0121\13\63\3\64\3\64\7\64"+
		"\u0125\n\64\f\64\16\64\u0128\13\64\3\64\5\64\u012b\n\64\3\65\3\65\7\65"+
		"\u012f\n\65\f\65\16\65\u0132\13\65\3\65\3\65\3\66\3\66\5\66\u0138\n\66"+
		"\3\67\3\67\3\67\5\67\u013d\n\67\38\68\u0140\n8\r8\168\u0141\38\38\39\3"+
		"9\39\39\79\u014a\n9\f9\169\u014d\139\39\39\3:\3:\3:\3:\7:\u0155\n:\f:"+
		"\16:\u0158\13:\3:\3:\3:\3:\3:\3\u0156\2;\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W"+
		"-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m\2o8q9s:\3\2\n\4\2C\\c|\5\2\62;"+
		"C\\c|\3\2\63;\3\2\62;\6\2\f\f\17\17$$^^\6\2$$^^pptt\5\2\13\f\17\17\"\""+
		"\3\2\f\f\2\u0165\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2"+
		"\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k"+
		"\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u\3\2\2\2\5w\3\2\2\2\7y\3\2"+
		"\2\2\t{\3\2\2\2\13}\3\2\2\2\r\177\3\2\2\2\17\u0081\3\2\2\2\21\u0083\3"+
		"\2\2\2\23\u0088\3\2\2\2\25\u008c\3\2\2\2\27\u0093\3\2\2\2\31\u0098\3\2"+
		"\2\2\33\u009d\3\2\2\2\35\u00a2\3\2\2\2\37\u00a8\3\2\2\2!\u00ab\3\2\2\2"+
		"#\u00b0\3\2\2\2%\u00b4\3\2\2\2\'\u00ba\3\2\2\2)\u00c0\3\2\2\2+\u00c9\3"+
		"\2\2\2-\u00d0\3\2\2\2/\u00d4\3\2\2\2\61\u00da\3\2\2\2\63\u00df\3\2\2\2"+
		"\65\u00e1\3\2\2\2\67\u00e3\3\2\2\29\u00e5\3\2\2\2;\u00e7\3\2\2\2=\u00e9"+
		"\3\2\2\2?\u00ec\3\2\2\2A\u00ef\3\2\2\2C\u00f1\3\2\2\2E\u00f3\3\2\2\2G"+
		"\u00f5\3\2\2\2I\u00f7\3\2\2\2K\u00fa\3\2\2\2M\u00fd\3\2\2\2O\u0100\3\2"+
		"\2\2Q\u0103\3\2\2\2S\u0105\3\2\2\2U\u0107\3\2\2\2W\u010a\3\2\2\2Y\u010c"+
		"\3\2\2\2[\u010f\3\2\2\2]\u0112\3\2\2\2_\u0115\3\2\2\2a\u0117\3\2\2\2c"+
		"\u0119\3\2\2\2e\u011b\3\2\2\2g\u012a\3\2\2\2i\u012c\3\2\2\2k\u0137\3\2"+
		"\2\2m\u013c\3\2\2\2o\u013f\3\2\2\2q\u0145\3\2\2\2s\u0150\3\2\2\2uv\7}"+
		"\2\2v\4\3\2\2\2wx\7\177\2\2x\6\3\2\2\2yz\7.\2\2z\b\3\2\2\2{|\7*\2\2|\n"+
		"\3\2\2\2}~\7+\2\2~\f\3\2\2\2\177\u0080\7\60\2\2\u0080\16\3\2\2\2\u0081"+
		"\u0082\7=\2\2\u0082\20\3\2\2\2\u0083\u0084\7d\2\2\u0084\u0085\7q\2\2\u0085"+
		"\u0086\7q\2\2\u0086\u0087\7n\2\2\u0087\22\3\2\2\2\u0088\u0089\7k\2\2\u0089"+
		"\u008a\7p\2\2\u008a\u008b\7v\2\2\u008b\24\3\2\2\2\u008c\u008d\7u\2\2\u008d"+
		"\u008e\7v\2\2\u008e\u008f\7t\2\2\u008f\u0090\7k\2\2\u0090\u0091\7p\2\2"+
		"\u0091\u0092\7i\2\2\u0092\26\3\2\2\2\u0093\u0094\7p\2\2\u0094\u0095\7"+
		"w\2\2\u0095\u0096\7n\2\2\u0096\u0097\7n\2\2\u0097\30\3\2\2\2\u0098\u0099"+
		"\7x\2\2\u0099\u009a\7q\2\2\u009a\u009b\7k\2\2\u009b\u009c\7f\2\2\u009c"+
		"\32\3\2\2\2\u009d\u009e\7v\2\2\u009e\u009f\7t\2\2\u009f\u00a0\7w\2\2\u00a0"+
		"\u00a1\7g\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7h\2\2\u00a3\u00a4\7c\2\2\u00a4"+
		"\u00a5\7n\2\2\u00a5\u00a6\7u\2\2\u00a6\u00a7\7g\2\2\u00a7\36\3\2\2\2\u00a8"+
		"\u00a9\7k\2\2\u00a9\u00aa\7h\2\2\u00aa \3\2\2\2\u00ab\u00ac\7g\2\2\u00ac"+
		"\u00ad\7n\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af\7g\2\2\u00af\"\3\2\2\2\u00b0"+
		"\u00b1\7h\2\2\u00b1\u00b2\7q\2\2\u00b2\u00b3\7t\2\2\u00b3$\3\2\2\2\u00b4"+
		"\u00b5\7y\2\2\u00b5\u00b6\7j\2\2\u00b6\u00b7\7k\2\2\u00b7\u00b8\7n\2\2"+
		"\u00b8\u00b9\7g\2\2\u00b9&\3\2\2\2\u00ba\u00bb\7d\2\2\u00bb\u00bc\7t\2"+
		"\2\u00bc\u00bd\7g\2\2\u00bd\u00be\7c\2\2\u00be\u00bf\7m\2\2\u00bf(\3\2"+
		"\2\2\u00c0\u00c1\7e\2\2\u00c1\u00c2\7q\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4"+
		"\7v\2\2\u00c4\u00c5\7k\2\2\u00c5\u00c6\7p\2\2\u00c6\u00c7\7w\2\2\u00c7"+
		"\u00c8\7g\2\2\u00c8*\3\2\2\2\u00c9\u00ca\7t\2\2\u00ca\u00cb\7g\2\2\u00cb"+
		"\u00cc\7v\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7t\2\2\u00ce\u00cf\7p\2\2"+
		"\u00cf,\3\2\2\2\u00d0\u00d1\7p\2\2\u00d1\u00d2\7g\2\2\u00d2\u00d3\7y\2"+
		"\2\u00d3.\3\2\2\2\u00d4\u00d5\7e\2\2\u00d5\u00d6\7n\2\2\u00d6\u00d7\7"+
		"c\2\2\u00d7\u00d8\7u\2\2\u00d8\u00d9\7u\2\2\u00d9\60\3\2\2\2\u00da\u00db"+
		"\7v\2\2\u00db\u00dc\7j\2\2\u00dc\u00dd\7k\2\2\u00dd\u00de\7u\2\2\u00de"+
		"\62\3\2\2\2\u00df\u00e0\7-\2\2\u00e0\64\3\2\2\2\u00e1\u00e2\7/\2\2\u00e2"+
		"\66\3\2\2\2\u00e3\u00e4\7,\2\2\u00e48\3\2\2\2\u00e5\u00e6\7\61\2\2\u00e6"+
		":\3\2\2\2\u00e7\u00e8\7\'\2\2\u00e8<\3\2\2\2\u00e9\u00ea\7-\2\2\u00ea"+
		"\u00eb\7-\2\2\u00eb>\3\2\2\2\u00ec\u00ed\7/\2\2\u00ed\u00ee\7/\2\2\u00ee"+
		"@\3\2\2\2\u00ef\u00f0\7(\2\2\u00f0B\3\2\2\2\u00f1\u00f2\7~\2\2\u00f2D"+
		"\3\2\2\2\u00f3\u00f4\7`\2\2\u00f4F\3\2\2\2\u00f5\u00f6\7\u0080\2\2\u00f6"+
		"H\3\2\2\2\u00f7\u00f8\7>\2\2\u00f8\u00f9\7>\2\2\u00f9J\3\2\2\2\u00fa\u00fb"+
		"\7@\2\2\u00fb\u00fc\7@\2\2\u00fcL\3\2\2\2\u00fd\u00fe\7(\2\2\u00fe\u00ff"+
		"\7(\2\2\u00ffN\3\2\2\2\u0100\u0101\7~\2\2\u0101\u0102\7~\2\2\u0102P\3"+
		"\2\2\2\u0103\u0104\7#\2\2\u0104R\3\2\2\2\u0105\u0106\7>\2\2\u0106T\3\2"+
		"\2\2\u0107\u0108\7>\2\2\u0108\u0109\7?\2\2\u0109V\3\2\2\2\u010a\u010b"+
		"\7@\2\2\u010bX\3\2\2\2\u010c\u010d\7@\2\2\u010d\u010e\7?\2\2\u010eZ\3"+
		"\2\2\2\u010f\u0110\7?\2\2\u0110\u0111\7?\2\2\u0111\\\3\2\2\2\u0112\u0113"+
		"\7#\2\2\u0113\u0114\7?\2\2\u0114^\3\2\2\2\u0115\u0116\7?\2\2\u0116`\3"+
		"\2\2\2\u0117\u0118\7]\2\2\u0118b\3\2\2\2\u0119\u011a\7_\2\2\u011ad\3\2"+
		"\2\2\u011b\u011f\t\2\2\2\u011c\u011e\t\3\2\2\u011d\u011c\3\2\2\2\u011e"+
		"\u0121\3\2\2\2\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120f\3\2\2\2"+
		"\u0121\u011f\3\2\2\2\u0122\u0126\t\4\2\2\u0123\u0125\t\5\2\2\u0124\u0123"+
		"\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127"+
		"\u012b\3\2\2\2\u0128\u0126\3\2\2\2\u0129\u012b\7\62\2\2\u012a\u0122\3"+
		"\2\2\2\u012a\u0129\3\2\2\2\u012bh\3\2\2\2\u012c\u0130\7$\2\2\u012d\u012f"+
		"\5m\67\2\u012e\u012d\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0130"+
		"\u0131\3\2\2\2\u0131\u0133\3\2\2\2\u0132\u0130\3\2\2\2\u0133\u0134\7$"+
		"\2\2\u0134j\3\2\2\2\u0135\u0138\5\33\16\2\u0136\u0138\5\35\17\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0136\3\2\2\2\u0138l\3\2\2\2\u0139\u013d\n\6\2\2"+
		"\u013a\u013b\7^\2\2\u013b\u013d\t\7\2\2\u013c\u0139\3\2\2\2\u013c\u013a"+
		"\3\2\2\2\u013dn\3\2\2\2\u013e\u0140\t\b\2\2\u013f\u013e\3\2\2\2\u0140"+
		"\u0141\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0143\3\2"+
		"\2\2\u0143\u0144\b8\2\2\u0144p\3\2\2\2\u0145\u0146\7\61\2\2\u0146\u0147"+
		"\7\61\2\2\u0147\u014b\3\2\2\2\u0148\u014a\n\t\2\2\u0149\u0148\3\2\2\2"+
		"\u014a\u014d\3\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014e"+
		"\3\2\2\2\u014d\u014b\3\2\2\2\u014e\u014f\b9\2\2\u014fr\3\2\2\2\u0150\u0151"+
		"\7\61\2\2\u0151\u0152\7,\2\2\u0152\u0156\3\2\2\2\u0153\u0155\13\2\2\2"+
		"\u0154\u0153\3\2\2\2\u0155\u0158\3\2\2\2\u0156\u0157\3\2\2\2\u0156\u0154"+
		"\3\2\2\2\u0157\u0159\3\2\2\2\u0158\u0156\3\2\2\2\u0159\u015a\7,\2\2\u015a"+
		"\u015b\7\61\2\2\u015b\u015c\3\2\2\2\u015c\u015d\b:\2\2\u015dt\3\2\2\2"+
		"\f\2\u011f\u0126\u012a\u0130\u0137\u013c\u0141\u014b\u0156\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}