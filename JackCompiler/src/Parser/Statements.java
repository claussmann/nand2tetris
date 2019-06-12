package Parser;

import java.io.PrintStream;
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
            System.out.println("....checking statement "+s.getClass());
            if(!s.isValid()){
                return false;
            }
        }
        return true;
    }

    public void toXML(PrintStream printStream) {
        printStream.println("<statements>");
        for(Statement s : list){
            s.toXML(printStream);
        }
        printStream.println("</statements>");
    }
}
