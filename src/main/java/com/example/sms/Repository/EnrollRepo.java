package com.example.sms.Repository;

import com.example.sms.EnrollmentId;
import com.example.sms.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollRepo extends JpaRepository<Enrollment, EnrollmentId> {
}
