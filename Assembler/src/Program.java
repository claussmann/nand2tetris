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

        labels.add(new Label("SP",0));
        labels.add(new Label("LCL",1));
        labels.add(new Label("ARG",2));
        labels.add(new Label("THIS",3));
        labels.add(new Label("THAT",4));
        labels.add(new Label("SCREEN",16384));
        labels.add(new Label("KBD",24576));
        for(int i=0; i<16; i++){
            //R0-R15
            labels.add(new Label("R"+i,i));
        }
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
        try{
            return new AInstruction(Integer.parseInt(aInstruction));
        }catch (Exception e){
            return new AInstruction(resolveLabel(aInstruction));
        }
    }

    private Label resolveLabel(String aInstruction) {
        Label label = new Label(aInstruction, nextLabelAddress);
        if(labels.contains(label)){
            Label found = labels.get(labels.indexOf(label));
            return found;
        }
        nextLabelAddress++;
        labels.add(label);
        return label;
    }

    public void toBinary(PrintStream out) {
        for(Instruction instruction : instructions){
            out.println(instruction.toBinary());
        }
    }
}
