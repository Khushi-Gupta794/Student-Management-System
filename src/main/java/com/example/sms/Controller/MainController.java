package com.example.sms.Controller;

import com.example.sms.Entity.Courses;
import com.example.sms.Entity.Enrollment;
import com.example.sms.Entity.Teacher;
import com.example.sms.Service.MainService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;

import java.util.List;

@RestController
@RequestMapping("/api")
@Tag(name = "Student Management API", description = "APIs for managing Teachers, Courses, and Enrollments")
public class MainController {

    private final MainService service;

    public MainController(MainService service) {
        this.service = service;
    }

    // teacher

    @Operation(summary = "Create Teacher", description = "Create a new teacher record")
    @ApiResponse(responseCode = "200", description = "Teacher created successfully")
    @PostMapping("/teachers")
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return service.createTeacher(teacher);
    }

    @Operation(summary = "Get All Teachers")
    @GetMapping("/teachers")
    public List<Teacher> getAllTeachers() {
        return service.getAllTeachers();
    }

    @Operation(summary = "Delete Teacher by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Teacher deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Teacher not found")
    })
    @DeleteMapping("/teachers/{id}")
    public void deleteTeacher(
            @Parameter(description = "Teacher ID")
            @PathVariable Long id) {
        service.deleteTeacher(id);
    }

    @Operation(summary = "Get Teachers with Pagination")
    @GetMapping("/teachers/paging")
    public Page<Teacher> getTeachers(
            @Parameter(description = "Page number") @RequestParam int page,
            @Parameter(description = "Page size") @RequestParam int size) {

        return service.getTeachers(page, size);
    }

    // course
    @Operation(summary = "Create Course")
    @PostMapping("/courses")
    public Courses createCourse(@RequestBody Courses course) {
        return service.createCourse(course);
    }

    @Operation(summary = "Get All Courses")
    @GetMapping("/courses")
    public List<Courses> getAllCourses() {
        return service.getAllCourses();
    }

    @Operation(summary = "Delete Course by ID")
    @DeleteMapping("/courses/{id}")
    public void deleteCourse(
            @Parameter(description = "Course ID")
            @PathVariable Long id) {

        service.deleteCourse(id);
    }

    // enroll

    @Operation(summary = "Enroll Student in Course",
            description = "Enroll a student into a course using student-service via Feign Client")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Enrollment successful"),
            @ApiResponse(responseCode = "400", description = "Invalid input"),
            @ApiResponse(responseCode = "404", description = "Student or Course not found")
    })
    @PostMapping("/enroll")
    public Enrollment enrollStudent(
            @Parameter(description = "Student ID") @RequestParam Long studentId,
            @Parameter(description = "Course ID") @RequestParam Long courseId,
            @Parameter(description = "Grade (A, B, C, D)") @RequestParam String grade) {

        return service.enrollStudent(studentId, courseId, grade);
    }

    @Operation(summary = "Get All Enrollments")
    @GetMapping("/enroll")
    public List<Enrollment> getAllEnrollments() {
        return service.getAllEnrollments();
    }


}