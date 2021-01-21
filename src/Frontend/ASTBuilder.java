package Frontend;

import AST.*;
import Parser.MxStarBaseVisitor;
import Parser.MxStarParser;
import Util.Error.syntaxError;
import Util.Type.arrayType;
import Util.position;
import org.antlr.v4.runtime.ParserRuleContext;


import java.util.ArrayList;

public class ASTBuilder extends MxStarBaseVisitor<ASTNode> {
    @Override
    public ASTNode visitProgram(MxStarParser.ProgramContext ctx) {
        RootNode t = new RootNode(new position(ctx));
        for (ParserRuleContext ch : ctx.programUnit()) {
            ASTNode tch = visit(ch);
            if (tch instanceof varDefNode) {
                t.body.addAll(((varDefNode) tch).vars);
            } else {
                t.body.add(tch);
            }
        }
        return t;
    }

    @Override
    public ASTNode visitProgramUnit(MxStarParser.ProgramUnitContext ctx) {
        if (ctx.classDef() != null)
            return visit(ctx.classDef());
        if (ctx.varDef() != null)
            return visit(ctx.varDef());
        if (ctx.funcDef() != null)
            return visit(ctx.funcDef());
        return null;
    }

    @Override
    public ASTNode visitClassDef(MxStarParser.ClassDefContext ctx) {
        classDefNode t = new classDefNode(new position(ctx), ctx.Identifier().getText());
        for (ParserRuleContext ch : ctx.varDef()) {
            varDefNode tch = (varDefNode) visit(ch);
            t.vars.addAll(tch.vars);
        }
        for (ParserRuleContext ch : ctx.funcDef()) {
            funcDefNode tch = (funcDefNode) visit(ch);
            if (tch.type == null)
                t.constructor = tch;
            else
                t.funcs.add(tch);
        }
        return t;
    }

    @Override
    public ASTNode visitVarDef(MxStarParser.VarDefContext ctx) {
        typeNode type = (typeNode) visit(ctx.type());
        varDefNode t = new varDefNode(new position(ctx));
        for (ParserRuleContext ch : ctx.oneVarDef()) {
            oneVarDefNode tch = (oneVarDefNode) visit(ch);
            tch.type = type;
            t.vars.add(tch);
        }
        return t;
    }

    @Override
    public ASTNode visitType(MxStarParser.TypeContext ctx) {
        typeNode t = new typeNode(new position(ctx), ctx.basicType().getText(), ctx.LeftBracket().size());
        return t;
    }

    @Override
    public ASTNode visitBasicType(MxStarParser.BasicTypeContext ctx) {
        typeNode t = new typeNode(new position(ctx), ctx.getText(), 0);
        return t;
    }

    @Override
    public ASTNode visitOneVarDef(MxStarParser.OneVarDefContext ctx) {
        oneVarDefNode t = new oneVarDefNode(new position(ctx), ctx.Identifier().getText());
        if (ctx.expr() != null)
            t.expr = (ExprNode) visit(ctx.expr());
        else
            t.expr = null;
        return t;
    }

    @Override
    public ASTNode visitFuncDef(MxStarParser.FuncDefContext ctx) {
        funcDefNode t = new funcDefNode(new position(ctx));
        if (ctx.funcType() != null)
            t.type = (typeNode) visit(ctx.funcType());
        else
            t.type = null;
        t.name = ctx.Identifier().getText();
        if (ctx.parameters() != null) {
            t.parameters = ((varDefNode) visit(ctx.parameters())).vars;
        } else {
            t.parameters = new ArrayList<>();
        }
        t.block = (blockStatNode) visit(ctx.block());
        return t;
    }

    @Override
    public ASTNode visitFuncType(MxStarParser.FuncTypeContext ctx) {
        if (ctx.type() != null)
            return visit(ctx.type());
        else {
            typeNode t = new typeNode(new position(ctx),"void", 0);
            return t;
        }
    }

    @Override
    public ASTNode visitParameters(MxStarParser.ParametersContext ctx) {
        varDefNode t = new varDefNode(new position(ctx));
        for (ParserRuleContext ch : ctx.parameter()) {
            oneVarDefNode tch = (oneVarDefNode) visit(ch);
            t.vars.add(tch);
        }
        return t;
    }

    @Override
    public ASTNode visitParameter(MxStarParser.ParameterContext ctx) {
        oneVarDefNode t = new oneVarDefNode(new position(ctx), ctx.Identifier().getText(), null);
        t.type = (typeNode) visit(ctx.type());
        return t;
    }

    @Override
    public ASTNode visitAtomExpr(MxStarParser.AtomExprContext ctx) {
        return visit(ctx.atomExpression());
    }

    @Override
    public ASTNode visitIntExpr(MxStarParser.IntExprContext ctx) {
        if (ctx.Integer() != null)
            return new intExprNode(new position(ctx), Integer.parseInt(ctx.Integer().getText()));
        return null;
    }

    @Override
    public ASTNode visitIdentifierExpr(MxStarParser.IdentifierExprContext ctx) {
        if (ctx.Identifier() != null)
            return new identifierExprNode(new position(ctx), ctx.Identifier().getText());
        return null;
    }

    @Override
    public ASTNode visitStringExpr(MxStarParser.StringExprContext ctx) {
        if (ctx.StringValue() != null)
            return new stringExprNode(new position(ctx), ctx.StringValue().getText());
        return null;
    }

    @Override
    public ASTNode visitBoolExpr(MxStarParser.BoolExprContext ctx){
        if (ctx.BoolValue() != null)
            return new boolExprNode(new position(ctx), Boolean.parseBoolean(ctx.BoolValue().getText()));
        return null;
    }

    @Override
    public ASTNode visitThisExpr(MxStarParser.ThisExprContext ctx){
        if (ctx.This() != null)
            return new thisExprNode(new position(ctx));
        return null;
    }

    @Override
    public ASTNode visitNullExpr(MxStarParser.NullExprContext ctx){
        if (ctx.Null() != null)
            return new nullExprNode(new position(ctx));
        return null;
    }

    @Override
    public ASTNode visitCreatorExpr(MxStarParser.CreatorExprContext ctx) {
        return visit(ctx.creator());
    }

    @Override
    public ASTNode visitErrorCreator(MxStarParser.ErrorCreatorContext ctx) {
        throw new syntaxError("ErrorCreator", new position(ctx));
    }

    @Override
    public ASTNode visitArrayCreator(MxStarParser.ArrayCreatorContext ctx) {
        ArrayList<ExprNode> exprs = new ArrayList<>();
        for (ParserRuleContext ch : ctx.expr()) {
            exprs.add((ExprNode) visit(ch));
        }
        typeNode t = new typeNode(new position(ctx), ctx.basicType().getText(), ctx.LeftBracket().size());
        return new creatorExprNode(new position(ctx), t.getType(), t, exprs);
    }

    @Override
    public ASTNode visitRestCreator(MxStarParser.RestCreatorContext ctx) {
        typeNode t = new typeNode(new position(ctx), ctx.basicType().getText(), 0);
        return new creatorExprNode(new position(ctx), t.getType(), t, null);
    }

    @Override
    public ASTNode visitMemberExpr(MxStarParser.MemberExprContext ctx) {
        return new memberExprNode(new position(ctx), (ExprNode) visit(ctx.expr()), ctx.Identifier().getText());
    }

    @Override
    public ASTNode visitFuncExpr(MxStarParser.FuncExprContext ctx) {
    //    funcExprNode t = new funcExprNode(new position(ctx));
        ExprNode head = (ExprNode) visit(ctx.expr());
        if (head instanceof memberExprNode) {
            ((memberExprNode) head).isFunc = true;
            head.isAssignable = false;
        }
        ArrayList<ExprNode> para;
        if (ctx.exprs() != null)
            para = ((exprsExprNode) visit(ctx.exprs())).exprs;
        else
            para = new ArrayList<>();
        return new funcExprNode(new position(ctx), head, para);
    }

    @Override
    public exprsExprNode visitExprs(MxStarParser.ExprsContext ctx) {
        exprsExprNode t = new exprsExprNode(new position(ctx));
        for (ParserRuleContext ch : ctx.expr()) {
            t.exprs.add((ExprNode) visit(ch));
        }
        return t;
    }

    public ASTNode visitParenExpr(MxStarParser.ParenExprContext ctx) {
        if (ctx.expr() != null)
            return visit(ctx.expr());
        return null;
    }

    @Override
    public ASTNode visitSubscriptExpr(MxStarParser.SubscriptExprContext ctx) {
        return new subscriptExprNode(new position(ctx), (ExprNode) visit(ctx.expr(0)), (ExprNode) visit(ctx.expr(1)));
    }

    @Override
    public ASTNode visitSuffixExpr(MxStarParser.SuffixExprContext ctx) {
        return new suffixExprNode(new position(ctx), (ExprNode) visit(ctx.expr()), ctx.op.getText());
    }

    @Override
    public ASTNode visitPrefixExpr(MxStarParser.PrefixExprContext ctx) {
        return new prefixExprNode(new position(ctx), (ExprNode) visit(ctx.expr()), ctx.op.getText());
    }

    @Override
    public ASTNode visitBinaryExpr(MxStarParser.BinaryExprContext ctx) {
        return new binaryExprNode(new position(ctx), (ExprNode) visit(ctx.expr(0)), (ExprNode) visit(ctx.expr(1)), ctx.op.getText());
    }

    @Override
    public ASTNode visitAssignExpr(MxStarParser.AssignExprContext ctx) {
        return new assignExprNode(new position(ctx), (ExprNode) visit(ctx.expr(0)), (ExprNode) visit(ctx.expr(1)), ctx.op.getText());
    }

    @Override
    public ASTNode visitBlock(MxStarParser.BlockContext ctx) {
        blockStatNode t = new blockStatNode(new position(ctx));
        for (ParserRuleContext ch : ctx.statement()) {
            StatNode tch = (StatNode) visit(ch);
            t.stats.add(tch);
        }
        return t;
    }

    @Override
    public ASTNode visitVarDefStat(MxStarParser.VarDefStatContext ctx) {
        return visit(ctx.varDef());
    }

    @Override
    public ASTNode visitBreakStat(MxStarParser.BreakStatContext ctx) {
        return new breakStatNode(new position(ctx));
    }

    @Override
    public ASTNode visitContinueStat(MxStarParser.ContinueStatContext ctx) {
        return new continueStatNode(new position(ctx));
    }

    @Override
    public ASTNode visitReturnStat(MxStarParser.ReturnStatContext ctx) {
        ExprNode t;
        if (ctx.expr() != null)
            t = (ExprNode) visit(ctx.expr());
        else
            t = null;
        return new returnStatNode(new position(ctx), t);
    }

    @Override
    public ASTNode visitBlockStat(MxStarParser.BlockStatContext ctx) {
        return visit(ctx.block());
    }

    @Override
    public ASTNode visitExprStat(MxStarParser.ExprStatContext ctx) {
        return new exprStatNode(new position(ctx), (ExprNode) visit(ctx.expr()));
    }

    @Override
    public ASTNode visitNullStat(MxStarParser.NullStatContext ctx) {
        return new nullStatNode(new position(ctx));
    }

    @Override
    public ASTNode visitForStat(MxStarParser.ForStatContext ctx) {
        return visit(ctx.forStatement());
    }

    @Override
    public ASTNode visitForStatement(MxStarParser.ForStatementContext ctx) {
        ExprNode init = null;
        if (ctx.init != null)
            init = (ExprNode) visit(ctx.init);
        ExprNode cond = null;
        if (ctx.cond != null)
            cond = (ExprNode) visit(ctx.cond);
        ExprNode change = null;
        if (ctx.change != null)
            change = (ExprNode) visit(ctx.change);
        return new forStatNode(new position(ctx), init, cond, change, (StatNode) visit(ctx.statement()));
    }

    @Override
    public ASTNode visitIfStat(MxStarParser.IfStatContext ctx) {
        return visit(ctx.ifStatement());
    }

    @Override
    public ASTNode visitIfStatement(MxStarParser.IfStatementContext ctx) {
        ExprNode cond = (ExprNode)visit(ctx.expr());
        StatNode trueStat = (StatNode)visit(ctx.trueStat);
        StatNode falseStat = null;
        if (ctx.falseStat != null)
            falseStat = (StatNode)visit(ctx.falseStat);
        return new ifStatNode(new position(ctx), cond, trueStat, falseStat);
    }

    @Override
    public ASTNode visitWhileStat(MxStarParser.WhileStatContext ctx) {
        return visit(ctx.whileStatement());
    }

    @Override
    public ASTNode visitWhileStatement(MxStarParser.WhileStatementContext ctx) {
        return new whileStatNode(new position(ctx), (ExprNode) visit(ctx.expr()), (StatNode) visit(ctx.statement()));
    }
}