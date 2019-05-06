package VMCommands.Arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Not extends ArithmeticCommand {
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();

        asm.add("@SP");
        asm.add("A=M-1");

        asm.add("@not"+x);
        asm.add("D=M;JEQ");
        // sp-1 == -1 ==> set sp-1 to false
        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=0");
        asm.add("@continueNot"+x);
        asm.add("JMP");

        //sp-1 = false
        asm.add("(not"+x+")");
        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("M=-1");

        asm.add("(continueNot"+x+")");
        return asm;
    }
}
