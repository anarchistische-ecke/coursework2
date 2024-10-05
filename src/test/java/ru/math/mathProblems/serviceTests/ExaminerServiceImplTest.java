package ru.math.mathProblems.serviceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.math.mathProblems.Exceptions.NotEnoughQuestionsException;
import ru.math.mathProblems.Question;
import ru.math.mathProblems.service.Impl.ExaminerServiceImpl;
import ru.math.mathProblems.service.QuestionService;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private QuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetQuestionsSuccess() {
        // Мокаю getAll, чтобы метод возвращал только определенные вопросы
        when(questionService.getAll()).thenReturn(List.of(
                new Question("What is Java?", "A programming language"),
                new Question("What is Spring?", "A framework"),
                new Question("What is JUnit?", "A testing framework")
        ));

        when(questionService.getRandomQuestion())
                .thenReturn(new Question("What is Java?", "A programming language"))
                .thenReturn(new Question("What is Spring?", "A framework"));


        Set<Question> result = (Set<Question>) examinerService.getQuestions(2);

        assertEquals(2, result.size()); // проверяю корректное число возвращенных вопросов
    }

    @Test
    void testGetQuestionsThrowsNotEnoughQuestionsException() {
        when(questionService.getAll()).thenReturn(List.of(
                new Question("What is Java?", "A programming language")));

        assertThrows(NotEnoughQuestionsException.class, () -> examinerService.getQuestions(2));
    }
}
