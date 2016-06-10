package com.taxlibrary.JDBC;

//import com.sun.corba.se.pept.transport.Connection;
import com.taxlibrary.Console;
import com.taxlibrary.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.Callable;
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

    public static void SelectDTO()
    {
        String sqlQuery = "SELECT * from Employee";
        ArrayList<EmployeeDTO> employees=new ArrayList<>();


        // Open autocloseable Connection, Statement and get the result set
        try (Connection conn = DriverManager.getConnection( "jdbc:derby:C:\\Program Files\\Java\\jdk1.8.0_77\\db\\bin\\StudyDB");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery); ) {

            // Process the result set - print Employees
            while (rs.next()){
                EmployeeDTO currentEmp=new EmployeeDTO();
                currentEmp.setEmpNo(rs.getInt("EMPNO"));
                currentEmp.setEName(rs.getString("ENAME"));
                currentEmp.setJobTitle(rs.getString("JOB_TITLE"));
               // System.out.println(""+ empNo + ", " + eName + ", " + job );
                employees.add(currentEmp);
            }
        } catch( SQLException se ) {
            System.out.println ("SQLError: " + se.getMessage ()
                    + " code: " + se.getErrorCode ());

        } catch( Exception e ) {
            System.out.println(e.getMessage());
        }
        Console.Print("Finished...");
    }

    public static void PreparedSelect()
    {
        String sqlQuery = "SELECT * from Employee";
        ArrayList<EmployeeDTO> employees=new ArrayList<>();


        // Open autocloseable Connection, Statement and get the result set
        try (Connection conn = DriverManager.getConnection( "jdbc:derby:C:\\Program Files\\Java\\jdk1.8.0_77\\db\\bin\\StudyDB");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery); ) {

            // Process the result set - print Employees
            while (rs.next()){
                EmployeeDTO currentEmp=new EmployeeDTO();
                currentEmp.setEmpNo(rs.getInt("EMPNO"));
                currentEmp.setEName(rs.getString("ENAME"));
                currentEmp.setJobTitle(rs.getString("JOB_TITLE"));
                employees.add(currentEmp);
            }

            //SQLparameters аналог в .Net
            PreparedStatement statement=conn.prepareStatement("SELECT * from Employee WHERE empno=? and ename=?");

            for (EmployeeDTO emp: employees
                 ) {

                statement.setInt(1, emp.getEmpNo());
                statement.setString(2, emp.geteName());
                statement.executeQuery();
            }
            /*
            //call stored procedures
            CallableStatement callable=conn.prepareCall("{call changeEmpTitle(?,?)}");

            callable.setInt(1,7556);
            callable.setString(2, "Salesman");
            callable.executeUpdate();
            */

        } catch( SQLException se ) {
            System.out.println ("SQLError: " + se.getMessage ()
                    + " code: " + se.getErrorCode ());

        } catch( Exception e ) {
            System.out.println(e.getMessage());
        }


    }

    public static void ShowMetedata()
    {
        String sqlQuery = "SELECT * from Employee";


        // Open autocloseable Connection, Statement and get the result set
        try (Connection conn = DriverManager.getConnection( "jdbc:derby:C:\\Program Files\\Java\\jdk1.8.0_77\\db\\bin\\StudyDB");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sqlQuery); ) {

            ResultSetMetaData rsMeta=rs.getMetaData();
            int colCount=rsMeta.getColumnCount();

            for (int i=1; i<=colCount;i++)
            {
                Console.Print(rsMeta.getColumnName(i)+" ");
            }
            Console.Print(" ");
            /*
            while (rs.next())
            {
                for (int i=1; i<=colCount;i++)
                {
                    Console.Print(rsMeta.getString(i)+" ");
                }
                Console.Print(" ");
            }*/

        } catch( SQLException se ) {
            System.out.println ("SQLError: " + se.getMessage ()
                    + " code: " + se.getErrorCode ());

        } catch( Exception e ) {
            System.out.println(e.getMessage());
        }
    }

    public static void ScrollableRs()
    {
        String sqlQuery = "SELECT * from Employee";


        // Open autocloseable Connection, Statement and get the result set
        try (Connection conn = DriverManager.getConnection( "jdbc:derby:C:\\Program Files\\Java\\jdk1.8.0_77\\db\\bin\\StudyDB");
             Statement stmt = conn.createStatement(
             ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = stmt.executeQuery(sqlQuery); ) {

            rs.afterLast();
            while(rs.previous())
            {
                int empNo=rs.getInt("EMPNO");
                String eName = rs.getString("ENAME");
                String job = rs.getString("JOB_TITLE");

            }
            Console.Print(" ");
            rs.absolute(25);//25
            rs.relative(-4);//21
            rs.first();
            rs.last();
            rs.isBeforeFirst();

            //CONCUR_UPDATABLE
            /*
            rs.updateString("JOB_TITLE", "Manager");
            rs.updateRow;
            * */

        } catch( SQLException se ) {
            System.out.println ("SQLError: " + se.getMessage ()
                    + " code: " + se.getErrorCode ());

        } catch( Exception e ) {
            System.out.println(e.getMessage());
        }
    }

    public static void TransactionUpdates()
    {
        //String sqlQuery = "SELECT * from Employee";


        // Open autocloseable Connection, Statement and get the result set
        try (Connection conn = DriverManager.getConnection( "jdbc:derby:C:\\Program Files\\Java\\jdk1.8.0_77\\db\\bin\\StudyDB");
             Statement stmt = conn.createStatement();
            ) {
            conn.setAutoCommit(false);

            stmt.addBatch("insert into Employee values (736, 'John Smith', 'Clerk')," +
                    " (7099, 'Joe Dallen', 'Salesman'), (1521, 'Mary Luu', 'Director')");

            stmt.addBatch("insert into Employee values (1, 'Neo', 'CoolHacker')");

            stmt.executeBatch();
            conn.commit();

        } catch( SQLException se ) {
            System.out.println ("SQLError: " + se.getMessage ()
                    + " code: " + se.getErrorCode ());

        } catch( Exception e ) {
            System.out.println(e.getMessage());
        }
    }

}
