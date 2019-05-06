package VMCommands;

import java.util.ArrayList;
import java.util.List;

public class DoNothingCommand extends Command {
    @Override
    public List<String> toASMCommands() {
        return new ArrayList<>();
    }
}
