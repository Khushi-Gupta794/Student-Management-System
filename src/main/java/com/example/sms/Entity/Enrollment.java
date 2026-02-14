package com.example.sms.Entity;

import com.example.sms.ENUM.Grade;
import com.example.sms.EnrollmentId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="enroll")  //child class
public class Enrollment {

    @EmbeddedId
    private EnrollmentId id;

  //  @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
   // private Long id;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("studentId")
   @JoinColumn(name="Stud_id")
    @JsonBackReference
   private Student student;


    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("courseId")
   @JoinColumn(name = "course_id")
   private Courses courses;





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
