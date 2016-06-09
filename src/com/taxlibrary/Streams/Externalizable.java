package com.taxlibrary.Streams;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class Externalizable {

    public static void EmpExt()
    {
        try (FileInputStream fIn= new FileInputStream("NewEmployee2.ser");
             ObjectInputStream oIn = new ObjectInputStream(fIn);){

            Employee2 emp = new Employee2();
            emp.readExternal(oIn);

            System.out.println("Deserialized employee with id " + emp.id);
            System.out.printf("salary = $%7.2f", emp.salary); // format as dollars
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
