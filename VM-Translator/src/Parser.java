import VMCommands.Arithmetic.Add;
import VMCommands.Command;
import VMCommands.MemSegment;
import VMCommands.MemoryCommands.Push;

import java.io.PrintStream;
import java.util.List;

public class Parser {
    List<Command> commands;

    public void parse(List<String> vmCommands, PrintStream output) {
        for (String cmd : vmCommands) {
            commands.add(toCommand(cmd));
        }

        //print all commands in asm-translation to the output
        for (Command cmd : commands) {
            for (String asm : cmd.toASMCommands()) {
                output.println(asm);
            }
        }
    }

    private Command toCommand(String cmd) {
        cmd = removeComments(cmd);
        if (cmd.startsWith("push")) {
            String[] tmp = cmd.split(" ");
            commands.add(new Push(translateMemSeg(tmp[1]), Integer.parseInt(tmp[2]), VMTranslator.filename);
        }
        if (cmd.startsWith("add")) {
            commands.add(new Add());
        }
    }

    private MemSegment translateMemSeg(String s) {
        switch (s) {
            case "constant":
                return MemSegment._constant;
                break;
            case "local":
                return MemSegment._local;
                break;
            case "argument":
                return MemSegment._argument;
                break;
            case "this":
                return MemSegment._this;
                break;
            case "that":
                return MemSegment._that;
                break;
            case "static":
                return MemSegment._static;
                break;
            case "temp":
                return MemSegment._temp;
                break;
            case "pointer":
                return MemSegment._pointer;
                break;
        }
    }


    private String removeComments(String line) {
        if (line.contains("//")) {
            line = line.substring(0, line.indexOf("//"));
        }
        return line;
    }
}
