package VMCommands.ArithmeticCommands;

import java.util.ArrayList;
import java.util.List;

public class Add extends ArithmeticCommand{

    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        asm.add("@SP");
        asm.add("AM=M-1");
        asm.add("D=M");

        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=D+M");
        return asm;
    }
}
