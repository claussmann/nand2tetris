import Token.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    String keywords = "(while|if|else|class|constructor|method|field|static|var|int|char|boolean|void|true|false|null|this|let|do|return)";
    String symbols = "(\\{|}|\\(|\\)|\\[|]|\\.|,|;|\\+|-|\\*|/|<|>|=|~)";
    String intConst = "[0-9]";
    String stringConst = "\\\"(.*?)\\\"";
    String identifier = "[a-zA-Z]+";

    public List<Token> tokenize(List<String> rawInput){
        ArrayList<Token> tokens = new ArrayList<>();
        for(String line : rawInput){
            String pattern = "("+keywords+"|"+symbols+"|"+identifier+"|"+intConst+"|"+stringConst+")";

            Pattern p= Pattern.compile(pattern);
            Matcher matcher = p.matcher(line.trim());
            while(matcher.find()) {
                tokens.add(genTokenOf(matcher.group(0)));
            }
        }
        return tokens;
    }

    private Token genTokenOf(String token) {

        if(token.matches(keywords)){
            return new KeyWord(token);
        }
        if(token.matches(symbols)){
            return new Symbol(token);
        }
        if(token.matches(intConst)){
            return new IntegerConstant(token);
        }
        if(token.matches(stringConst)){
            return new StringConstant(token);
        }
        if(token.matches(identifier)){
            return new Identifier(token);
        }
        System.out.println("Warning: Unresolvable token: "+token);
        return new UnresolvedToken();
    }
}
