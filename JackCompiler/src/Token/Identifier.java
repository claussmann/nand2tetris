package Token;

import Parser.Term;

public class Identifier extends Token implements Term {

    private String token;

    public Identifier(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<identifier>"+token+"</identifier>";
    }
}
