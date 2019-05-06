package VMCommands.Arithmetic;

import java.util.ArrayList;
import java.util.List;

public class neg extends ArithmeticCommand {
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();

        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=0-M");
        return asm;
    }
}
