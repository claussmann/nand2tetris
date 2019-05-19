import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class VMTranslator {

    public static void main(String[] args) throws FileNotFoundException {
        if(args.length == 0){
            System.out.printf("No input files given");
            System.out.printf("Usage: java VMTranslator <inputfile1> <inputfile2> <...>");
            System.exit(1);
        }

        Parser p = new Parser();

        for(int i=0; i<args.length; i++) {
            String inputfile = args[i];
            String classname = inputfile.substring(0, inputfile.lastIndexOf("."));
            List<String> file = null;
            try {
                file = FileInput.readAllLines(inputfile);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
            p.parse(file, classname);
        }
        p.write(new PrintStream(new FileOutputStream("out.asm")));
    }
}
