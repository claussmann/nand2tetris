package VMCommands.ArithmeticCommands;

import java.util.ArrayList;
import java.util.List;

public class Add extends ArithmeticCommand{

    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        asm.add("@SP");
        asm.add("M=M-1");
        asm.add("A=M");
        asm.add("D=M");
        //Now D = number at SP-1
        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=D+M");
        //Now Var at SP-2 = (number at SP-1) + (number at SP-2)
        //SP=SP-1
        return asm;
    }
}
