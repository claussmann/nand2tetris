package Instructions;

public class Jump {

    private String binary;

    public Jump(String jmp){
        switch (jmp){
            case "":
                binary = "000";
                break;
            case "JGT":
                binary = "001";
                break;
            case "JEG":
                binary = "010";
                break;
            case "JGE":
                binary = "011";
                break;
            case "JLT":
                binary = "100";
                break;
            case "JNE":
                binary = "101";
                break;
            case "JLE":
                binary = "110";
                break;
            case "JMP":
                binary = "111";
                break;
        }
    }

    @Override
    public String toString(){
        return binary;
    }
}
