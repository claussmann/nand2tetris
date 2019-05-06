package VMCommands;

import java.util.List;

public abstract class Command {
    abstract public List<String> toASMCommands();
}
