package VMCommands;

import java.util.ArrayList;
import java.util.List;

public class BootstrapCommand extends Command {
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();

        //SP=261
        asm.add("@261");
        asm.add("D=A");
        asm.add("@SP");
        asm.add("M=D");

        //call sys.init
        asm.add("@Sys.init");
        asm.add("0;JMP");
        return asm;
    }
}
