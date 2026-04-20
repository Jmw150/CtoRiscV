package ast;

import ast.visitor.ASTVisitor;

/**
 * Statement wrapper for a nested block.
 */
public class BlockNode implements StatementNode {

    private StatementListNode statements;

    public BlockNode(StatementListNode statements) {
        this.statements = statements;
    }

    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public StatementListNode getStatements() {
        return statements;
    }
}
