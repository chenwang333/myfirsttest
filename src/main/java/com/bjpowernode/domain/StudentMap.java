package com.bjpowernode.domain;

public class StudentMap {
    private int id;
    private String stuName;
    private String stuEmail;
    private int stuAge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuEmail() {
        return stuEmail;
    }

    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

    public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "StudentMap{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", stuEmail='" + stuEmail + '\'' +
                ", stuAge=" + stuAge +
                '}';
    }
}
