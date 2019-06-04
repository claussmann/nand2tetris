package Parser;

import java.util.ArrayList;

public class Statements {
    ArrayList list;
    public Statements (){
        list=new ArrayList();
    }

    public void add(Statement statement){
        list.add(statement);
    }
}
