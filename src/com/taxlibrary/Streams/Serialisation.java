package com.taxlibrary.Streams;

import java.io.*;

/**
 * Created by ktoloc on 09.06.2016.
 */
public class Serialisation {

    public static void UseSerialisationWrite()
    {
        Bike bike=new Bike();
        bike.model="Stels";
        bike.price=250;

        FileOutputStream fOut=null;
        ObjectOutputStream oOut=null;

        try{
            fOut=new FileOutputStream("e:\\test.txt");
            oOut=new ObjectOutputStream(fOut);

            oOut.writeObject(bike);//serialisation

        }
        catch (IOException e)
        {
            //----------------
        }
    }

    public static void UseSerialisationRead()
    {
        FileInputStream fIn=null;
        ObjectInputStream oIn=null;

        try
        {
            fIn=new FileInputStream("e:\\test.txt");

            oIn=new ObjectInputStream(fIn);

            Bike bike=(Bike) oIn.readObject();

            System.out.println(bike.model);
        }
        catch (ClassNotFoundException cnf)
        {
            cnf.printStackTrace();
        }
        catch (IOException e)
        {
            //----------------------
        }
    }
}
