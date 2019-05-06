package VMCommands.Arithmetic;

import java.util.ArrayList;
import java.util.List;

public class Eq extends ArithmeticCommand {
    static int x=0;

    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        asm.add("@SP");
        asm.add("M=M-1");
        asm.add("A=M");
        asm.add("D=M");

        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("D=D-M");
        //Now if D=0 ==> Equal

        asm.add("@eq"+x);
        asm.add("D=D;JEQ");
        //not equal:
        asm.add("@SP");
        asm.add("A=A-1");
        asm.add("M=0");
        asm.add("@continueEq"+x);
        asm.add("JMP");

        //equal
        asm.add("(eq"+x+")");
        asm.add("@SP");
        asm.add("A=A-1");
        asm.add("M=-1");

        asm.add("(continueEq"+x+")");
        return asm;
    }
}
