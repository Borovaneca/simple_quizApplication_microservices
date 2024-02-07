package org.quizapp.questionservice.service.interfaces;


import org.quizapp.questionservice.model.entities.Question;

import java.util.List;

public interface QuestionService {

    List<Question> getAllQuestions();

    String addQuestion(Question question);

    Question deleteQuestionById(Long id);

    List<Question> generateQuestionsForQuiz();
}
