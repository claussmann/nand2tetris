package Parser;

import Token.KeyWord;
import Token.Symbol;

public class IfStatement extends Statement {

    private final KeyWord keywordIf;
    private final Symbol symbolOpen;
    private final Parser.Expression expression;
    private final Symbol symbolClose;
    private final Symbol bodyOpen;
    private final Parser.Statements statements;
    private final Symbol bodyClose;

    public IfStatement(KeyWord keywordIf, Symbol symbolOpen, Expression expression, Symbol symbolClose,
                          Symbol bodyOpen, Statements statements, Symbol bodyClose){

        this.keywordIf = keywordIf;
        this.symbolOpen = symbolOpen;
        this.expression = expression;
        this.symbolClose = symbolClose;
        this.bodyOpen = bodyOpen;
        this.statements = statements;
        this.bodyClose = bodyClose;
    }
}
