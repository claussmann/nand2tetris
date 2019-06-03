package Token;

public class IntegerConstant extends Token {
    private String token;

    public IntegerConstant(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<IntegerConstant>"+token+"</IntegerConstant>";
    }
}
