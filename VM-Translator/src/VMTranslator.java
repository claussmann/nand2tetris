import java.io.IOException;
import java.util.List;

public class VMTranslator {

    public static String filename;

    public static void main(String[] args){
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
    }
}
