package Token;

import Parser.DataType;
import Parser.Term;

public class Identifier extends Token implements Term, DataType {

    private String token;

    public Identifier(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<identifier>"+token+"</identifier>";
    }

    public String getToken(){
        return token;
    }
}
