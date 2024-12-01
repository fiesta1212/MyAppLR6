package ru.soloboev.MyAppLR6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.soloboev.MyAppLR6.entity.Student;
import ru.soloboev.MyAppLR6.models.Result;
import ru.soloboev.MyAppLR6.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public Result<List<Student>> allStudents() {
        List<Student> allStudents = studentService.getAllStudents();
        return new Result<>(Result.SUCCESS_MESSAGE, allStudents);
    }

    @GetMapping("/students/{id}")
    public Result<Student> getStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student != null) {
            return new Result<>(Result.SUCCESS_MESSAGE, student);
        } else {
            return new Result<>("Student not found", null);
        }
    }

    @PostMapping("/students")
    public Result<Student> saveStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new Result<>(Result.SUCCESS_MESSAGE, savedStudent);
    }

    @PutMapping("/students")
    public Result<Student> updateStudent(@RequestBody Student student) {
        Student updatedStudent = studentService.saveStudent(student);
        return new Result<>(Result.SUCCESS_MESSAGE, updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public Result<Void> deleteStudent(@PathVariable("id") int id) {
        if ((studentService.deleteStudent(id))) {
            return new Result<>(Result.SUCCESS_MESSAGE, null);
        } else {
            return new Result<> (Result.ERROR_MESSAGE, null);
        }
    }
    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return new Result<>(Result.ERROR_MESSAGE, e.getMessage());
    }
}
