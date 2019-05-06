package VMCommands.MemoryCommands;

import VMCommands.Command;
import VMCommands.MemSegment;

public abstract class MemoryCommand extends Command {

    final MemSegment segment;
    final int i;
    String objectname;

    public MemoryCommand(MemSegment segment, int i, String objectname){

        this.segment = segment;
        this.i = i;
        this.objectname = objectname;
    }
}
