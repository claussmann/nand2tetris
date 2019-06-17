package Parser;

import CodeGeneration.SymbolTable;
import Token.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class DoStatement extends Statement {
    KeyWord doKeyword;
    Symbol semicolon;
    List<Token> callstack;
    public DoStatement(Queue<Token> tokens) {
        callstack=new ArrayList<Token>();
        doKeyword = (KeyWord)tokens.remove();
        while(!tokens.peek().getToken().equals(";")){
            callstack.add(tokens.remove());
        }
        semicolon = (Symbol)tokens.remove();

    }

    @Override
    boolean isValid() {
        return doKeyword.equals("do") && semicolon.equals(";");
    }

    @Override
    public void toXML(PrintStream printStream) {
        printStream.println("<doStatement>");
        printStream.println(doKeyword.toXML());
        for (Token t:callstack) {
            printStream.println(t.toXML());
        }
        printStream.println(semicolon.toXML());
        printStream.println("</doStatement>");
    }

    @Override
    public void toVM(SymbolTable classSymbolTable, PrintStream stream) {

    }

}
