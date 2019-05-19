package VMCommands.FunctionCommands;

import java.util.ArrayList;
import java.util.List;

public class Function extends FunctionCommand {
    private final String name;
    private final int varc;

    public Function(String name, int varc){
        this.name = name;
        this.varc = varc;
    }

    @Override
    public List<String> toASMCommands() {
        List<String> asm = new ArrayList<>();

        asm.add("("+name+")");

        for (int i = 0; i < varc; i++) {
            asm.add("@SP");
            asm.add("A=M");
            asm.add("M=0");
            asm.add("@SP");
            asm.add("M=M+1");
        }
        return asm;
    }
}
