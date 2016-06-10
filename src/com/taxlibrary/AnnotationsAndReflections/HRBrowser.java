package com.taxlibrary.AnnotationsAndReflections;

import com.taxlibrary.JDBC.EmployeeDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ktoloc on 10.06.2016.
 */
public class HRBrowser {
    @MyJDBCExecutor (sqlStatement="Select * from Employee")
    public List<EmployeeDTO> getEmployees(){
        // Generate the code to get the the data from DBMS,
        // place them in ArrayList and return them to the
        // caller of my getEmployees
        return new ArrayList<EmployeeDTO>();
    }

    @MyJDBCExecutor (sqlStatement="Update Employee set bonus=1000",
            transactionRequired=true,
            notifyOnUpdates=true)

    public void updateData(){
        // JDBC code to perform transactional updates  and
        // notifications goes here
    }
}
