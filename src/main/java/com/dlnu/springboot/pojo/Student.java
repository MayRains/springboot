package com.dlnu.springboot.pojo;

import java.io.Serializable;

//redis 序列化
public class Student implements Serializable {
    private Integer stuid;
    private String stuname;
    private String stugender;
    private Integer stuage;
    private String stuperfer;
    private String stustatus;
    private String stuedu;
    private String stuarea;
    private String stumajor;
    private Integer majorcode;
    private Integer political;
    private Integer math;
    private Integer english;
    private Integer major;

    @Override
    public String toString() {
        return "Student{" +
                "stuid=" + stuid +
                ", stuname='" + stuname + '\'' +
                ", stugender='" + stugender + '\'' +
                ", stuage=" + stuage +
                ", stuperfer='" + stuperfer + '\'' +
                ", stustatus='" + stustatus + '\'' +
                ", stuedu='" + stuedu + '\'' +
                ", stuarea='" + stuarea + '\'' +
                ", stumajor='" + stumajor + '\'' +
                ", majorcode=" + majorcode +
                ", political=" + political +
                ", math=" + math +
                ", english=" + english +
                ", major=" + major +
                '}';
    }

    public Integer getStuid() {
        return stuid;
    }

    public void setStuid(Integer stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStugender() {
        return stugender;
    }

    public void setStugender(String stugender) {
        this.stugender = stugender;
    }

    public Integer getStuage() {
        return stuage;
    }

    public void setStuage(Integer stuage) {
        this.stuage = stuage;
    }

    public String getStuperfer() {
        return stuperfer;
    }

    public void setStuperfer(String stuperfer) {
        this.stuperfer = stuperfer;
    }

    public String getStustatus() {
        return stustatus;
    }

    public void setStustatus(String stustatus) {
        this.stustatus = stustatus;
    }

    public String getStuedu() {
        return stuedu;
    }

    public void setStuedu(String stuedu) {
        this.stuedu = stuedu;
    }

    public String getStuarea() {
        return stuarea;
    }

    public void setStuarea(String stuarea) {
        this.stuarea = stuarea;
    }

    public String getStumajor() {
        return stumajor;
    }

    public void setStumajor(String stumajor) {
        this.stumajor = stumajor;
    }

    public Integer getMajorcode() {
        return majorcode;
    }

    public void setMajorcode(Integer majorcode) {
        this.majorcode = majorcode;
    }

    public Integer getPolitical() {
        return political;
    }

    public void setPolitical(Integer political) {
        this.political = political;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getMajor() {
        return major;
    }

    public void setMajor(Integer major) {
        this.major = major;
    }


}
