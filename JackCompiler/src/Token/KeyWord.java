package Token;

public class KeyWord extends Token {
    private String token;

    public KeyWord(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<KeyWord>"+token+"</KeyWord>";
    }
}
