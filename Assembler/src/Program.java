import Instructions.AInstruction;
import Instructions.CInstruction;
import Instructions.Instruction;
import Instructions.Label;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Program {

    private Collection<Instruction> instructions;
    private ArrayList<Label> labels;
    private int nextLabelAddress = 16;

    public Program(){
        labels = new ArrayList<>();
        instructions= new ArrayList<>();
    }

    public void assemble(Collection<String> file) {
        for(String line:file){

            line = removeComments(line);
            line = line.replace(" ", "");
            if(line.equals("")) continue;

            if(line.startsWith("@")){
                instructions.add(parseAsAInstruction(line));
            }
            else {
                instructions.add(parseAsCInstruction(line));
            }
        }
    }

    private String removeComments(String line) {
        if(line.contains("//")){
            line = line.substring(0, line.indexOf("//"));
        }
        return line;
    }

    private CInstruction parseAsCInstruction(String cmd) {
        return new CInstruction(cmd);
    }

    private AInstruction parseAsAInstruction(String cmd){
        String aInstruction = cmd.replace("@", "");
        int value;
        try{
            value = Integer.parseInt(aInstruction);
        }catch (Exception e){
            value = resolveLabel(aInstruction);
        }
        return new AInstruction(value);
    }

    private int resolveLabel(String aInstruction) {
        Label label = new Label(aInstruction, nextLabelAddress);
        if(labels.contains(label)){
            Label found = labels.get(labels.indexOf(label));
            return found.getAddress();
        }
        nextLabelAddress++;
        labels.add(label);
        return label.getAddress();
    }

    public void toBinary(PrintStream out) {
        for(Instruction instruction : instructions){
            out.println(instruction.toBinary());
        }
    }
}
