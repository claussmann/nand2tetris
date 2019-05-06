import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class VMTranslator {

    public static String filename;

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length == 0){
            System.out.printf("No input file given");
            System.exit(1);
        }
        String inputfile = args[0];
        filename = inputfile.substring(inputfile.lastIndexOf("."));
        List<String> file = null;
        try {
            file = FileInput.readAllLines(inputfile);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        Parser p = new Parser();
        p.parse(file, new PrintStream(new FileOutputStream(filename+".asm")));
    }
}
