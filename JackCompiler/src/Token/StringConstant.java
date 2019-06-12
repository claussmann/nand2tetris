package Token;

public class StringConstant extends Token {

    public StringConstant(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<stringConst>"+token+"</stringConst>";
    }
}
