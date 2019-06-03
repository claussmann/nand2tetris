import java.io.IOException;
import java.util.ArrayList;


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


    }
}
