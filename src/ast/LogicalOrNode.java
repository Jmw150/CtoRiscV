package ast;

import ast.visitor.ASTVisitor;

public class LogicalOrNode implements ConditionNode {

    private ConditionNode left;
    private ConditionNode right;

    public LogicalOrNode(ConditionNode left, ConditionNode right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public ConditionNode getLeft() {
        return left;
    }

    public ConditionNode getRight() {
        return right;
    }
}
