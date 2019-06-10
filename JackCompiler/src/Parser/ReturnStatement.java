package Parser;

import Token.*;

import java.io.PrintStream;
import java.util.Queue;

public class ReturnStatement extends Statement {
    KeyWord retKeyword;
    Expression expression;
    Symbol semicolon;
    public ReturnStatement(Queue<Token> tokens) {
        retKeyword = (KeyWord) tokens.remove();
        if(!tokens.peek().getToken().equals(";")) {
            expression = new Expression(tokens);
        }
        semicolon = (Symbol)tokens.remove();
    }

    @Override
    public void toXML(PrintStream printStream) {
        printStream.println("<returnStatement>");
        printStream.println(retKeyword.toXML());
        if(expression!=null)expression.toXML(printStream);
        printStream.println(semicolon.toXML());
        printStream.println("</returnStatement>");
    }
}
