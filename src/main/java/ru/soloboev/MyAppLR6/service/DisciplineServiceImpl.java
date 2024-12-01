package ru.soloboev.MyAppLR6.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.soloboev.MyAppLR6.dao.DisciplineDao;
import ru.soloboev.MyAppLR6.entity.Discipline;

import java.util.List;


@Service
public class DisciplineServiceImpl implements  DisciplineService{

    @Autowired
    private DisciplineDao disciplineDao;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() { return disciplineDao.getAllDisciplines(); }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) { return disciplineDao.saveDiscipline(discipline); }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) { return disciplineDao.getDiscipline(id); }

    @Override
    @Transactional
    public boolean deleteDiscipline(int id) {
        if (disciplineDao.getDiscipline(id) != null) {
            disciplineDao.deleteDiscipline(id); // Удаляем дисциплину
            return true; // Успешное удаление
        }
        return false; // Дисциплина не найдена
    }
}
