package com.example.student.controller;


import com.example.student.model.StudentEntity;
import com.example.student.model.StudentRequest;
import com.example.student.model.StudentResponse;
import com.example.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/create")
    public ResponseEntity<String> createStudent(@RequestBody StudentRequest request) {
        return new ResponseEntity(service.create(request), HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody StudentRequest request) {
        return new ResponseEntity(service.add(request), HttpStatus.OK);
    }


    @GetMapping("/read")
    public ResponseEntity<List<StudentRequest>> getAllStudents(){
        return new ResponseEntity(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentRequest> getById(@RequestHeader int id){
        return new ResponseEntity(service.findById(id), HttpStatus.OK);
    }


    @PutMapping("/student")
    public String updateById(@RequestBody StudentEntity entity){
        return service.updateById(entity);
    }




    @DeleteMapping("/student/{id}")
    public String deleteById(@RequestParam int id){
        return service.deleteById(id);
    }


}
