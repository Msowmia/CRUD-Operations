package com.example.student.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    public int id;
    public String firstname;
    public String lastname;
    public String dept;
    public String email;
    public float salary;
    public String address;
    public String state;
    public String country;


}
