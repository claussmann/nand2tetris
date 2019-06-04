package Parser;

import Token.Symbol;

public class Expression {

    private final Parser.Term term;
    private Symbol op;
    private Parser.Term term2;

    public Expression(Term term){

        this.term = term;
    }

    public Expression(Term term, Symbol op, Term term2){

        this.term = term;
        this.op = op;
        this.term2 = term2;
    }
}
