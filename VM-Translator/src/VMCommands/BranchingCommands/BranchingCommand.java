package VMCommands.BranchingCommands;

import VMCommands.Command;

public abstract class BranchingCommand extends Command {
    String labelname;
    public BranchingCommand(String labelname){
        this.labelname=labelname;
    }
}
