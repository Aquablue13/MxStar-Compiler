grammar MxStar;

//Parser

program : programUnit* EOF;

programUnit : classDef | varDef | funcDef;

classDef :
	Class Identifier '{' (varDef | funcDef)* '}'
;

varDef :
	type onevarDef (',' onevarDef)*
;

type :
	(Bool | Int | String | Identifier) ('[' ']')*
;

funcDef :
	funcType Identifier ('(' parameters? ')') block
;

funcType : type | Void;

onevarDef :
	Identifier (Assign expr)?
;

expr :
	atomExpression																#atomExpr
	| New creator																#creatorExpr
	| expr '.' Identifier 														#memberExpr
	| Identifier ('(' parameters? ')')											#funcExpr
	| '(' expr ')'																#parenExpr
	| expr '[' expr ']'															#subscriptExpr
	| expr (DbAdd | DbSub) 														#suffixExpr
	| <assoc = right> (Not | LNot | DbAdd | DbSub | Add | Sub) expr 			#prefixExpr
	| expr (Mul | Div | Mod) expr 												#binaryExpr
	| expr (Add | Sub) expr 													#binaryExpr
	| expr (LSh | RSh) expr 													#binaryExpr
	| expr (Les | LesEq | Gre | GreEq) expr 									#binaryExpr
	| expr (Eq | NEq) expr 														#binaryExpr
	| expr And expr 															#binaryExpr
	| expr Xor expr 															#binaryExpr
	| expr Or expr 																#binaryExpr
	| expr LAnd expr 															#binaryExpr
	| expr LOr expr 															#binaryExpr
	| <assoc = right> expr Assign expr 											#assignExpr
;

atomExpression :
	Integer 																	#intExpr
	| Identifier																#identifierExpr
	| StringValue																#stringExpr
	| (True | False)															#boolExpr
	| This 																		#thisExpr
	| Null 																		#nullExpr
;

creator :
	(Bool | Int | String | Identifier) ('[' expr ']')+ ('[' ']')+ ('[' expr ']')+ 	#errorCreator
	| (Bool | Int | String | Identifier) ('[' expr ']')+ ('[' ']')*				 	#arrayCreator
	| (Bool | Int | String | Identifier) ('(' ')')? 								#restCreator
;

parameters :
	parameter (',' parameter)*
;

parameter : type Identifier;

block :
	('{' statement* '}')
;

statement :
	varDef ';'																	#vardefStat

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

Identifier :
	[a-zA-Z] [a-zA-Z0-9]*
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