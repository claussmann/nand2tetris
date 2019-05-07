package VMCommands.ArithmeticCommands;

import java.util.ArrayList;
import java.util.List;

public class Gt extends ArithmeticCommand {
    static int x;
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        asm.add("@SP");
        asm.add("M=M-1");
        asm.add("A=M");
        asm.add("D=M");

        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("D=M-D");

        asm.add("@Gt"+x);
        asm.add("D=D;JGT");
        // sp<sp-1:
        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=0");
        asm.add("@continueGt"+x);
        asm.add("JMP");

        //Gt
        asm.add("(Gt"+x+")");
        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=-1");

        asm.add("(continueGt"+x+")");
        x++;
        return asm;
    }
}
