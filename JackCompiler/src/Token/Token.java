package Token;

public abstract class Token {
    String token="";
    public abstract String toXML();
    public String getToken(){
        return token;
    }
    @Override
    public boolean equals(Object o){
        return token.equals(o);
    }
    @Override
    public String toString(){
        return token;
    }
}
