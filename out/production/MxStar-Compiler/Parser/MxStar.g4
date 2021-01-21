grammar MxStar;

//Parser

program : programUnit* EOF;

programUnit : classDef | varDef | funcDef;

classDef :
	Class Identifier '{' (varDef | funcDef)* '}' ';'
;

varDef :
	type oneVarDef (',' oneVarDef)* ';'
;

type :
	basicType (LeftBracket RightBracket)*
;

basicType :
	Bool | Int | String | Identifier
;

oneVarDef :
	Identifier (Assign expr)?
;

funcDef :
	funcType? Identifier ('(' parameters? ')') block
;

funcType : type | Void;

parameters :
	parameter (',' parameter)*
;

parameter : type Identifier;

expr :
	atomExpression																#atomExpr
	| <assoc=right> New creator													#creatorExpr
	| expr '.' Identifier 														#memberExpr
	| expr ('(' exprs? ')')														#funcExpr
	| '(' expr ')'																#parenExpr
	| expr LeftBracket expr RightBracket										#subscriptExpr
	| expr op=(DbAdd | DbSub) 													#suffixExpr
	| <assoc = right> op=(DbAdd | DbSub) expr 									#prefixExpr
	| <assoc = right> op=(Add | Sub) expr 										#prefixExpr
	| <assoc = right> op=(Not | LNot) expr 										#prefixExpr
	| expr op=(Mul | Div | Mod) expr 											#binaryExpr
	| expr op=(Add | Sub) expr 													#binaryExpr
	| expr op=(LSh | RSh) expr 													#binaryExpr
	| expr op=(Les | LesEq | Gre | GreEq) expr 									#binaryExpr
	| expr op=(Eq | NEq) expr 													#binaryExpr
	| expr op=And expr 															#binaryExpr
	| expr op=Xor expr 															#binaryExpr
	| expr op=Or expr 															#binaryExpr
	| expr op=LAnd expr 														#binaryExpr
	| expr op=LOr expr 															#binaryExpr
	| <assoc = right> expr op=Assign expr 										#assignExpr
;

atomExpression :
	Integer 																	#intExpr
	| Identifier																#identifierExpr
	| StringValue																#stringExpr
	| BoolValue																	#boolExpr
	| This 																		#thisExpr
	| Null 																		#nullExpr
;

BoolValue : 'true' | 'false';

creator :
	basicType (LeftBracket expr RightBracket)+ (LeftBracket RightBracket)+ (LeftBracket expr RightBracket)+ 	#errorCreator
	| basicType (LeftBracket expr RightBracket)+ (LeftBracket RightBracket)*				 	#arrayCreator
	| basicType ('(' ')')? 								#restCreator
;

exprs :
	expr (',' expr)*
;

block :
	('{' statement* '}')
;

statement :
	varDef																	#varDefStat

	| Break ';'																	#breakStat
	| Continue ';'																#continueStat
	| Return expr? ';'															#returnStat

	| block 																	#blockStat
	| expr ';'																	#exprStat
	| ';'																		#nullStat

	| forStatement																#forStat
	| ifStatement																#ifStat
	| whileStatement															#whileStat	
;

forStatement :
	For '(' init=expr? ';' cond=expr? ';' change=expr? ')'
		statement
;

ifStatement :
	If '(' expr ')' trueStat = statement
		(Else falseStat = statement)?
;

whileStatement :
	While '(' expr ')'
		statement
;

//Lexer
Bool : 'bool';
Int : 'int';
String : 'string';
Null: 'null';
Void : 'void';

True : 'true';
False : 'false';

If : 'if';
Else : 'else';
For : 'for';
While : 'while';

Break : 'break';
Continue : 'continue';
Return : 'return';

New : 'new';
Class : 'class';
This : 'this';

Add : '+';
Sub : '-';
Mul : '*';
Div : '/';
Mod : '%';
DbAdd : '++';
DbSub : '--';

And : '&';
Or : '|';
Xor : '^';
Not : '~';
LSh : '<<';
RSh : '>>';

LAnd : '&&';
LOr : '||';
LNot : '!';

Les : '<';
LesEq : '<=';
Gre : '>';
GreEq : '>=';
Eq : '==';
NEq : '!=';

Assign : '=';

LeftBracket : '[';
RightBracket : ']';

Identifier :
	[a-zA-Z] [a-zA-Z0-9_]*
;

Integer :
	([1-9] [0-9]*)
	| '0'
;

StringValue : '"' Char* '"';

fragment
Char :
	~["\n\r\\]
	| '\\' ["nr\\]
;

WhiteSpace :
	[ \t\n\r]+
		->skip
;

Comment :
	'//' (~'\n')*
		-> skip
;

BlockComment : 
	'/*' .*? '*/'
		-> skip
;