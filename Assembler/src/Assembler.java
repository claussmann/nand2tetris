import java.io.IOException;
import java.util.Collection;

public class Assembler {

    private static String inputfile;
    private static String outputfile;

    public static void main(String[] args){
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

    }
}
