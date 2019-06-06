package Parser;

import Token.Token;

import java.io.PrintStream;
import java.util.Queue;

public class DoStatement extends Statement {
    public DoStatement(Queue<Token> tokens) {
        //TODO:
        tokens.remove();
        tokens.remove();
        tokens.remove();

    }

    @Override
    public void toXML(PrintStream printStream) {
        printStream.println("<doStatement>");
        printStream.println("</doStatement>");

    }
}
