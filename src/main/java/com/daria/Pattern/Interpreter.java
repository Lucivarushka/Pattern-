package main.java.com.daria.Pattern;

public class Interpreter {
    public static void main(String[] args) {
        String line = "TesT";
        Context context = new Context();
        Expression reverseExpression = new ReverseExpression(line);
        line = reverseExpression.interpret(context);
        System.out.println(line);
    }
}

interface Expression {
    String interpret(Context context);
}

class Context {
    public String getReverseString(String line) {
        return new StringBuffer(line).reverse().toString();
    }
}

class ReverseExpression implements Expression {
    private String line;

    public ReverseExpression(String line) {
        this.line = line;
    }

    public String interpret(Context context) {
        return context.getReverseString(line);
    }
}


