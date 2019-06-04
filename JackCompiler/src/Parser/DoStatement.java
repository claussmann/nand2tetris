package Parser;

import Token.Token;

import java.util.Queue;

public class DoStatement extends Statement {
    public DoStatement(Queue<Token> tokens) {
        //TODO:
        tokens.remove();
        tokens.remove();
        tokens.remove();

    }
}
