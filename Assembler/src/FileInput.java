import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class FileInput {
    public Collection<String> readAllLines(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<String> lines = new ArrayList<>();

        String currentLine = reader.readLine();
        while (currentLine != null){
            lines.add(currentLine);
            currentLine = reader.readLine();
        }
        reader.close();

        return lines;
    }
}
