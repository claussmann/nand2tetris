import Instructions.AInstruction;
import Instructions.CInstruction;
import Instructions.Instruction;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Program {

    private Collection<Instruction> instructions;

    public void assemble(Collection<String> file) {
        instructions = new ArrayList<>();

        for(String line:file){

            if(line.startsWith("@")){
                instructions.add(parseAsAInstruction(line));
            }
            else {
                instructions.add(parseAsCInstruction(line));
            }
        }
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
        return 16;
    }

    public void toBinary(PrintStream out) {
        for(Instruction instruction : instructions){
            out.println(instruction.toBinary());
        }
    }
}
