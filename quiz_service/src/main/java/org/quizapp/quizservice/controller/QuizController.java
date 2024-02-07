package org.quizapp.quizservice.controller;

import org.quizapp.quizservice.service.contracts.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }


    @PostMapping("/api/generate/{title}")
    public ResponseEntity<?> generateQuiz(@PathVariable String title) {
        return ResponseEntity.status(201).body(quizService.generateQuiz(title));
    }
}
