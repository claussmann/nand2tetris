package Parser;

import Token.Symbol;
import Token.Token;

import java.io.PrintStream;
import java.util.Queue;

public class Expression {

    private Term term;
    private Symbol op;
    private Term term2;

    public Expression(Queue<Token> tokens){
        term = new Term(tokens);
        String tmp = tokens.peek().getToken();
        if(tmp.equals("+")|| tmp.equals("-") || tmp.equals("=") || tmp.equals("<") || tmp.equals(">")){
            op = (Symbol)tokens.remove();
            term2 = new Term(tokens);
        }
    }

    boolean validate() {
        return op == null || op.equals("+") || op.equals("-") || op.equals("=") || op.equals("<") || op.equals(">");
    }

    public void toXML(PrintStream printStream) {
        printStream.println("<expression>");
        term.toXML(printStream);
        if(op != null){
            printStream.println(op.toXML());
            term.toXML(printStream);
        }
        printStream.println("</expression>");
    }
}
