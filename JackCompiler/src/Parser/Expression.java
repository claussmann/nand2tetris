package Parser;

import CodeGeneration.SymbolTable;
import Token.Symbol;
import Token.Token;

import java.io.PrintStream;
import java.util.Queue;

public class Expression {

    private Term term;
    private Symbol op;
    private Term term2;

    public Expression(Queue<Token> tokens) {
        term = new Term(tokens);
        String tmp = tokens.peek().getToken();
        if (tmp.equals("+") || tmp.equals("-") || tmp.equals("=") || tmp.equals("<") || tmp.equals(">")) {
            op = (Symbol) tokens.remove();
            term2 = new Term(tokens);
        }
    }

    boolean validate() {
        return op == null || op.equals("+") || op.equals("-") || op.equals("=") || op.equals("<") || op.equals(">");
    }

    public void toXML(PrintStream printStream) {
        printStream.println("<expression>");
        term.toXML(printStream);
        if (op != null) {
            printStream.println(op.toXML());
            term.toXML(printStream);
        }
        printStream.println("</expression>");
    }

    public void toVM(SymbolTable classSymbolTable, PrintStream stream) {
        term.toVM(classSymbolTable, stream);
        if (term2 != null) {
            term2.toVM(classSymbolTable, stream);
        }
        if (op != null) {
            switch (op.toString()) {
                case "+":
                    stream.println("add");
                    break;
                case "=":
                    stream.println("eq");
                    break;
                case "-":
                    stream.println("sub");
                    break;
                case ">":
                    stream.println("gt");
                    break;
                case "<":
                    stream.println("lt");
                    break;
            }
        }
    }
}
