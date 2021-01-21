package AST;

public interface ASTVisitor {
    void visit(RootNode it);
    void visit(classDefNode it);
    void visit(varDefNode it);
    void visit(funcDefNode it);
    void visit(typeNode it);
    void visit(oneVarDefNode it);

    void visit(intExprNode it);
    void visit(identifierExprNode it);
    void visit(stringExprNode it);
    void visit(boolExprNode it);
    void visit(thisExprNode it);
    void visit(nullExprNode it);
    void visit(creatorExprNode it);
    void visit(memberExprNode it);
    void visit(funcExprNode it);
    void visit(exprsExprNode it);
    void visit(parenExprNode it);
    void visit(subscriptExprNode it);
    void visit(prefixExprNode it);
    void visit(suffixExprNode it);
    void visit(binaryExprNode it);
    void visit(assignExprNode it);

    void visit(varDefStatNode it);
    void visit(continueStatNode it);
    void visit(breakStatNode it);
    void visit(returnStatNode it);
    void visit(blockStatNode it);
    void visit(exprStatNode it);
    void visit(nullStatNode it);
    void visit(forStatNode it);
    void visit(ifStatNode it);
    void visit(whileStatNode it);
}