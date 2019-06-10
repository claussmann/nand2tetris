package Parser;

import Token.*;

import java.io.PrintStream;
import java.util.Queue;

public class VarDeclaration {

    KeyWord varKeyword;
    DataType type;
    Identifier name;
    Symbol semicolon;

    public VarDeclaration(Queue<Token> tokens) {
        varKeyword = (KeyWord) tokens.remove();
        type = (DataType) tokens.remove();
        name = (Identifier) tokens.remove();
        semicolon = (Symbol) tokens.remove();
    }


    public void toXML(PrintStream printStream) {
        printStream.println("<varDec>");
        printStream.println(varKeyword.toXML());
        printStream.println(type.toXML());
        printStream.println(name.toXML());
        printStream.println(semicolon.toXML());
        printStream.println("</varDec>");
    }
}
