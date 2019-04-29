package Instructions;

public class Destination {

    private String binary;

    public Destination(String dest){
        switch (dest){
            case "":
                binary = "000";
                break;
            case "M":
                binary = "001";
                break;
            case "D":
                binary = "010";
                break;
            case "MD":
                binary = "011";
                break;
            case "A":
                binary = "100";
                break;
            case "AM":
                binary = "101";
                break;
            case "AD":
                binary = "110";
                break;
            case "AMD":
                binary = "111";
                break;
        }
    }

    @Override
    public String toString(){
        return binary;
    }
}
