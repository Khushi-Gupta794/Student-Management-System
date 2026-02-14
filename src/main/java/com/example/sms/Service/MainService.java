package com.example.sms.Service;

import com.example.sms.ENUM.Grade;
import com.example.sms.Entity.*;
import com.example.sms.Repository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    private final DepartRepo departRepo;

    private final StuRepo stuRepo;

    private final TeacherRepo teacherRepo;

    private final CourseRepo courseRepo;

    private final EnrollRepo enrollRepo;

    public MainService(DepartRepo departRepo,StuRepo stuRepo,TeacherRepo teacherRepo, CourseRepo courseRepo, EnrollRepo enrollRepo){
        this.departRepo = departRepo;
        this.stuRepo= stuRepo;
        this.teacherRepo=teacherRepo;
        this.courseRepo = courseRepo;
        this.enrollRepo= enrollRepo;
    }

    //department part
    public Department createDepart(Department dept){
        dept.setDepart_name(dept.getDepart_name());
       return  departRepo.save(dept);
    }

    public List<Department> getAllDepartment(){
        return departRepo.findAll();
    }

    public Department getDepartById(Long depart_id){
        return departRepo.findById(depart_id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Department updateDepart(Long depart_id, Department newDept){
        Department dept= (Department) getDepartById(depart_id);
        dept.setDepart_name(dept.getDepart_name());
        return departRepo.save(dept);
    }

    public void deleteByDepartId(Long depart_id){
        departRepo.deleteById(depart_id);
    }

    //student part
    public Student createStu(Student stud){
       // stud.setStud_name(stud.getStud_name());
       // stud.setEmail(stud.getEmail());
        //stud.setPhnNum(stud.getPhnNum());  directly use save
        return stuRepo.save(stud);
}

    public List<Student> getAllStudents(){
        return stuRepo.findAll();
    }

    public Student getStuById(Long Stud_id) {
        return stuRepo.findById(Stud_id).orElseThrow(() -> new RuntimeException("Student not found"));
    }// ide suggest singletonlist as now iam working on list not optional because orElseThrow only works with optional

    public Student updateStudent(Long id, Student newStud) {
        Student stud = (Student) getStuById(id);
        stud.setStud_name(newStud.getStud_name());
        stud.setEmail(newStud.getEmail());
        stud.setPhnNum(newStud.getPhnNum());
        return stuRepo.save(stud);
    }

    public void deleteStudent(Long id) {
        stuRepo.deleteById(id);
    }

    /// teacher part

    public Teacher createTeach(Teacher tc){
     //   tc.setName(tc.getName());
        return teacherRepo.save(tc);
    }

    public List<Teacher> getAllTeachers() {
        return teacherRepo.findAll();
    }

    public void deleteTeacher(Long id) {
        teacherRepo.deleteById(id);
    }

    //course part
    public Courses createCourse(Courses courses){
        courses.setCourse_name(courses.getCourse_name());
        return courseRepo.save(courses);
    }

    public List<Courses> getAllCourses() {
        return courseRepo.findAll();
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }

    // Enrollment part
    public Enrollment enrollStudent(Long studentId, Long courseId, String grade) {

        Student student = stuRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Courses course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourses(course);
        Grade gradeEnum = Grade.valueOf(grade.toUpperCase());
        enrollment.setGrade(gradeEnum);

        return enrollRepo.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollRepo.findAll();
    }

    //pagination and sorting
    public Page<Teacher> getTeachers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        return teacherRepo.findAll(pageable);
    }

    //jpql
    public List<Student> getStudentsByDept(Long deptId) {
        return stuRepo.getStudentsByDepartment(deptId);
    }




}
