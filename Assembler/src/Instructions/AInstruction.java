package Instructions;

public class AInstruction extends Instruction {

    private int value;

    public AInstruction(int value){

        this.value = value;
    }

    @Override
    public String toBinary() {
        String ret = Integer.toBinaryString(value);
        if(ret.length()>15){
            ret = ret.substring(ret.length()-15, ret.length());
        }
        while (ret.length()<16){
            ret="0" + ret;
        }
        return ret;
    }
}
