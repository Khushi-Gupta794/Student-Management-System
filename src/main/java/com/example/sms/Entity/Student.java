package com.example.sms.Entity;

import jakarta.persistence.*;
import org.apache.logging.log4j.util.Lazy;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Stud_id;
    private String stud_name;
    private  String email;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStud_name() {
        return stud_name;
    }

    public void setStud_name(String stud_name) {
        this.stud_name = stud_name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public Long getPhnNum() {
        return phnNum;
    }

    public void setPhnNum(Long phnNum) {
        this.phnNum = phnNum;
    }

    public Long getStud_id() {
        return Stud_id;
    }

    public void setStud_id(Long stud_id) {
        Stud_id = stud_id;
    }

    private Long phnNum;
    private int rollNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "depart_id")
    private Department department;

}
