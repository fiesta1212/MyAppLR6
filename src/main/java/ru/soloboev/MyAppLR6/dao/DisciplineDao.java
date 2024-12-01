package ru.soloboev.MyAppLR6.dao;

import org.springframework.stereotype.Repository;
import ru.soloboev.MyAppLR6.entity.Discipline;

import java.util.List;

@Repository
public interface DisciplineDao {

    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);
}