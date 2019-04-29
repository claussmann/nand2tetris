package Instructions;

public class Label {
    String name;
    int address;

    public Label(String name, int address){
        this.name = name;
        this.address=address;
    }

    public int getAddress(){
        return address;
    }

    @Override
    public boolean equals(Object o){
        try{
            return ((Label)o).name.equals(this.name);
        }catch (Exception e){
            return false;
        }
    }
}
