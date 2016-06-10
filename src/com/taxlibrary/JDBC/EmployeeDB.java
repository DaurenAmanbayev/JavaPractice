package com.taxlibrary.JDBC;

//import com.sun.corba.se.pept.transport.Connection;
import com.taxlibrary.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.*;

/**
 * Created by ktoloc on 10.06.2016.
 */
public class EmployeeDB {


    public static void Select()
    {

        String sqlQuery = "SELECT * from Employee";

        // Open autocloseable Connection, Statement and get the result set
        try (Connection conn = DriverManager.getConnection( "jdbc:derby:C:\\Program Files\\Java\\jdk1.8.0_77\\db\\bin\\StudyDB");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery); ) {

            // Process the result set - print Employees
            while (rs.next()){
                int empNo = rs.getInt("EMPNO");
                String eName = rs.getString("ENAME");
                String job = rs.getString("JOB_TITLE");
                System.out.println(""+ empNo + ", " + eName + ", " + job );
            }
        } catch( SQLException se ) {
            System.out.println ("SQLError: " + se.getMessage ()
                    + " code: " + se.getErrorCode ());

        } catch( Exception e ) {
            System.out.println(e.getMessage());
        }
        Console.Print("Finished...");
    }
}
