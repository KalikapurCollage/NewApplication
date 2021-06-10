package com.example.newapplication;

public class Teachers {

    private String name;
    private String department;
    private String seatNo;

    public Teachers(String name, String department, String seatNo) {

        this.name = name;
        this.department = department;
        this.seatNo = seatNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

}
