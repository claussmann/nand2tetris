package CodeGeneration;

public class StackLocation {

    final String segment;
    final int offset;

    public StackLocation(String segment, int tmp) {
        this.segment = segment;
        this.offset = tmp;
    }
}
