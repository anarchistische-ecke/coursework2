package ru.math.mathProblems.service.Impl;

import org.springframework.stereotype.Service;
import ru.math.mathProblems.Exceptions.NotEnoughQuestionsException;
import ru.math.mathProblems.Question;
import ru.math.mathProblems.service.ExaminerService;
import ru.math.mathProblems.service.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (questionService.getAll().size() < amount) {
            throw new NotEnoughQuestionsException();
        }
        Set<Question> set = new HashSet<>();
        while (set.size() < amount) {
            set.add(questionService.getRandomQuestion());
        }
        return set;
    }
}
