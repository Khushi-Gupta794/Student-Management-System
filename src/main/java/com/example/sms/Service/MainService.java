package com.example.sms.Service;

import com.example.sms.Entity.Department;
import com.example.sms.Entity.Student;
import com.example.sms.Repository.DepartRepo;
import com.example.sms.Repository.StuRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {

    private final DepartRepo departRepo;

    private final StuRepo stuRepo;

    public MainService(DepartRepo departRepo,StuRepo stuRepo){
        this.departRepo = departRepo;
        this.stuRepo= stuRepo;
    }







    public Department createDepart(Department dept){
        dept.setDepart_name(dept.getDepart_name());
       return  departRepo.save(dept);
    }

    public Student createStu(Student stud){
        stud.setStud_name(stud.getStud_name());
        stud.setEmail(stud.getEmail());
        stud.setPhnNum(stud.getPhnNum());
        return stuRepo.save(stud);

    }


}
