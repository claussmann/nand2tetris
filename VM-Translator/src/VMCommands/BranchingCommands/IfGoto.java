package VMCommands.BranchingCommands;


import java.util.ArrayList;
import java.util.List;

public class IfGoto extends BranchingCommand {
    public IfGoto(String labelname) {
        super(labelname);
    }

    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();

        asm.add("@SP");
        asm.add("M=M-1");
        asm.add("@SP");
        asm.add("A=M");
        asm.add("D=M;JLT");

        return asm;
    }
}
