package Instructions;

public class AInstruction extends Instruction {

    private int value;
    private Label label;

    public AInstruction(int value){

        this.value = value;
    }

    public AInstruction(Label resolveLabel) {
        label = resolveLabel;
    }

    @Override
    public String toBinary() {
        if(label != null){
            value = label.getAddress();
        }
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
