package com.example.sms.Entity;

import com.example.sms.ENUM.Grade;
import com.example.sms.EnrollmentId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name="enroll")  //child class
public class Enrollment {

  //  @EmbeddedId
    //private EnrollmentId id;

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Column(name = "student_id")
    private Long studentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
   // @MapsId("courseId")
   @JoinColumn(name = "course_id")
   private Courses courses;







    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }
}
