package Parser;

import Token.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SubroutineDeclaration {

    Identifier methodType;
    KeyWord returnType;
    Identifier routineName;
    Symbol openParam;
    Symbol closeParam;
    List<Parameter> parameterList;
    Symbol open;
    Symbol close;
    List<VarDeclaration> vars;
    Statements statements;



    public SubroutineDeclaration(Queue<Token> tokens) {
        parse(tokens);
    }

    private void parse(Queue<Token> tokens) {

        methodType = (Identifier)tokens.remove();
        returnType = (KeyWord)tokens.remove();
        routineName = (Identifier)tokens.remove();
        openParam = (Symbol)tokens.remove();
        parameterList = new ArrayList<>();
        while (! tokens.peek().getToken().equals(")")){
            parameterList.add(new Parameter(tokens));
        }
        closeParam = (Symbol)tokens.remove();
        open = (Symbol)tokens.remove();
        vars = new ArrayList<>();
        while (! isStatementBeginning(tokens.peek())){
            parameterList.add(new Parameter(tokens));
        }
        statements = new Statements();
        while (isStatementBeginning(tokens.peek())){
            statements.add(getStatement(tokens));
        }
        System.out.println(tokens.peek().getToken());
        close = (Symbol)tokens.remove();
    }

    private Statement getStatement(Queue<Token> tokens) {
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

    private boolean isStatementBeginning(Token token){
        return token.getToken().equals("let")
                ||token.getToken().equals("if")
                ||token.getToken().equals("while")
                ||token.getToken().equals("do")
                ||token.getToken().equals("return");
    }
}
