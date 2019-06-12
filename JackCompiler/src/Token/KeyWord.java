package Token;

import Parser.DataType;

public class KeyWord extends Token implements DataType {
    public KeyWord(String token) {

        this.token = token;
    }

    @Override
    public String toXML() {
        return "<keyword>"+token+"</keyword>";
    }

}
