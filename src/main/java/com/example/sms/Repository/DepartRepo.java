package com.example.sms.Repository;

import com.example.sms.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartRepo extends JpaRepository<Department,Long> {

}
