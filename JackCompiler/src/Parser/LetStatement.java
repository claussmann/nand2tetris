package Parser;

import CodeGeneration.SymbolTable;
import Token.*;

import java.io.PrintStream;
import java.util.Queue;

public class LetStatement extends Statement {
    private final KeyWord let;
    private final Identifier variable;
    private final Symbol equals;
    private final Expression expression;
    private final Symbol semicolon;


    public LetStatement(Queue<Token> tokens) {
        let = (KeyWord)tokens.remove();
        variable = (Identifier) tokens.remove();
        equals = (Symbol) tokens.remove();
        expression = new Expression(tokens);
        semicolon = (Symbol)tokens.remove();
    }

    boolean isValid() {
        return let.getToken().equals("let")
                && equals.equals("=")
                && expression.validate()
                && semicolon.equals(";");
    }

    @Override
    public void toXML(PrintStream printStream) {
        printStream.println("<letStatement>");
        printStream.println(let.toXML());
        printStream.println(variable.toXML());
        printStream.println(equals.toXML());
        expression.toXML(printStream);
        printStream.println(semicolon.toXML());
        printStream.println("</letStatement>");
    }

    @Override
    public void toVM(SymbolTable classSymbolTable, PrintStream stream) {

    }

}
