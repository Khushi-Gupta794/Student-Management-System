package com.example.sms.Repository;

import com.example.sms.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Courses, Long> {
}
