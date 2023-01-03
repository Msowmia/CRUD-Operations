package com.example.student.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "student-list")
public class StudentEntity {
    @Id
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
