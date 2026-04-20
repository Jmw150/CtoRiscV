package compiler;

import ast.ExpressionNode;

/**
 * Minimal helper-function representation used for instructional inline
 * expansion. This deliberately avoids introducing a full calling convention.
 */
public class InlineFunction {

    private final String name;
    private final Scope.Type parameterType;
    private final String parameterName;
    private final ExpressionNode body;

    public InlineFunction(String name, Scope.Type parameterType, String parameterName, ExpressionNode body) {
        this.name = name;
        this.parameterType = parameterType;
        this.parameterName = parameterName;
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public Scope.Type getParameterType() {
        return parameterType;
    }

    public String getParameterName() {
        return parameterName;
    }

    public ExpressionNode getBody() {
        return body;
    }
}
