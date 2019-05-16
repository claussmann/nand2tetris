package VMCommands.FunctionCommands;

import java.util.ArrayList;
import java.util.List;

public class Return extends FunctionCommand{
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();

        //save return value in R5
        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("D=M");
        asm.add("@R5");
        asm.add("M=D");


        //pop local vars
        asm.add("@LCL");
        asm.add("D=M");
        asm.add("@SP");
        asm.add("M=D");

        //reinstate the callers variables
        asm.addAll(popD());
        asm.add("@THAT");
        asm.add("M=D");

        asm.addAll(popD());
        asm.add("@THIS");
        asm.add("M=D");

        asm.addAll(popD());
        asm.add("@ARG");
        asm.add("M=D");

        asm.addAll(popD());
        asm.add("@LCL");
        asm.add("M=D");

        //save return-address to R6
        asm.addAll(popD());
        asm.add("@R6");
        asm.add("M=D");

        //push the return value to stack again
        asm.add("@R5");
        asm.add("D=M");
        asm.add("@SP");
        asm.add("A=M");
        asm.add("M=D");
        asm.add("@SP");
        asm.add("M=M+1");


        //return
        asm.add("@R6");
        asm.add("A=M");
        asm.add("0;JMP");

        return asm;
    }

    private List<String> popD() {
        List<String> asm = new ArrayList<>();

        asm.add("@SP");
        asm.add("A=M-1");
        asm.add("D=M");
        asm.add("@SP");
        asm.add("M=M-1");

        return asm;
    }
}
