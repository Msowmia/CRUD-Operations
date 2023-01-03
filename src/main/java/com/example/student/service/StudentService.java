package com.example.student.service;

import com.example.student.model.StudentEntity;
import com.example.student.model.StudentRequest;
import com.example.student.model.StudentResponse;
import com.example.student.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    ModelMapper mapper;

    public String create(StudentRequest request) {
            StudentEntity entity = new StudentEntity();
            entity.setId(request.getId());
            entity.setFirstname(request.getFirstname());
            entity.setLastname(request.getLastname());
            entity.setDept(request.getDept());
            entity.setEmail(request.getEmail());
            entity.setSalary(request.getSalary());
            entity.setAddress(request.getAddress());
            entity.setState(request.getState());
            entity.setCountry(request.getCountry());
            studentRepository.save(entity);
            log.info("STUDENT DETAIL IS ADDED{}", entity);
            return "Student Details are Created";
        }



    public StudentResponse add(StudentRequest request) {
        StudentResponse studentResponse = new StudentResponse();
        StudentEntity entity = mapper.map(request, StudentEntity.class);
        studentResponse = mapper.map(request, studentResponse.getClass());
        studentRepository.save(entity);
        return studentResponse;
    }



 /*   public StudentResponse add(StudentRequest request) {
        StudentResponse studentResponse = new StudentResponse();
        StudentEntity entity = mapper.map(request, StudentEntity.class);
*//*        StudentEntity entity = new StudentEntity();
        entity.setId(request.getId());
        entity.setFirstname(request.getFirstname());
        entity.setLastname(request.getLastname());
        entity.setDept(request.getDept());
        entity.setEmail(request.getEmail());
        entity.setSalary(request.getSalary());
        entity.setAddress(request.getAddress());
        entity.setState(request.getState());
        entity.setCountry(request.getCountry());
        studentResponse = mapper.map(entity, studentResponse.getClass());*//*
        return studentResponse;
    }
*/

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();

    }

    public Optional<StudentEntity> findById(int id) {
        return studentRepository.findById(id);
    }


    public String deleteById(int id) {
        studentRepository.deleteById(id);
        return "The ID is Deleted"+id;
    }

    public String updateById(StudentEntity entity) {
        studentRepository.save(entity);
        return "Updated";
    }


}

