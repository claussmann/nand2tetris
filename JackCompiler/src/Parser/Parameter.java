package Parser;

import Token.*;

import java.io.PrintStream;
import java.util.Queue;

public class Parameter {

    DataType type;
    Identifier name;
    Token comma;

    public Parameter(Queue<Token> tokens) {

        type  = (DataType)tokens.remove();
        name = (Identifier) tokens.remove();
        if(tokens.peek().getToken().equals(",")) comma = tokens.remove();
    }

    public void toXML(PrintStream printStream) {
        printStream.println(type.toXML());
        printStream.println(name.toXML());
        if(comma!=null) printStream.println(comma.toXML());
    }

    public boolean isValid() {
        System.out.println("....checking Parameter "+name);
        if(type.getClass().equals(KeyWord.class)){
            if(!(type.equals("int") || type.equals("char") || type.equals("boolean"))){
                System.err.println("Unvalid datatype: "+type);
                return false;
            }
        }
        return true;
    }

    public String getDatatype(){
        return type.toString();
    }

    public String getName(){
        return name.toString();
    }
}
