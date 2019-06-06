package Parser;

import Token.*;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Program {
    private Queue<Token> tokens;

    private KeyWord classKeyword;
    private Identifier className;
    private Symbol open;
    private Symbol close;
    private List<ClassVarDeclaration> classVars;
    private List<SubroutineDeclaration> routines;

    public Program(Queue<Token> tokens){

        this.tokens = tokens;
    }

    public void parse(){
        classKeyword = (KeyWord) tokens.remove();
        className = (Identifier) tokens.remove();
        open = (Symbol) tokens.remove();
        classVars = new ArrayList<>();
        while (! (tokens.peek().getToken().equals("constructor")
                ||tokens.peek().getToken().equals("function")
                ||tokens.peek().getToken().equals("method"))){
            classVars.add(new ClassVarDeclaration(tokens));
        }
        routines = new ArrayList<>();
        while (! tokens.peek().getToken().equals("}")){
            routines.add(new SubroutineDeclaration(tokens));
        }
        close = (Symbol) tokens.remove();
    }

    public void toXML(PrintStream printStream) {
        printStream.println("<class>");
        printStream.println(classKeyword.toXML());
        printStream.println(className.toXML());
        printStream.println(open.toXML());

        for(ClassVarDeclaration declaration:classVars) {
            declaration.toXML(printStream);
        }

        for(SubroutineDeclaration declaration : routines) {
            declaration.toXML(printStream);
        }

        printStream.println(close.toXML());
        printStream.println("</class>");
    }
}
