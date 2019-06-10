package Parser;

import Token.*;

import java.io.PrintStream;
import java.util.Queue;

public class Parameter {

    DataType type;
    Identifier name;

    public Parameter(Queue<Token> tokens) {

        type  = (DataType)tokens.remove();
        name = (Identifier) tokens.remove();
        if(tokens.peek().getToken().equals(",")) tokens.remove();
    }

    public void toXML(PrintStream printStream) {
        printStream.println("<parameter>");
        printStream.println(type.toXML());
        printStream.println(name.toXML());
        printStream.println("</parameter>");
    }
}
