package org.quizapp.quizservice.service.implementations;

import com.google.gson.Gson;
import org.quizapp.quizservice.feign.QuizInterface;
import org.quizapp.quizservice.module.entities.Question;
import org.quizapp.quizservice.module.entities.Quiz;
import org.quizapp.quizservice.repository.QuizRepository;
import org.quizapp.quizservice.service.contracts.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuizInterface quizInterface;


    @Override
    public Quiz generateQuiz(String title) {
        List<Question> body = quizInterface.generateQuestionsForQuiz().getBody();
        Quiz quiz = Quiz.builder()
                .title(title)
                .questions(Objects.requireNonNull(body).stream().map(Question::toString).collect(Collectors.toList()))
                .build();
        quizRepository.save(quiz);
        return quiz;
    }
}
