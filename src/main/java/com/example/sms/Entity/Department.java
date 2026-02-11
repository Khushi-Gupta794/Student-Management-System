package com.example.sms.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "department")
public class Department {
    public Long getDepart_id() {
        return depart_id;
    }

    public void setDepart_id(Long depart_id) {
        this.depart_id = depart_id;
    }

    public String getDepart_name() {
        return depart_name;
    }

    public void setDepart_name(String depart_name) {
        this.depart_name = depart_name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long depart_id;
    private String depart_name;
}
