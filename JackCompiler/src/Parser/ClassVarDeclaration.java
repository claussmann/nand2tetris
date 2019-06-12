package Parser;

import Token.*;

import java.io.PrintStream;
import java.util.Queue;

public class ClassVarDeclaration {

    KeyWord fieldType;
    DataType fieldDataType;
    Identifier varName;
    Symbol semicolon;


    public ClassVarDeclaration(Queue<Token> tokens) {
        parse(tokens);
    }

    private void parse(Queue<Token> tokens) {
        fieldType = (KeyWord)tokens.remove();
        fieldDataType = (DataType)tokens.remove();
        varName = (Identifier)tokens.remove();
        semicolon = (Symbol)tokens.remove();
    }

    public void toXML(PrintStream printStream) {
        printStream.println("<classVarDec>");
        printStream.println(fieldType.toXML());
        printStream.println(fieldDataType.toXML());
        printStream.println(varName.toXML());
        printStream.println(semicolon.toXML());
        printStream.println("</classVarDec>");
    }

    public boolean isValid() {
        System.out.println("Checking ClassVarDeclaration "+varName);
        return true;
    }
}
