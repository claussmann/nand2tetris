package VMCommands.BranchingCommands;

import java.util.ArrayList;
import java.util.List;

public class Goto extends BranchingCommand {
    public Goto(String labelname) {
        super(labelname);
    }

    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        asm.add("@"+super.labelname+"");
        asm.add("0;JMP");
        return asm;
    }
}
