package CodeGeneration;



import java.util.HashMap;

public class SymbolTable {

    HashMap<Symbol, StackLocation> table;

    int countField=0;
    int countStatic=0;
    int countArgument=0;
    int countLocal=0;

    public SymbolTable(){
        table=new HashMap<>();
    }

    public void add(String varName, String type, String kind){
        int tmp = 0;
        if(kind.equals("field")) tmp=countField;
        if(kind.equals("static")) tmp=countStatic;
        if(kind.equals("argument")) tmp=countArgument;
        if(kind.equals("local")) tmp=countLocal;
        table.put(new Symbol(varName,type), new StackLocation(kind, tmp));
    }

    public String getLocation(String varName){
        Symbol tmp=new Symbol(varName, null);
        return table.get(tmp).segment + " " + table.get(tmp).offset;
    }

    public boolean exists(String varName){
        return table.containsKey(new Symbol(varName, null));
    }
}
