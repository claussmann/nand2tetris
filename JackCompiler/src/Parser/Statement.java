package Parser;

import Token.Token;

import java.util.Queue;

public class Statement {
    boolean validate() {
        return true;
    }
    boolean isStatementBeginning(Token token){
        return token.getToken().equals("let")
                ||token.getToken().equals("if")
                ||token.getToken().equals("while")
                ||token.getToken().equals("do")
                ||token.getToken().equals("return");
    }

    Statement getStatement(Queue<Token> tokens) {
        switch (tokens.peek().getToken()){
            case "let":
                return new LetStatement(tokens);
            case "if":
                return new IfStatement(tokens);
            case "while":
                return new WhileStatement(tokens);
            case "do":
                return new DoStatement(tokens);
            case "return":
                return new ReturnStatement(tokens);
        }
        return null;
    }
}
