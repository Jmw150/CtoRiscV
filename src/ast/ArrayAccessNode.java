package ast;

import ast.visitor.ASTVisitor;
import compiler.Compiler;
import compiler.Scope.ArraySymbolTableEntry;

/**
 * Array element access treated as an lvalue whose address is computed from the
 * array base plus a scaled index expression.
 */
public class ArrayAccessNode extends ExpressionNode {

    private final String id;
    private final ArraySymbolTableEntry symbol;
    private final ExpressionNode index;

    public ArrayAccessNode(String id, ExpressionNode index) {
        this.id = id;
        this.symbol = (ArraySymbolTableEntry) Compiler.symbolTable.getSymbolTableEntry(id);
        this.index = index;
        setType(symbol.getType());
    }

    @Override
    public <R> R accept(ASTVisitor<R> visitor) {
        return visitor.visit(this);
    }

    public String getId() {
        return id;
    }

    public ArraySymbolTableEntry getSymbol() {
        return symbol;
    }

    public ExpressionNode getIndex() {
        return index;
    }
}
