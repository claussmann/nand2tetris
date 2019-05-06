import VMCommands.Command;

import java.io.PrintStream;
import java.util.List;

public class Parser {
    List<Command> commands;

    public void parse(List<String> vmCommands, PrintStream output) {
        for (String cmd : vmCommands) {
            commands.add(toCommand(cmd));
        }

        //print all commands in asm-translation to the output
        for(Command cmd : commands){
            for(String asm : cmd.toASMCommands()){
                output.println(asm);
            }
        }
    }

    private Command toCommand(String cmd) {
    }
}
