package ru.soloboev.MyAppLR6.service;

import org.springframework.stereotype.Service;
import ru.soloboev.MyAppLR6.entity.Student;

import java.util.List;

@Service
public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    boolean deleteStudent(int id);
}
