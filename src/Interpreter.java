import java.util.Stack;

/**
 * Created by abdullahodibat.
 */
public class Interpreter {

    public static void main(String args[]) {
        String str = "4 3 1 + *";
        Stack<Expression> stack = new Stack<>();

        String[] tokenList = str.split(" ");
        for (String s : tokenList) {
            if (isOperator(s)) {
                Expression rightExpression = stack.pop();
                Expression leftExpression = stack.pop();
                Expression operator = getOperatorInstance(s, leftExpression,
                        rightExpression);
                int result = operator.interpret();
                stack.push(new NumberExpression(result));
            } else {
                Expression i = new NumberExpression(s);
                stack.push(i);
            }
        }
        System.out.println("Result: " + stack.pop().interpret());
    }

    public static boolean isOperator(String s) {
        if (s.equals("+") || s.equals("*"))
            return true;
        else
            return false;
    }

    public static Expression getOperatorInstance(String s, Expression left,
                                                 Expression right) {
        switch (s) {
            case "+":
                return new PlusExpression(left, right);
            case "*":
                return new MultiplyExpression(left, right);
        }
        return null;
    }


    interface Expression {
        int interpret();
    }

    static class NumberExpression implements Expression {
        int number;

        public NumberExpression(int i) {
            number = i;
        }

        public NumberExpression(String s) {
            number = Integer.parseInt(s);
        }

        @Override
        public int interpret() {
            return number;
        }
    }

    static class MultiplyExpression implements Expression {
        Expression leftExpression;
        Expression rightExpresion;

        public MultiplyExpression(Expression leftExpression,
                                  Expression rightExpresion) {
            this.leftExpression = leftExpression;
            this.rightExpresion = rightExpresion;
        }

        @Override
        public int interpret() {
            return leftExpression.interpret() * rightExpresion.interpret();
        }

    }

    static class PlusExpression implements Expression {
        Expression leftExpression;
        Expression rightExpresion;

        public PlusExpression(Expression leftExpression, Expression rightExpresion) {
            this.leftExpression = leftExpression;
            this.rightExpresion = rightExpresion;
        }

        @Override
        public int interpret() {
            return leftExpression.interpret() + rightExpresion.interpret();
        }

    }

}
