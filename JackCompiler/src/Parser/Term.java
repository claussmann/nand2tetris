package Parser;

import Token.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Term {

    Token single;
    Identifier call;
    List<Token> callstack;

    public Term(Queue<Token> tokens){
        callstack = new ArrayList<>();
        Token t = tokens.remove();
        if(t.getClass().equals(StringConstant.class)
                || t.getClass().equals(IntegerConstant.class)){
            single=t;
        }
        else {
            if(isTermEnd(tokens.peek().getToken())){
                single=t;
            }
            else {
                call=(Identifier)t;
                while (!isTermEnd(tokens.peek().getToken())){
                    callstack.add(tokens.remove());
                }
            }
        }
    }

    void toXML(PrintStream printStream){
        printStream.println("<term>");
        if(single!=null){
            printStream.println(single.toXML());
        }
        else {
            printStream.println(call.toXML());
            for (Token t : callstack){
                printStream.println(t.toXML());
            }
        }
        printStream.println("</term>");
    }

    private boolean isTermEnd(String s){
        return s.equals(";") || s.equals("+") || s.equals("<") || s.equals("-") || s.equals(">") || s.equals("=");
    }
}
