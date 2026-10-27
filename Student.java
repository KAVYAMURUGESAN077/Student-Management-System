package com.DTO;

public class Student {

    private int sid;
    private String sname;
    private long sph;

    public Student(int sid, String sname, long sph) {
        this.sid = sid;
        this.sname = sname;
        this.sph = sph;
    }

   
    public String toString() {
        return sid + " " + sname + " " + sph;
    }

    public int getsid() {
        return sid;
    }

    public String getsname() {
        return sname;
    }

    public long getsph() {
        return sph;
    }

    public void setsid(int id) {
        this.sid = id;
    }

    public void setename(String name) {
        this.sname = name;
    }

    public void setsph(long ph) {
        this.sph = ph;
    }
}