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
        com.example.sms.Entity.Teacher entity =
                new com.example.sms.Entity.Teacher();
        entity.setName(teacher.getName());

        // Save using service
        com.example.sms.Entity.Teacher savedEntity =
                mainService.createTeacher(entity);

        // Convert Entity → Model
        Teacher response = new Teacher();
        response.setId(Math.toIntExact(savedEntity.getTeacher_id()));
        response.setName(savedEntity.getName());

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        return
                TeachersApi.super.getAllTeachers();
    }
}
