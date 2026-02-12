package com.example.sms.Repository;

import com.example.sms.Entity.Student;
import com.example.sms.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    List<Teacher> findTeachByName(String name);//derived method
}
