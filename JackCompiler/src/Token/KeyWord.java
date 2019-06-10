package Token;

import Parser.DataType;

public class KeyWord extends Token implements DataType {
    private String token;

    public KeyWord(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<keyword>"+token+"</keyword>";
    }

    public String getToken(){
        return token;
    }
}
