package ru.soloboev.MyAppLR6.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.soloboev.MyAppLR6.dao.StudentDao;
import ru.soloboev.MyAppLR6.entity.Student;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    @Transactional
    public Student getStudent(int id) {
        return studentDao.getStudent(id);
    }

    @Override
    @Transactional
    public boolean deleteStudent(int id) {
        if (studentDao.getStudent(id) != null) {
            studentDao.deleteStudent(id); // Удаляем студента
            return true; // Успешное удаление
        }
        return false; // Студент не найден
    }
}