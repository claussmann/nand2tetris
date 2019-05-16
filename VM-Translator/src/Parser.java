import VMCommands.ArithmeticCommands.*;
import VMCommands.BranchingCommands.Goto;
import VMCommands.BranchingCommands.IfGoto;
import VMCommands.BranchingCommands.Label;
import VMCommands.Command;
import VMCommands.DoNothingCommand;
import VMCommands.FunctionCommands.Call;
import VMCommands.FunctionCommands.Function;
import VMCommands.FunctionCommands.Return;
import VMCommands.MemSegment;
import VMCommands.MemoryCommands.Pop;
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
        cmd = cmd.trim();
        if (cmd.startsWith("function")) {
            String[] tmp = cmd.split(" ");
            return new Function(tmp[1],Integer.parseInt(tmp[2]));
        }
        if (cmd.startsWith("call")) {
            String[] tmp = cmd.split(" ");
            return new Call(tmp[1],Integer.parseInt(tmp[2]));
        }
        if (cmd.startsWith("return")) {
            return new Return();
        }
        if (cmd.startsWith("push")) {
            String[] tmp = cmd.split(" ");
            return new Push(translateMemSeg(tmp[1]), Integer.parseInt(tmp[2]), VMTranslator.filename);
        }
        if (cmd.startsWith("pop")) {
            String[] tmp = cmd.split(" ");
            return new Pop(translateMemSeg(tmp[1]), Integer.parseInt(tmp[2]), VMTranslator.filename);
        }
        if (cmd.startsWith("if-goto")) {
            String[] tmp = cmd.split(" ");
            return new IfGoto(tmp[1]);
        }
        if (cmd.startsWith("goto")) {
            String[] tmp = cmd.split(" ");
            return new Goto(tmp[1]);
        }
        if (cmd.startsWith("label")) {
            String[] tmp = cmd.split(" ");
            return new Label(tmp[1]);
        }
        if (cmd.startsWith("add")) {
            return new Add();
        }
        if (cmd.startsWith("sub")) {
            return new Sub();
        }
        if (cmd.startsWith("Neg")) {
            return new Neg();
        }
        if (cmd.startsWith("eq")) {
            return new Eq();
        }
        if (cmd.startsWith("gt")) {
            return new Gt();
        }
        if (cmd.startsWith("lt")) {
            return new Lt();
        }
        if (cmd.startsWith("and")) {
            return new And();
        }
        if (cmd.startsWith("or")) {
            return new Or();
        }
        if (cmd.startsWith("not")) {
            return new Not();
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
