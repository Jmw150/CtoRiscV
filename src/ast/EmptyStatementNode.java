package ast;

import ast.visitor.ASTVisitor;

/**
 * No-op statement used for declarations that affect the symbol table but do not
 * emit runtime code.
 */
public class EmptyStatementNode implements StatementNode {

    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }
}
