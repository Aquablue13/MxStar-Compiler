// Generated from MxStar.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MxStarParser}.
 */
public interface MxStarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#programUnit}.
	 * @param ctx the parse tree
	 */
	void enterProgramUnit(MxStarParser.ProgramUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#programUnit}.
	 * @param ctx the parse tree
	 */
	void exitProgramUnit(MxStarParser.ProgramUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void enterClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 */
	void exitClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void enterVarDef(MxStarParser.VarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 */
	void exitVarDef(MxStarParser.VarDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MxStarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MxStarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(MxStarParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(MxStarParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#funcType}.
	 * @param ctx the parse tree
	 */
	void enterFuncType(MxStarParser.FuncTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#funcType}.
	 * @param ctx the parse tree
	 */
	void exitFuncType(MxStarParser.FuncTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#onevarDef}.
	 * @param ctx the parse tree
	 */
	void enterOnevarDef(MxStarParser.OnevarDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#onevarDef}.
	 * @param ctx the parse tree
	 */
	void exitOnevarDef(MxStarParser.OnevarDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(MxStarParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(MxStarParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(MxStarParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(MxStarParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubscriptExpr(MxStarParser.SubscriptExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubscriptExpr(MxStarParser.SubscriptExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(MxStarParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(MxStarParser.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSuffixExpr(MxStarParser.SuffixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSuffixExpr(MxStarParser.SuffixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAtomExpr(MxStarParser.AtomExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAtomExpr(MxStarParser.AtomExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MxStarParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MxStarParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code creatorExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCreatorExpr(MxStarParser.CreatorExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code creatorExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCreatorExpr(MxStarParser.CreatorExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MxStarParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MxStarParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MxStarParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MxStarParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void enterIntExpr(MxStarParser.IntExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void exitIntExpr(MxStarParser.IntExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpr(MxStarParser.IdentifierExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpr(MxStarParser.IdentifierExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(MxStarParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(MxStarParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpr(MxStarParser.BoolExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpr(MxStarParser.BoolExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(MxStarParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(MxStarParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpr(MxStarParser.NullExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpr(MxStarParser.NullExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code errorCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterErrorCreator(MxStarParser.ErrorCreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code errorCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitErrorCreator(MxStarParser.ErrorCreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreator(MxStarParser.ArrayCreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreator(MxStarParser.ArrayCreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code restCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterRestCreator(MxStarParser.RestCreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code restCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitRestCreator(MxStarParser.RestCreatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(MxStarParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(MxStarParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MxStarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MxStarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vardefStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVardefStat(MxStarParser.VardefStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vardefStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVardefStat(MxStarParser.VardefStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(MxStarParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(MxStarParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStat(MxStarParser.ContinueStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStat(MxStarParser.ContinueStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(MxStarParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(MxStarParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(MxStarParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(MxStarParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(MxStarParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(MxStarParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterNullStat(MxStarParser.NullStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitNullStat(MxStarParser.NullStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStat(MxStarParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStat(MxStarParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MxStarParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MxStarParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MxStarParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MxStarParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MxStarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(MxStarParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MxStarParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(MxStarParser.WhileStatementContext ctx);
}