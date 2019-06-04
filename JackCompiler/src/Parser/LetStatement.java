package Parser;

import Token.Identifier;
import Token.KeyWord;

public class LetStatement extends Statement {
    private final KeyWord let;
    private final Identifier variable;
    private final KeyWord equals;
    private final Expression expression;

    public LetStatement(KeyWord let, Identifier variable, KeyWord equals, Expression expression){

        this.let = let;
        this.variable = variable;
        this.equals = equals;
        this.expression = expression;

        if(!validate()){
            System.out.println("Incorrect Let Statement");
            System.exit(-1);
        }
    }

    boolean validate() {
        return let.getToken().equals("let")
                && equals.getToken().equals("=")
                && expression.validate();
    }
}
