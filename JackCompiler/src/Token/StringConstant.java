package Token;

public class StringConstant extends Token {
    private String token;

    public StringConstant(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<StringConstant>"+token+"</StringConstant>";
    }
}
