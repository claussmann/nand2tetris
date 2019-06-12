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
        while (! (tokens.peek().equals("constructor")
                ||tokens.peek().equals("function")
                ||tokens.peek().equals("method"))){
            classVars.add(new ClassVarDeclaration(tokens));
        }
        routines = new ArrayList<>();
        while (! tokens.peek().equals("}")){
            routines.add(new SubroutineDeclaration(tokens));
        }
        close = (Symbol) tokens.remove();
    }

    public boolean isValid(){
        System.out.println("Checking class "+className);
        if (!classKeyword.equals("class")){
            System.err.println("Expected keyword 'class' but was "+classKeyword);
            return false;
        }
        if (!open.equals("{")){
            System.err.println("Expected '{' but was "+open);
            return false;
        }
        if (!close.equals("}")){
            System.err.println("Expected '}' but was "+close);
            return false;
        }
        for(ClassVarDeclaration declaration: classVars){
            if(!declaration.isValid()) return false;
        }
        for(SubroutineDeclaration declaration: routines){
            if(!declaration.isValid()) return false;
        }
        System.out.println("\nCheck Successful!\n");
        return true;
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
