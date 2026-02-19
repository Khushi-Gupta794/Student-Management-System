package com.example.sms.Service;

import com.example.sms.Client.StudentClient;
import com.example.sms.DTO.StudentDTO;
import com.example.sms.ENUM.Grade;
import com.example.sms.Entity.Courses;
import com.example.sms.Entity.Enrollment;
import com.example.sms.Entity.Teacher;
import com.example.sms.Repository.CourseRepo;
import com.example.sms.Repository.EnrollRepo;
import com.example.sms.Repository.TeacherRepo;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final StudentClient studentClient;
    private final TeacherRepo teacherRepo;
    private final CourseRepo courseRepo;
    private final EnrollRepo enrollRepo;

    public MainService(StudentClient studentClient,
                       TeacherRepo teacherRepo,
                       CourseRepo courseRepo,
                       EnrollRepo enrollRepo) {

        this.studentClient = studentClient;
        this.teacherRepo = teacherRepo;
        this.courseRepo = courseRepo;
        this.enrollRepo = enrollRepo;
    }

    //TEACHER

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }

    public Page<Teacher> getTeachers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        return teacherRepo.findAll(pageable);
    }

    // COURSE

    public Courses createCourse(Courses course) {
        return courseRepo.save(course);
    }

    public List<Courses> getAllCourses() {
        return courseRepo.findAll();
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    //ENROLLMENT

    public Enrollment enrollStudent(Long studentId, Long courseId, String grade) {

        // Call student-service via Feign
        StudentDTO student = studentClient.getStudentById(studentId);

        if (student == null) {
            throw new RuntimeException("Student not found in student-service");
        }

        Courses course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudentId(student.getStud_id());
        enrollment.setCourses(course);
        try {
            enrollment.setGrade(Grade.valueOf(grade.toUpperCase()));
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Invalid grade value. Allowed: A, B, C, D");
        }

        return enrollRepo.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollRepo.findAll();
    }
}