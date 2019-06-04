package Parser;

import java.util.ArrayList;

public class Statements {
    ArrayList<Statement> list;
    public Statements (){
        list=new ArrayList();
    }

    public void add(Statement statement){
        list.add(statement);
    }

    boolean validate() {
        for (Statement s:list){
            if(!s.validate()){
                return false;
            }
        }
        return true;
    }
}
