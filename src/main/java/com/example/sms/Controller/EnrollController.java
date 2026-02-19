package com.example.sms.Controller;

import com.example.sms.api.EnrollApi;
import com.example.sms.model.Enrollment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnrollController implements EnrollApi {
    @Override
    public ResponseEntity<Enrollment> enrollStudent(Long studentId, Long courseId, String grade) {
        return EnrollApi.super.enrollStudent(studentId, courseId, grade);
    }
}
