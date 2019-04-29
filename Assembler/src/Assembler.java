import Instructions.AInstruction;
import Instructions.CInstruction;
import Instructions.Instruction;

import java.io.IOException;
import java.util.ArrayList;
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

        Collection<Instruction> instructions = assemble(file);
        for (Instruction instruction : instructions) {
            System.out.println(instruction.toBinary());
        }
    }

    private static Collection<Instruction> assemble(Collection<String> file) {
        ArrayList<Instruction> instructions = new ArrayList<>();

        for(String line:file){
            if(line.startsWith("@")){
                String aInstruction = line.replace("@", "");
                int value;
                try{
                    value = Integer.parseInt(aInstruction);
                }catch (Exception e){
                    value = resolveLabel(aInstruction);
                }
                instructions.add(new AInstruction(value));
            }
            else {
                instructions.add(new CInstruction(line));
            }
        }

        return instructions;
    }

    private static int resolveLabel(String label){
        return 16;
    }
}
