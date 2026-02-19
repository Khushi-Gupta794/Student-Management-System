package com.example.sms.Controller;

import com.example.sms.Config.OpenAPIConfig;
import com.example.sms.api.CoursesApi;
import com.example.sms.model.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoursesController implements CoursesApi {

    @Override
    public ResponseEntity<Course> createCourse(Course course) {
        return CoursesApi.super.createCourse(course);
    }
}
