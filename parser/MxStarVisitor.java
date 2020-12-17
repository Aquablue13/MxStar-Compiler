// Generated from MxStar.g4 by ANTLR 4.6
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MxStarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MxStarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MxStarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MxStarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#programUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramUnit(MxStarParser.ProgramUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#classDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDef(MxStarParser.ClassDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#varDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDef(MxStarParser.VarDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MxStarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(MxStarParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#funcType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncType(MxStarParser.FuncTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#onevarDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnevarDef(MxStarParser.OnevarDefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpr(MxStarParser.PrefixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(MxStarParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subscriptExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscriptExpr(MxStarParser.SubscriptExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberExpr(MxStarParser.MemberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuffixExpr(MxStarParser.SuffixExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomExpr(MxStarParser.AtomExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryExpr(MxStarParser.BinaryExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code creatorExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreatorExpr(MxStarParser.CreatorExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignExpr(MxStarParser.AssignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MxStarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(MxStarParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntExpr(MxStarParser.IntExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifierExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpr(MxStarParser.IdentifierExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(MxStarParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(MxStarParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpr(MxStarParser.ThisExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullExpr}
	 * labeled alternative in {@link MxStarParser#atomExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullExpr(MxStarParser.NullExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code errorCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorCreator(MxStarParser.ErrorCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreator(MxStarParser.ArrayCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code restCreator}
	 * labeled alternative in {@link MxStarParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRestCreator(MxStarParser.RestCreatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(MxStarParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MxStarParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MxStarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vardefStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardefStat(MxStarParser.VardefStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStat(MxStarParser.BreakStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStat(MxStarParser.ContinueStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(MxStarParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStat(MxStarParser.BlockStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStat(MxStarParser.ExprStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullStat(MxStarParser.NullStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStat(MxStarParser.ForStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStat(MxStarParser.IfStatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MxStarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStat(MxStarParser.WhileStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(MxStarParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(MxStarParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MxStarParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(MxStarParser.WhileStatementContext ctx);
}