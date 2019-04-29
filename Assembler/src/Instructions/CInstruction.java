package Instructions;

public class CInstruction extends Instruction {

    Destination destination;
    Jump jump;
    ALUOperation operation;


    public CInstruction(String instruction) {
        parse(instruction);
    }

    private void parse(String instruction){
        //instruction like A=M+D;JMP
        if(instruction.contains("=")){
            String dest = instruction.split("=")[0];
            destination = new Destination(dest);
            instruction = instruction.split("=")[1];
        }
        else{
            destination = new Destination("");
        }

        if(instruction.contains(";")){
            String jmp = instruction.split(";")[1];
            jump = new Jump(jmp);
            instruction = instruction.split(";")[0];
        }
        else {
            jump = new Jump("");
        }

        operation = new ALUOperation(instruction);
    }

    @Override
    public String toBinary() {
        return "111" + operation + destination + jump;
    }
}
