package CodeGeneration;

public class Symbol {
    private final String name;
    private final String type;

    public Symbol(String name, String type){

        this.name = name;
        this.type = type;
    }

    @Override
    public boolean equals(Object o){
        if(o.getClass().equals(String.class)) return o.equals(name);
        try{
            return ((Symbol)o).name.equals(this.name);
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public int hashCode(){
        return name.hashCode();
    }
}
