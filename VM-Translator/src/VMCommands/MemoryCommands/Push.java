package VMCommands.MemoryCommands;

import VMCommands.MemSegment;

import java.util.ArrayList;
import java.util.List;

public class Push extends MemoryCommand {
    private List<String> asm;
    public Push(MemSegment segment, int i, String objectname) {
        super(segment, i, objectname);
    }

    @Override
    public List<String> toASMCommands() {
        asm = new ArrayList<>();
        loadVarToD();

        //save D at SP, Inc SP
        asm.add("@SP");
        asm.add("A=M");
        asm.add("M=D");
        asm.add("@SP");
        asm.add("M=M+1");
        return asm;
    }

    //Loads the correct 'value to be pushed on stack' into D-Register
    private void loadVarToD() {
        int addr;
        switch (super.segment){
            case _temp:
                addr = super.i + 5;
                asm.add("@"+addr);
                asm.add("D=M");
                break;
            case _pointer:
                addr = super.i + 3;
                asm.add("@"+addr);
                asm.add("D=M");
                break;
            case _static:
                asm.add("@" + super.objectname + "." + super.i);
                asm.add("D=M");
                break;
            case _constant:
                asm.add("@"+super.i);
                asm.add("D=A");
                break;
            case _that:
                asm.add("@THAT");
                asm.add("A=A+" + super.i);
                asm.add("D=M");
                break;
            case _this:
                asm.add("@THIS");
                asm.add("A=A+" + super.i);
                asm.add("D=M");
                break;
            case _local:
                asm.add("@LCL");
                asm.add("A=A+" + super.i);
                asm.add("D=M");
                break;
            case _argument:
                asm.add("@ARG");
                asm.add("A=A+" + super.i);
                asm.add("D=M");
                break;
        }
    }
}
