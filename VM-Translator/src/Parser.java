import VMCommands.Arithmetic.Add;
import VMCommands.Command;
import VMCommands.DoNothingCommand;
import VMCommands.MemSegment;
import VMCommands.MemoryCommands.Push;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    List<Command> commands;

    public Parser(){
        commands = new ArrayList<>();
    }

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
            return new Push(translateMemSeg(tmp[1]), Integer.parseInt(tmp[2]), VMTranslator.filename);
        }
        if (cmd.startsWith("add")) {
            return new Add();
        }
        return new DoNothingCommand();
    }

    private MemSegment translateMemSeg(String s) {
        switch (s) {
            case "constant":
                return MemSegment._constant;
            case "local":
                return MemSegment._local;
            case "argument":
                return MemSegment._argument;
            case "this":
                return MemSegment._this;
            case "that":
                return MemSegment._that;
            case "static":
                return MemSegment._static;
            case "temp":
                return MemSegment._temp;
            case "pointer":
                return MemSegment._pointer;
        }
        return MemSegment._constant;
    }


    private String removeComments(String line) {
        if (line.contains("//")) {
            line = line.substring(0, line.indexOf("//"));
        }
        return line;
    }
}
