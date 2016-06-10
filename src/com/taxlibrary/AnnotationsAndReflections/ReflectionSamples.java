package com.taxlibrary.AnnotationsAndReflections;

import java.lang.reflect.Method;

/**
 * Created by ktoloc on 10.06.2016.
 */
public class ReflectionSamples {

    @SuppressWarnings("rawtypes")
    public static void TestReflection()
    {
        try {
            Class c = Class.forName("reflection.Employee");
            Method methods[] = c.getDeclaredMethods();
            System.out.println("The  Employee methods:");

            for (Method method : methods) {
                System.out.println("*** Method Signature:" +
                        method.toString());
            }

            Class superClass = c.getSuperclass();
            System.out.println("The name of the superclass is "
                    + superClass.getName());

            Method superMethods[] = superClass.getDeclaredMethods();
            System.out.println("The superclass has:");

            for (Method superMethod : superMethods) {
                System.out.println("*** Method Signature:" +
                        superMethod.toString());
                System.out.println("      Return type: " +
                        superMethod.getReturnType().getName());
            }


            Class parameterTypes[]= new Class[] {String.class};

            @SuppressWarnings("unchecked")
            Method myMethod = c.getMethod( "changeAddress", parameterTypes);

            Object arguments[] = new Object[1];
            arguments[0] = "250 Broadway";
            myMethod.invoke(c.newInstance(),arguments);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("fallthrough")
    public static void SupressDemo() {
        int salaryBand = 3;
        int bonus;
        // Retrieve the salary band of the person from some data source here
        switch (salaryBand) {
            case 1:
                bonus = 1000;
                System.out.println("Giving bonus " + bonus);
                break;
            case 2:
                bonus = 2000;
                System.out.println("Giving bonus " + bonus);
                break;
            case 3:
                bonus = 6000;
                System.out.println("Giving bonus " + bonus);
            case 4:
                bonus = 10000;
                System.out.println("Giving bonus " + bonus);
                break;
            default:
                // wrong salary band
                System.out.println("Invalid salary band");
        }
    }

    public static void DBParamProcessor(String [] args)
    {
        if (args.length == 0) {
            System.out.println("Provide the name of the annotated class as a command-line argument.");
            System.out.println("For example, java DBParamProcessor tryit.MyDBWorker");
            System.exit(1);
        }

        String annotatedClass = args[0];

        try {
            Class classForIntrospection = Class.forName(annotatedClass);

            DBParam dbParamAnnotation = (DBParam) classForIntrospection.getAnnotation(DBParam.class);
            System.out.println("DB Name: " + dbParamAnnotation.dbName());
            System.out.println("User ID: " + dbParamAnnotation.uid());
            System.out.println("Password: " + dbParamAnnotation.password());

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}
