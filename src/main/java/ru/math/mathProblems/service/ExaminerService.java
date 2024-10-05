package ru.math.mathProblems.service;

import ru.math.mathProblems.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
