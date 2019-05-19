package VMCommands.FunctionCommands;

import java.util.ArrayList;
import java.util.List;

public class Call extends FunctionCommand {
    static int i;
    private final String function;
    private final int argc;

    public Call(String function, int argc){
        this.function = function;
        this.argc = argc;
    }
    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();
        //make room for the return value
        asm.add("@SP");
        asm.add("M=M+1");

        //save return address on stack
        asm.add("@ret."+i);
        asm.add("D=A");
        asm.addAll(pushD());

        //save own variables
        asm.add("@LCL");
        asm.add("D=M");
        asm.addAll(pushD());

        asm.add("@ARG");
        asm.add("D=M");
        asm.addAll(pushD());

        asm.add("@THIS");
        asm.add("D=M");
        asm.addAll(pushD());

        asm.add("@THAT");
        asm.add("D=M");
        asm.addAll(pushD());

        //put the arg-pointer to the correct position
        int stackOffset = (6+argc);
        asm.add("@"+stackOffset);
        asm.add("D=A");
        asm.add("@SP");
        asm.add("D=M-D");
        asm.add("@ARG");
        asm.add("M=D");

        //LCL=SP
        asm.add("@SP");
        asm.add("D=M");
        asm.add("@LCL");
        asm.add("M=D");

        //jump to function
        asm.add("@"+function);
        asm.add("0;JMP");

        //return here:
        asm.add("(ret."+i+")");

        i++;
        return asm;
    }

    private List<String> pushD() {
        List<String> asm = new ArrayList<>();

        asm.add("@SP");
        asm.add("A=M");
        asm.add("M=D");
        asm.add("@SP");
        asm.add("M=M+1");

        return asm;
    }
}
