package ast;

import ast.visitor.ASTVisitor;
import compiler.Scope;

/**
 * Node for binary expressions
 * 
 * It has two children:
 * 
 * 1. <code>left</code>
 * 2. <code>right</code>
 * 
 * for the two sides of the binary op
 * 
 * It also keeps track of the operation type
 */
public class BinaryOpNode extends ExpressionNode {

	public enum OpType {
		ADD,
		SUB,
		MUL,
		DIV,
		REM
	}
	
	private ExpressionNode left;
	private ExpressionNode right;
	private OpType op;
	
	public BinaryOpNode(ExpressionNode left, ExpressionNode right, String op) {
		this.setLeft(left);
		this.setRight(right);
		this.setOp(getOpFromString(op));
		if (left.getType() == Scope.Type.FLOAT || right.getType() == Scope.Type.FLOAT) {
			this.setType(Scope.Type.FLOAT);
		} else {
			this.setType(Scope.Type.INT);
		}
	}
		
	private OpType getOpFromString(String s) {
		switch (s) {
		case "+" : return OpType.ADD;
		case "-" : return OpType.SUB;
		case "/" : return OpType.DIV;
		case "*" : return OpType.MUL;
		case "%" : return OpType.REM;
		default : throw new Error ("Unrecognized op type");
		}
	}

	@Override
	public <R> R accept(ASTVisitor<R> visitor) {
		return visitor.visit(this);
	}

	public ASTNode getLeft() {
		return left;
	}

	private void setLeft(ExpressionNode left) {
		this.left = left;
	}

	public ASTNode getRight() {
		return right;
	}

	private void setRight(ExpressionNode right) {
		this.right = right;
	}

	public OpType getOp() {
		return op;
	}

	private void setOp(OpType op) {
		this.op = op;
	}

}
