package ru.math.mathProblems.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionDoesNotExistException extends RuntimeException {
    public QuestionDoesNotExistException() {
    }

    public QuestionDoesNotExistException(String message) {
        super(message);
    }

    public QuestionDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public QuestionDoesNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
