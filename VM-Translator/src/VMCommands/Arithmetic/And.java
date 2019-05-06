package VMCommands.Arithmetic;

import java.util.ArrayList;
import java.util.List;

public class And extends ArithmeticCommand {
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        asm.add("@SP");
        asm.add("M=M-1");
        asm.add("A=M");
        asm.add("D=M");

        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=M&D");

        return asm;
    }
}
