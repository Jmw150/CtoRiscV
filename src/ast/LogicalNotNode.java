package ast;

import ast.visitor.ASTVisitor;

public class LogicalNotNode implements ConditionNode {

    private ConditionNode child;

    public LogicalNotNode(ConditionNode child) {
        this.child = child;
    }

    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public ConditionNode getChild() {
        return child;
    }
}
