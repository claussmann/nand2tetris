package Parser;

import Token.KeyWord;
import Token.Symbol;
import Token.Token;

import java.io.PrintStream;
import java.util.Queue;

public class IfStatement extends Statement {

    private KeyWord keywordIf;
    private Symbol symbolOpen;
    private Parser.Expression expression;
    private Symbol symbolClose;
    private Symbol bodyOpen;
    private Parser.Statements statements;
    private Symbol bodyClose;

    public IfStatement(Queue<Token> tokens){

        keywordIf = (KeyWord)tokens.remove();
        symbolOpen = (Symbol)tokens.remove();
        expression = new Expression(tokens);
        symbolClose = (Symbol)tokens.remove();
        bodyOpen = (Symbol)tokens.remove();
        statements = new Statements();
        while (isStatementBeginning(tokens.peek())){
            toStatement(tokens);
        }
        bodyClose = (Symbol)tokens.remove();
    }


    boolean isValid() {
        return keywordIf.equals("if")
                && symbolOpen.equals("(")
                && symbolClose.equals(")")
                && expression.validate()
                && bodyOpen.equals("{")
                && bodyClose.equals("}")
                && statements.validate();
    }

    @Override
    public void toXML(PrintStream printStream) {
        printStream.println("<ifStatement>");
        printStream.println(keywordIf.toXML());
        printStream.println(symbolOpen.toXML());
        expression.toXML(printStream);
        printStream.println(symbolClose.toXML());
        printStream.println(bodyOpen.toXML());
        statements.toXML(printStream);
        printStream.println(bodyClose.toXML());
        printStream.println("</ifStatement>");
    }
}
