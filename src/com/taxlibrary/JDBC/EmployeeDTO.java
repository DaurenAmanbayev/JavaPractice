package com.taxlibrary.JDBC;

/**
 * Created by ktoloc on 10.06.2016.
 */
public class EmployeeDTO {

    private int empNo;
    private String eName;
    private String jobTitle;

    //setters
    public void setEmpNo(int val){empNo=val;}
    public void setEName(String val){eName=val;}
    public void setJobTitle(String val){jobTitle=val;}

    //getters
    public int getEmpNo(){return empNo;}

    public String geteName() {
        return eName;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
