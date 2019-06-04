package Token;

import Parser.Term;

public class StringConstant extends Token implements Term {
    private String token;

    public StringConstant(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<stringConst>"+token+"</stringConst>";
    }

    public String getToken(){
        return token;
    }
}
