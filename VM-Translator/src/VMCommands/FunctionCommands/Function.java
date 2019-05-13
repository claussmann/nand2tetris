package VMCommands.FunctionCommands;

import java.util.ArrayList;
import java.util.List;

public class Function extends FunctionCommand {
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        //save return address on stack
        asm.add("");
        asm.add("");
        return asm;
    }
}
