package com.example.sms.Controller;

import com.example.sms.Entity.*;
import com.example.sms.Service.MainService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }


    // DEPARTMENT APIs
    @PostMapping("/departments")
    public Department createDepartment(@RequestBody Department dept) {
        return service.createDepart(dept);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return service.getAllDepartment();
    }

    @GetMapping("/departments/{depart_id}")
    public Department getDepartment(@PathVariable Long depart_id) {
        return  service.getDepartById(depart_id);
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable Long id,
                                       @RequestBody Department dept) {
        return service.updateDepart(id, dept);
    }

    @DeleteMapping("/departments/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        service.deleteByDepartId(id);
    }


    // STUDENT APIs


    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return service.createStu(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Long id) {
       return  service.getStuById(id);
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id,
                                 @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
    }


    // TEACHER APIs


    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return service.createTeach(teacher);
    }

    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }

    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        service.deleteTeacher(id);
    }


    // COURSE APIs
    @PostMapping("/courses")
    public Courses createCourse(@RequestBody Courses course) {
        return service.createCourse(course);
    }

    @GetMapping("/courses")
    public List<Courses> getAllCourses() {
        return service.getAllCourses();
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        service.deleteCourse(id);
    }


    // ENROLLMENT APIs
   @PostMapping("/enroll")
    public Enrollment enrollStudent(
            @RequestParam Long studentId,
            @RequestParam Long courseId,
            @RequestParam String grade) {

        return service.enrollStudent(studentId, courseId, grade);
    }

    @GetMapping("/enroll")
    public List<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }

    //pagination and sorting
    @GetMapping("/teacher/paging")
    public Page<Teacher> getTeachers(
            @RequestParam int page,
            @RequestParam int size) {

        return service.getTeachers(page, size);
    }

    //jpql
    @GetMapping("/students/department/{id}")
    public List<Student> getByDepartment(@PathVariable Long id) {
        return service.getStudentsByDept(id);
    }

}
