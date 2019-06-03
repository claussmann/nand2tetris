package Token;

public class Identifier extends Token {

    private String token;

    public Identifier(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<Identifier>"+token+"</Identifier>";
    }
}
