package ru.soloboev.MyAppLR6.dao;


import org.springframework.stereotype.Repository;
import ru.soloboev.MyAppLR6.entity.Student;

import java.util.List;

@Repository
public interface StudentDao{
    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudent(int id);

    void deleteStudent(int id);
}
