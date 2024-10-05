package ru.math.mathProblems.serviceTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.math.mathProblems.Exceptions.QuestionAlreadyExistsException;
import ru.math.mathProblems.Exceptions.QuestionDoesNotExistException;
import ru.math.mathProblems.Question;
import ru.math.mathProblems.service.Impl.JavaQuestionService;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class JavaQuestionServiceTest {

    private JavaQuestionService javaQuestionService;

    @BeforeEach
    void setUp() {
        javaQuestionService = new JavaQuestionService();
    }

    @Test
    void testAddNewQuestion() {
        Question question = new Question("What is Java?", "A programming language");

        Question result = javaQuestionService.add("What is Java?", "A programming language");

        assertEquals(question, result);
        assertTrue(javaQuestionService.getAll().contains(question));
    }

    @Test
    void testAddDuplicateQuestionThrowsException() {
        Question question = new Question("What is Java?", "A programming language");
        javaQuestionService.add(question);

        assertThrows(QuestionAlreadyExistsException.class, () -> javaQuestionService.add(question));
    }

    @Test
    void testRemoveExistingQuestion() {
        Question question = new Question("What is Java?", "A programming language");
        javaQuestionService.add(question);

        Question result = javaQuestionService.remove(question);

        assertEquals(question, result);
        assertFalse(javaQuestionService.getAll().contains(question));
    }

    @Test
    void testRemoveNonExistentQuestionThrowsException() {
        Question question = new Question("What is Python?", "A programming language");

        assertThrows(QuestionDoesNotExistException.class, () -> javaQuestionService.remove(question));
    }

    @Test
    void testGetAllQuestions() {
        Question question1 = new Question("What is Java?", "A programming language");
        Question question2 = new Question("What is Spring?", "A framework");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        List<Question> allQuestions = List.copyOf(javaQuestionService.getAll());

        assertEquals(2, allQuestions.size());
        assertTrue(allQuestions.contains(question1));
        assertTrue(allQuestions.contains(question2));
    }

    @Test
    void testGetRandomQuestion() {
        Question question1 = new Question("What is Java?", "A programming language");
        Question question2 = new Question("What is Spring?", "A framework");
        javaQuestionService.add(question1);
        javaQuestionService.add(question2);

        Question randomQuestion = javaQuestionService.getRandomQuestion();

        assertNotNull(randomQuestion);
        assertTrue(javaQuestionService.getAll().contains(randomQuestion));
    }
}

