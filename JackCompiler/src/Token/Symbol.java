package Token;

public class Symbol extends Token {
    public Symbol(String symbol){

        this.token = symbol;
    }

    @Override
    public String toXML() {
        return "<symbol>"+token+"</symbol>";
    }
}
