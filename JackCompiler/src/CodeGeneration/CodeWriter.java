package CodeGeneration;

import Parser.*;

import java.io.PrintStream;
import java.util.List;

public class CodeWriter {
    String classname;
    SymbolTable classSymbolTable;

    public CodeWriter(){
        classSymbolTable=new SymbolTable();
    }

    public void toCode(PrintStream stream, Program program){
        classname=program.getClassname();
        for(ClassVarDeclaration dec : program.getClassVars()){
            classSymbolTable.add(dec.getVarName(), dec.getFieldType(), dec.getDatatype());
            stream.println("push constant 0");
            stream.println("pop " + classSymbolTable.getLocation(dec.getVarName()));
        }

        for(SubroutineDeclaration sub: program.getRoutines()){
            int parametercount = 0;
            if(sub.isMethod()){
                parametercount++;
                classSymbolTable.add("this",classname, "argument");
            }
            for(Parameter pam: sub.getParameterList()){
                classSymbolTable.add(pam.getName(),pam.getDatatype(), "argument");
                parametercount++;
            }
            stream.println("function "+sub.getName()+ " "+parametercount);
            for(VarDeclaration var: sub.getVars()){
                classSymbolTable.add(var.getName(),var.getDatatype(), "local");
                stream.println("push constant 0");
                stream.println("pop " + classSymbolTable.getLocation(var.getName()));
            }


            List<Statement> statements = sub.getStatements().getList();
            for(Statement s : statements){
                s.toVM(classSymbolTable, stream);
            }
        }
    }
}
