package Token;


public class IntegerConstant extends Token {
    public IntegerConstant(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<integerConstant>"+token+"</integerConstant>";
    }

}
