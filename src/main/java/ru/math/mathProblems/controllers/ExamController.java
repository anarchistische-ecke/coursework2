package ru.math.mathProblems.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.math.mathProblems.Question;
import ru.math.mathProblems.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/random")
public class ExamController {
     private final ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping
    public Collection<Question> getRandomQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}
