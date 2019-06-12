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
        while (!tokens.peek().equals(";")){
            tokens.remove();
            //TODO: additional variables in same declaration need to be parsed here...
        }
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

    public boolean isValid() {
        System.out.println("....checking variable declaration "+name);
        if(!varKeyword.equals("var")){
            System.err.println("Expected Keyword 'var' but was "+varKeyword);
            return false;
        }
        if(type.getClass().equals(KeyWord.class)){
            if(!(type.equals("int") || type.equals("char") || type.equals("boolean"))){
                System.err.println("Unvalid datatype: "+type);
                return false;
            }
        }
        if(!semicolon.equals(";")){
            System.err.println("Expected ';' but was "+semicolon);
            return false;
        }
        return true;
    }
}
