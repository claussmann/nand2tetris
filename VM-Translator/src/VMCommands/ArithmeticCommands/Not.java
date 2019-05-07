package VMCommands.ArithmeticCommands;

import java.util.ArrayList;
import java.util.List;

public class Not extends ArithmeticCommand {
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();

        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=!M");
        return asm;
    }
}
