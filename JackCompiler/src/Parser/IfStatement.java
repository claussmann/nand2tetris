package Parser;

import Token.KeyWord;
import Token.Symbol;
import Token.Token;

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
            getStatement(tokens);
        }
        bodyClose = (Symbol)tokens.remove();
    }


    boolean validate() {
        return keywordIf.getToken().equals("if")
                && symbolOpen.getToken().equals("(")
                && symbolClose.getToken().equals(")")
                && expression.validate()
                && bodyOpen.getToken().equals("{")
                && bodyClose.getToken().equals("}")
                && statements.validate();
    }
}
