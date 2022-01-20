package com.bjpowernode.vo;

public class StudentAndClass {
    private int sid;
    private String sname;
    private String semail;
    private int sage;


    private String cname;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSemail() {
        return semail;
    }

    public void setSemail(String semail) {
        this.semail = semail;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }



    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "StudentAndClass{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", semail='" + semail + '\'' +
                ", sage=" + sage +

                ", cname='" + cname + '\'' +
                '}';
    }
}
