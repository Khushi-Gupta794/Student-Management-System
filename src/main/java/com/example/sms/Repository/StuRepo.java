package com.example.sms.Repository;

import com.example.sms.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StuRepo extends JpaRepository<Student, Long> {
}
