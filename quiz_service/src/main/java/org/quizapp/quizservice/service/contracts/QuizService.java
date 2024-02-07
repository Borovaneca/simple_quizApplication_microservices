package org.quizapp.quizservice.service.contracts;

import org.quizapp.quizservice.module.entities.Quiz;


public interface QuizService {

    Quiz generateQuiz(String title);
}
