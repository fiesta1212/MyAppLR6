package ru.soloboev.MyAppLR6.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.soloboev.MyAppLR6.entity.Discipline;
import ru.soloboev.MyAppLR6.models.Result;
import ru.soloboev.MyAppLR6.service.DisciplineService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyControllerDiscipline {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public Result<List<Discipline>> allDisciplines() {
        List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
        return new Result<>(Result.SUCCESS_MESSAGE, allDisciplines);
    }

    @GetMapping("/disciplines/{id}")
    public Result<Discipline> getDiscipline(@PathVariable("id") int id) {
        Discipline discipline = disciplineService.getDiscipline(id);
        if (discipline != null) {
            return new Result<>(Result.SUCCESS_MESSAGE, discipline);
        } else {
            return new Result<>("Discipline not found", null);
        }
    }

    @PostMapping("/disciplines")
    public Result<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        Discipline savedDiscipline = disciplineService.saveDiscipline(discipline);
        return new Result<>(Result.SUCCESS_MESSAGE, savedDiscipline);
    }

    @PutMapping("/disciplines")
    public Result<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        Discipline updatedDiscipline = disciplineService.saveDiscipline(discipline);
        return new Result<>(Result.SUCCESS_MESSAGE, updatedDiscipline);
    }

    @DeleteMapping("/disciplines/{id}")
    public Result<Void> deleteDiscipline(@PathVariable("id") int id) {
        if (disciplineService.deleteDiscipline(id)) {
            return new Result<>(Result.SUCCESS_MESSAGE, null);
        } else {
            return new Result<>(Result.ERROR_MESSAGE, null);
        }
    }

    @ExceptionHandler(Exception.class)
    public Result<String> handleException(Exception e) {
        return new Result<>(Result.ERROR_MESSAGE, e.getMessage());
    }
}
