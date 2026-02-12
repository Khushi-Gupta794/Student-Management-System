package com.example.sms;

import com.example.sms.Entity.Student;
import org.springframework.data.jpa.domain.Specification;

public class StudentSpecification {

    public static Specification<Student> hasName(String name) {
        return (root, query, cb) ->
                cb.like(root.get("stud_name"), "%" + name + "%");
    }

    public static Specification<Student> hasDepartment(Long id) {
        return (root, query, cb) ->
                cb.equal(root.get("department").get("depart_id"), id);
    }
}

