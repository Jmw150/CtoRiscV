package compiler;

import ast.ASTNode;
import ast.ArrayAccessNode;
import ast.BinaryOpNode;
import ast.ExpressionNode;
import ast.FloatLitNode;
import ast.IntLitNode;
import ast.UnaryOpNode;
import ast.VarNode;

/**
 * Small AST cloning helper used to inline expression-bodied helper functions.
 */
public final class ExpressionCloner {

    private ExpressionCloner() {
    }

    public static ExpressionNode clone(ExpressionNode node) {
        return substitute(node, null, null);
    }

    public static ExpressionNode substitute(ExpressionNode node, String parameterName, ExpressionNode replacement) {
        if (node instanceof VarNode) {
            VarNode var = (VarNode) node;
            if (parameterName != null && var.getId().equals(parameterName)) {
                return clone(replacement);
            }
            return new VarNode(var.getId());
        }

        if (node instanceof IntLitNode) {
            return new IntLitNode(((IntLitNode) node).getVal());
        }

        if (node instanceof FloatLitNode) {
            return new FloatLitNode(((FloatLitNode) node).getVal());
        }

        if (node instanceof ArrayAccessNode) {
            ArrayAccessNode array = (ArrayAccessNode) node;
            return new ArrayAccessNode(array.getId(), substitute(array.getIndex(), parameterName, replacement));
        }

        if (node instanceof UnaryOpNode) {
            UnaryOpNode unary = (UnaryOpNode) node;
            return new UnaryOpNode(substitute((ExpressionNode) unary.getExpr(), parameterName, replacement), "-");
        }

        if (node instanceof BinaryOpNode) {
            BinaryOpNode binary = (BinaryOpNode) node;
            return new BinaryOpNode(
                substitute((ExpressionNode) binary.getLeft(), parameterName, replacement),
                substitute((ExpressionNode) binary.getRight(), parameterName, replacement),
                binaryOpToString(binary));
        }

        throw new Error("Cannot inline expression node of type " + node.getClass().getSimpleName());
    }

    private static String binaryOpToString(BinaryOpNode node) {
        switch (node.getOp()) {
            case ADD:
                return "+";
            case SUB:
                return "-";
            case MUL:
                return "*";
            case DIV:
                return "/";
            case REM:
                return "%";
            default:
                throw new Error("Unsupported binary op during inlining");
        }
    }
}
