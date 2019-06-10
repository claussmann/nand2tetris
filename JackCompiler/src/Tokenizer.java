import Token.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {

    String keywords = "(while|if|else|class|constructor|method|function|field|static|var|int|char|boolean|void|true|false|null|this|let|do|return)";
    String symbols = "(\\{|}|\\(|\\)|\\[|]|\\.|,|;|\\+|-|\\*|/|<|>|=|~)";
    String intConst = "[0-9]";
    String stringConst = "\\\"(.*?)\\\"";
    String identifier = "[a-zA-Z]+";

    public Queue<Token> tokenize(List<String> rawInput){
        rawInput = removeComments(rawInput);
        Queue<Token> tokens = new LinkedList<Token>();
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

    private List<String> removeComments(List<String> rawInput) {
        List<String> ret = new ArrayList<>();
        String tmp;
        for (int i=0; i<rawInput.size(); i++) {
            tmp=rawInput.get(i);
            if(tmp.contains("//")){
                tmp=tmp.substring(0, tmp.indexOf("//"));
                ret.add(tmp);
                continue;
            }
            if(tmp.contains("/*") && tmp.contains("*/")){
                tmp=tmp.substring(0, tmp.indexOf("/*")) + tmp.substring(tmp.indexOf("*/")+2);
                ret.add(tmp);
                continue;
            }
            if(tmp.contains("/*")){
                while (!rawInput.get(i).contains("*/")){
                    i++;
                }
                continue;
            }
            ret.add(tmp);
        }
        return ret;
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
