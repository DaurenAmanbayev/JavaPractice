package com.taxlibrary.Expressions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ktoloc on 08.06.2016.
 */
public class ImperativeVsFunctional {

    public static void Test()
    {
        List<String> winners=new ArrayList<>();
        winners.add("mary");
        winners.add("ringo");
        winners.add("joe");
        winners.add("paul");

        boolean gotRingo=false;
        //Imperative style
        for (String winner:winners
             ) {
            if("ringo".equals(winner))
                gotRingo=true;
            System.out.println("Imperative style. Ringo won?" + gotRingo);

        }

        //Functional style
        System.out.println("Imperative style. Ringo won?" + winners.contains("ringo"));
    }

}
