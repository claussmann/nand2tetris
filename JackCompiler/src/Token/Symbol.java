package Token;

public class Symbol extends Token {
    private String symbol;

    public Symbol(String symbol){

        this.symbol = symbol;
    }

    @Override
    public String toXML() {
        return "<symbol>"+symbol+"</symbol>";
    }

    public String getToken(){
        return token;
    }
}
