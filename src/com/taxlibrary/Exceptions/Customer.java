package com.taxlibrary.Exceptions;

import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by ktoloc on 07.06.2016.
 */
public class Customer {

    private String name;
    private String lastName;
    Customer(String name, String lastName)
    {
        this.name=name;
        this.lastName=lastName;
    }
    public String GetInfo()
    {
        return name+" "+lastName;
    }
    public void getCustomers() {

        try {
            Path p = Paths.get("customer.txt");
            Files.lines(p);
        } catch (FileNotFoundException e) {
            // throw e;
            System.out.println("Stop");
        } catch (IOException e1) {
            // throw e;
            System.out.println("Stop");
        }
    }
}


