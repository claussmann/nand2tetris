package Parser;

import Token.KeyWord;
import Token.Symbol;
import Token.Token;

import java.io.PrintStream;
import java.util.Queue;

public class ElseStatement extends Statement{
    private KeyWord elseKeyword;
    private Symbol bodyOpen;
    private Parser.Statements statements;
    private Symbol bodyClose;

    public ElseStatement(Queue<Token> tokens){

        elseKeyword = (KeyWord)tokens.remove();
        bodyOpen = (Symbol)tokens.remove();
        statements = new Statements();
        while (isStatementBeginning(tokens.peek())){
            toStatement(tokens);
        }
        bodyClose = (Symbol)tokens.remove();
    }


    boolean isValid() {
        return elseKeyword.equals("else")
                && bodyOpen.equals("{")
                && bodyClose.equals("}")
                && statements.validate();
    }

    @Override
    public void toXML(PrintStream printStream) {
        printStream.println("<elseStatement>");
        printStream.println(elseKeyword.toXML());
        printStream.println(bodyOpen.toXML());
        statements.toXML(printStream);
        printStream.println(bodyClose.toXML());
        printStream.println("</elseStatement>");
    }
}
