import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class VMTranslator {

    public static String filename;

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length == 0){
            System.out.printf("No input files given");
            System.exit(1);
        }

        Parser p = new Parser();

        for(int i=0; i<args.length; i++) {
            String inputfile = args[i];

            filename = inputfile.substring(0, inputfile.lastIndexOf("."));
            List<String> file = null;
            try {
                file = FileInput.readAllLines(inputfile);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
            p.parse(file);
        }
        p.write(new PrintStream(new FileOutputStream("out.asm")));
    }
}
