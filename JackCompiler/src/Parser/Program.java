package Parser;

import Token.*;

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
        while (! tokens.peek().getToken().equals("constructor")){
            classVars.add(new ClassVarDeclaration(tokens));
        }
        routines = new ArrayList<>();
        while (! tokens.peek().getToken().equals("}")){
            routines.add(new SubroutineDeclaration(tokens));
        }
        close = (Symbol) tokens.remove();
    }
}
