package VMCommands.MemoryCommands;

import VMCommands.MemSegment;

import java.util.ArrayList;
import java.util.List;

public class Pop extends MemoryCommand {
    private List<String> asm;
    public Pop(MemSegment segment, int i, String objectname) {
        super(segment, i, objectname);
    }

    @Override
    public List<String> toASMCommands() {
        asm = new ArrayList<>();
        //SP--; R13=*SP
        asm.add("@SP");
        asm.add("M=M-1");
        asm.add("@SP");
        asm.add("A=M");
        asm.add("D=M");
        asm.add("@R13");
        asm.add("M=D");

        storeR13ToRAM();

        return asm;
    }

    //Stores Content of R13 to the desired RAM position
    private void storeR13ToRAM() {
        int addr;
        switch (super.segment){
            case _temp:
                addr = super.i + 5;
                asm.add("@R13");
                asm.add("D=M");
                asm.add("@"+addr);
                asm.add("M=D");
                break;
            case _pointer:
                addr = super.i + 3;
                asm.add("@R13");
                asm.add("D=M");
                asm.add("@"+addr);
                asm.add("M=D");
                break;
            case _static:
                asm.add("@R13");
                asm.add("D=M");
                asm.add("@" + super.objectname + "." + super.i);
                asm.add("M=D");
                break;
            case _constant:
                asm.add("@R13");
                asm.add("D=M");
                asm.add("@"+super.i);
                asm.add("A=D");
                break;
            case _that:
                asm.add("@"+super.i);
                asm.add("D=A");
                asm.add("@THAT");
                asm.add("D=M+D");
                asm.add("@R14");
                asm.add("M=D");
                asm.add("@R13");
                asm.add("D=M");
                asm.add("@R14");
                asm.add("A=M");
                asm.add("M=D");
                break;
            case _this:
                asm.add("@"+super.i);
                asm.add("D=A");
                asm.add("@THIS");
                asm.add("D=M+D");
                asm.add("@R14");
                asm.add("M=D");
                asm.add("@R13");
                asm.add("D=M");
                asm.add("@R14");
                asm.add("A=M");
                asm.add("M=D");
                break;
            case _local:
                asm.add("@"+super.i);
                asm.add("D=A");
                asm.add("@LCL");
                asm.add("D=M+D");
                asm.add("@R14");
                asm.add("M=D");
                asm.add("@R13");
                asm.add("D=M");
                asm.add("@R14");
                asm.add("A=M");
                asm.add("M=D");
                break;
            case _argument:
                asm.add("@"+super.i);
                asm.add("D=A");
                asm.add("@ARG");
                asm.add("D=M+D");
                asm.add("@R14");
                asm.add("M=D");
                asm.add("@R13");
                asm.add("D=M");
                asm.add("@R14");
                asm.add("A=M");
                asm.add("M=D");
                break;
        }
    }
}
