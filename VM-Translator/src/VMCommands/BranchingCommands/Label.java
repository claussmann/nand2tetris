package VMCommands.BranchingCommands;

import java.util.ArrayList;
import java.util.List;

public class Label extends BranchingCommand {
    public Label(String labelname) {
        super(labelname);
    }

    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        asm.add("("+super.labelname+")");
        return asm;
    }
}
