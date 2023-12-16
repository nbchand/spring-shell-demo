package com.example.cliapp.command;

import com.example.cliapp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.command.annotation.Command;
import org.springframework.shell.command.annotation.Option;

@Command(group = "Student Group")
@RequiredArgsConstructor
public class StudentCommand {

    private final StudentService studentService;

    @Command(command = "studentById", description = "Finds student by id")
    public String getStudentById(@Option(required = true, description = "Student id", defaultValue = "1") Integer id) {
        return studentService.findById(id);
    }

    @Command(command = "studentList", description = "Finds student list")
    public String getStudentList() {
        return studentService.findAll();
    }
}
