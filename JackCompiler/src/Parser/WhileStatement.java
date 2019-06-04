package Parser;

import Token.KeyWord;
import Token.Symbol;

public class WhileStatement extends Statement {

    private final KeyWord keywordWhile;
    private final Symbol symbolOpen;
    private final Parser.Expression expression;
    private final Symbol symbolClose;
    private final Symbol bodyOpen;
    private final Parser.Statements statements;
    private final Symbol bodyClose;

    public WhileStatement(KeyWord keywordWhile, Symbol symbolOpen, Expression expression, Symbol symbolClose,
                          Symbol bodyOpen, Statements statements, Symbol bodyClose){

        this.keywordWhile = keywordWhile;
        this.symbolOpen = symbolOpen;
        this.expression = expression;
        this.symbolClose = symbolClose;
        this.bodyOpen = bodyOpen;
        this.statements = statements;
        this.bodyClose = bodyClose;

        if(!validate()){
            System.out.println("Incorrect While Statement");
            System.exit(-1);
        }
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

}
