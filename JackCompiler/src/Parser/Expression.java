package Parser;

import Token.Symbol;
import Token.Token;

import java.util.Queue;

public class Expression {

    private Term term;
    private Symbol op;
    private Term term2;

    public Expression(Queue<Token> tokens){
        term = (Term)tokens.remove();
        String tmp = tokens.peek().getToken();
        if(tmp.equals("+")|| tmp.equals("-") || tmp.equals("=") || tmp.equals("<") || tmp.equals(">")){
            op = (Symbol)tokens.remove();
            term2 = (Term)tokens.remove();
        }
    }

    boolean validate() {
        return op == null || op.equals("+") || op.equals("-") || op.equals("=") || op.equals("<") || op.equals(">");
    }
}
