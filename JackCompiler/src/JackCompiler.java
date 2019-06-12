import Token.Token;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Queue;
import Parser.*;


public class JackCompiler {

    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.printf("No input files given");
            System.out.printf("Usage: java JackCompiler <inputfile1> <inputfile2> <...>");
            System.exit(1);
        }

        ArrayList<String> allLines = new ArrayList<>();

        for(String file : args){
            allLines.addAll(FileInput.readAllLines(file));
        }

        Tokenizer tokenizer=new Tokenizer();
        Queue<Token> tokens = tokenizer.tokenize(allLines);

        PrintStream printStream = new PrintStream(new FileOutputStream(args[0] + "T.xml"));
        System.out.println("Printing Tokens to "+args[0]+"T.xml\n\n");
        for (Token token:tokens){
            printStream.println(token.toXML());
        }

        Program program = new Program(tokens);
        try{
            program.parse();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println("Failed to parse in region:");
            for(int i=0; i<10;i++){
                System.out.print(tokens.remove().toXML());
            }
            System.exit(-1);
        }

        if(program.isValid()) {
            System.out.println("Writing to "+args[0]+".xml");
            PrintStream printStream2 = new PrintStream(new FileOutputStream(args[0] + ".xml"));
            program.toXML(printStream2);
        }
    }
}
