package Parser;

import Token.Token;

import java.io.PrintStream;
import java.util.Queue;

public class ReturnStatement extends Statement {
    public ReturnStatement(Queue<Token> tokens) {
        //TODO:
        tokens.remove();
        tokens.remove();
        tokens.remove();
    }

    @Override
    public void toXML(PrintStream printStream) {
        printStream.println("<returnStatement>");
        printStream.println("</returnStatement>");
    }
}
