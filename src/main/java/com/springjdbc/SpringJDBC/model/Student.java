package com.springjdbc.SpringJDBC.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {
    private int srollno;
    private String sname;
    private int smarks;

    public int getSrollno() {
        return srollno;
    }

    public void setSrollno(int srollno) {
        this.srollno = srollno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSmarks() {
        return smarks;
    }

    public void setSmarks(int smarks) {
        this.smarks = smarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "srollno=" + srollno +
                ", sname='" + sname + '\'' +
                ", smarks=" + smarks +
                '}';
    }
}
