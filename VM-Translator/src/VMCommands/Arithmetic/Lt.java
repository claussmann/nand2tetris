package VMCommands.Arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Lt extends ArithmeticCommand {
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

        asm.add("@lt"+x);
        asm.add("D=D;JLT");
        // sp>sp-1:
        asm.add("@SP");
        asm.add("A=A-1");
        asm.add("M=0");
        asm.add("@continueLt"+x);
        asm.add("JMP");

        //lt
        asm.add("(lt"+x+")");
        asm.add("@SP");
        asm.add("A=A-1");
        asm.add("M=-1");

        asm.add("(continueLt"+x+")");
        return asm;
    }
}
