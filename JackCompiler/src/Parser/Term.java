package Parser;

import CodeGeneration.SymbolTable;
import Token.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Term {

    Symbol invert;
    Token single;
    Expression inner;
    Token innerOpen;
    Token innerClose;
    Identifier call;
    List<Token> callstack;

    public Term(Queue<Token> tokens) {
        callstack = new ArrayList<>();
        Token t = tokens.remove();
        if (t.getToken().equals("~")) {
            invert = (Symbol) t;
            t = tokens.remove();
        }
        if (t.getToken().equals("(")) {
            innerOpen = t;
            inner = new Expression(tokens);
            innerClose = tokens.remove();
        }
        if (t.getClass().equals(StringConstant.class) || t.getClass().equals(IntegerConstant.class)) {
            single = t;
        } else {
            if (isTermEnd(tokens.peek().getToken()) || tokens.peek().getToken().equals(")")) {
                single = t;
            } else {
                call = (Identifier) t;
                while (!isTermEnd(tokens.peek().getToken())) {
                    callstack.add(tokens.remove());
                }
            }
        }
    }

    void toXML(PrintStream printStream) {
        printStream.println("<term>");
        if (invert != null) {
            printStream.println(invert.toXML());
        }
        if (single != null) {
            printStream.println(single.toXML());
        } else if (innerOpen != null) {
            printStream.println(innerOpen);
            inner.toXML(printStream);
            printStream.println(innerClose);
        } else {
            printStream.println(call.toXML());
            for (Token t : callstack) {
                printStream.println(t.toXML());
            }
        }
        printStream.println("</term>");
    }

    private boolean isTermEnd(String s) {
        return s.equals(";")
                || s.equals("+")
                || s.equals("<")
                || s.equals("-")
                || s.equals(">")
                || s.equals("=");
    }

    public void toVM(SymbolTable classSymbolTable, PrintStream stream) {
        if (single != null) {
            if(single.getClass().equals(Identifier.class)){
                stream.println("push " +classSymbolTable.getLocation(single.toString()));
            }
            else if(single.getClass().equals(StringConstant.class)){
                stream.println("push constant "+single.toString());
            }
            else if(single.getClass().equals(IntegerConstant.class)){
                stream.println("push constant "+single.toString());
            }
        } else {
            stream.println("<Term comes here>");
        }
        if (invert != null) {
            stream.println("not");
        }
    }
}
