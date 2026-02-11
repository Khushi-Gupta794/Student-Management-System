package com.example.sms.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="enroll")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="Stud_id")
   private Student student;
    @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "course_id")
   private Courses courses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}
