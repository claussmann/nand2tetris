package Parser;

import Token.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SubroutineDeclaration {

    KeyWord methodType;
    DataType returnType;
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

        methodType = (KeyWord)tokens.remove();
        returnType = (DataType)tokens.remove();
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
            vars.add(new VarDeclaration(tokens));
        }
        statements = new Statements();
        while (isStatementBeginning(tokens.peek())){
            statements.add(getStatement(tokens));
        }
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
        return token.equals("let")
                ||token.equals("if")
                ||token.equals("while")
                ||token.equals("do")
                ||token.equals("return");
    }

    public void toXML(PrintStream printStream) {
        printStream.println("<subroutineDec>");
        printStream.println(methodType.toXML());
        printStream.println(returnType.toXML());
        printStream.println(routineName.toXML());
        printStream.println(openParam.toXML());
        printStream.println("<parameterList>");
        for(Parameter p : parameterList){
            p.toXML(printStream);
        }
        printStream.println("</parameterList>");
        printStream.println(closeParam.toXML());
        printStream.println("<subroutineBody>");
        printStream.println(open.toXML());
        for(VarDeclaration v : vars){
            v.toXML(printStream);
        }
        statements.toXML(printStream);
        printStream.println(close.toXML());
        printStream.println("</subroutineBody>");
        printStream.println("</subroutineDec>");
    }

    public boolean isValid() {
        return true;
    }
}
