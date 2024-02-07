package org.quizapp.questionservice.service.implementations;


import org.quizapp.questionservice.model.entities.Question;
import org.quizapp.questionservice.repository.QuestionRepository;
import org.quizapp.questionservice.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public String addQuestion(Question question) {
        questionRepository.save(question);
        return "Successfully added question!";
    }

    @Override
    public Question deleteQuestionById(Long id) {
        Optional<Question> question = questionRepository.findById(id);
        question.ifPresent(questionRepository::delete);
        return question.get();
    }

    @Override
    public List<Question> generateQuestionsForQuiz() {
        return questionRepository.generateQuestionsForQuiz();
    }
}
