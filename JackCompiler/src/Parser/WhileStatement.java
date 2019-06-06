package Parser;

import Token.KeyWord;
import Token.Symbol;
import Token.Token;

import java.io.PrintStream;
import java.util.Queue;

public class WhileStatement extends Statement {

    private final KeyWord keywordWhile;
    private final Symbol symbolOpen;
    private final Expression expression;
    private final Symbol symbolClose;
    private final Symbol bodyOpen;
    private final Statements statements;
    private final Symbol bodyClose;


    public WhileStatement(Queue<Token> tokens) {

        keywordWhile = (KeyWord)tokens.remove();
        symbolOpen = (Symbol)tokens.remove();
        expression = new Expression(tokens);
        symbolClose = (Symbol)tokens.remove();
        bodyOpen = (Symbol)tokens.remove();
        statements = new Statements();
        while (isStatementBeginning(tokens.peek())){
            getStatement(tokens);
        }
        bodyClose = (Symbol)tokens.remove();
    }


    boolean validate() {
        return keywordWhile.getToken().equals("if")
                && symbolOpen.getToken().equals("(")
                && symbolClose.getToken().equals(")")
                && expression.validate()
                && bodyOpen.getToken().equals("{")
                && bodyClose.getToken().equals("}")
                && statements.validate();
    }

    @Override
    public void toXML(PrintStream printStream) {
        printStream.println("<whileStatement>");
        printStream.println(keywordWhile.toXML());
        printStream.println(symbolOpen.toXML());
        expression.toXML(printStream);
        printStream.println(symbolClose.toXML());
        printStream.println(bodyOpen.toXML());
        statements.toXML(printStream);
        printStream.println(bodyClose.toXML());
        printStream.println("</whileStatement>");
    }


}
