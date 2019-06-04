package Token;

import Parser.Term;

public class IntegerConstant extends Token implements Term {
    private String token;

    public IntegerConstant(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<integerConstant>"+token+"</integerConstant>";
    }

    public String getToken(){
        return token;
    }
}
