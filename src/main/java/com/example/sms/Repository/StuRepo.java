package com.example.sms.Repository;

import com.example.sms.Entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface StuRepo extends JpaRepository<Student, Long> {
   // Optional<Student> findStuById(Long Stud_id);//derived Method--simple


    //query annotation --jpql--complex join
   @Query("SELECT s FROM Student s WHERE s.department.depart_id = :depart_id")
    List<Student> getStudentsByDepartment(@Param("depart_id") Long depart_id);

    //native query --when its db specific
     //@Query(value = "SELECT * FROM student WHERE email LIKE %:email%", nativeQuery = true)
   // List<Student> searchByEmail(@Param("email") String email);

    Page<Student> findAll(Pageable pageable);



}
