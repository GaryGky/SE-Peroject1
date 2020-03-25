package com.gary.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class Student {
    private int stu_id;
    private String stu_name;
    private String pwd;
    
    public int getStu_id() {
        return stu_id;
    }
    
    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }
    
    public String getStu_name() {
        return stu_name;
    }
    
    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }
    
    public String getPwd() {
        return pwd;
    }
    
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    @Override
    public String toString() {
        return "Student{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
    
    public Student(int stu_id, String stu_name, String pwd) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.pwd = pwd;
    }
}
