package Parser;

import Token.*;

import java.util.Queue;

public class ClassVarDeclaration {

    KeyWord fieldType;
    KeyWord fieldDataType;
    Identifier varName;
    Symbol semicolon;


    public ClassVarDeclaration(Queue<Token> tokens) {
        parse(tokens);
    }

    private void parse(Queue<Token> tokens) {
        fieldType = (KeyWord)tokens.remove();
        fieldDataType = (KeyWord)tokens.remove();
        varName = (Identifier)tokens.remove();
        semicolon = (Symbol)tokens.remove();
    }
}
