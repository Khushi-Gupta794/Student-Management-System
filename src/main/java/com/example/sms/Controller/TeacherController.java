package com.example.sms.Controller;

import com.example.sms.Service.MainService;
import com.example.sms.api.TeachersApi;
import com.example.sms.model.Teacher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class TeacherController implements TeachersApi {
    private final MainService mainService;

    public TeacherController(MainService mainService){
        this.mainService= mainService;
    }

    @Override
    public ResponseEntity<Teacher> createTeacher(Teacher teacher) {
        return TeachersApi.super.createTeacher(teacher);
    }

    @Override
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return TeachersApi.super.getAllTeachers();
    }
}
