import Instructions.AInstruction;
import Instructions.CInstruction;
import Instructions.Instruction;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Assembler {

    private static String inputfile;
    private static String outputfile;

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length == 0){
            System.out.printf("No input file given");
            System.exit(1);
        }
        inputfile = args[0];
        Collection<String> file = null;
        try {
            file = FileInput.readAllLines(inputfile);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Program program = new Program();
        program.assemble(file);
        program.toBinary(new PrintStream(new FileOutputStream(inputfile+".hack")));
    }
}
