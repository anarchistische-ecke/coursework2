package ru.math.mathProblems.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.math.mathProblems.Question;
import ru.math.mathProblems.service.Impl.JavaQuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaQuestionController {
    private final JavaQuestionService javaQuestionService;

    public JavaQuestionController(JavaQuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @GetMapping("/java/add")
    public Question add(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.add(question, answer);
    }

    @GetMapping("/java/remove")
    public Question remove(@RequestParam String question, @RequestParam String answer) {
        return javaQuestionService.remove(new Question(question, answer));
    }

    @GetMapping("/java")
    public Collection<Question> listAll() {
        return javaQuestionService.getAll();
    }

}
