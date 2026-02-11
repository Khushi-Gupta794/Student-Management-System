package com.example.sms.Repository;

import com.example.sms.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRepo extends JpaRepository<Department,Long> {
}
