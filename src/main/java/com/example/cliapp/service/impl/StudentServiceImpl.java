package com.example.cliapp.service.impl;

import com.example.cliapp.pojo.Student;
import com.example.cliapp.service.StudentService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final Gson gson;

    List<Student> studentList = new ArrayList<>() {{
        add(new Student(1, "Harry Potter", "Gryffindor"));
        add(new Student(2, "Hermione Granger", "Gryffindor"));
        add(new Student(3, "Ron Weasley", "Gryffindor"));
        add(new Student(4, "Luna Lovegood", "Ravenclaw"));
        add(new Student(5, "Draco Malfoy", "Slytherin"));
    }};

    @Override
    public String findById(Integer id) {
        Student foundStudent = studentList.stream()
                .filter(student -> student.id().equals(id))
                .findFirst()
                .orElse(null);
        return foundStudent == null ? "Student not found for given id: " + id : gson.toJson(foundStudent);
    }

    @Override
    public String findAll() {
        StringBuilder result = new StringBuilder();
        studentList.forEach(student -> {
            result.append(gson.toJson(student));
        });
        return result.toString();
    }
}
