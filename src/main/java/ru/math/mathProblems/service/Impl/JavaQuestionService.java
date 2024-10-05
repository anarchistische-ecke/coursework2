package ru.math.mathProblems.service.Impl;

import org.springframework.stereotype.Service;
import ru.math.mathProblems.Exceptions.QuestionAlreadyExistsException;
import ru.math.mathProblems.Exceptions.QuestionDoesNotExistException;
import ru.math.mathProblems.Question;
import ru.math.mathProblems.service.QuestionService;

import java.util.*;
import java.util.stream.Collectors;



@Service
public class JavaQuestionService implements QuestionService {

    private final List<Question> questions = new ArrayList<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer ));
    }

    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question ;
    }

    @Override
    public Question remove (Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionDoesNotExistException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        var next = random.nextInt(questions.size() );
        return questions.get(next);
    }
}
