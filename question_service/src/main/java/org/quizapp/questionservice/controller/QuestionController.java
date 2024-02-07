package org.quizapp.questionservice.controller;


import org.quizapp.questionservice.model.entities.Question;
import org.quizapp.questionservice.service.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/api/questions")
    public ResponseEntity<?> getAllQuestions() {
        return ResponseEntity.ok().body(questionService.getAllQuestions());
    }

    @PostMapping("/api/add")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        return ResponseEntity.status(201).body(questionService.addQuestion(question));
    }

    @DeleteMapping("/api/delete/{id}")
    public ResponseEntity<?> deleteQuestion(@PathVariable Long id) {
        return new ResponseEntity<>(questionService.deleteQuestionById(id), HttpStatus.GONE);
    }

    @GetMapping("/api/generate")
    public ResponseEntity<List<Question>> generateQuestionsForQuiz() {
        List<Question> questions = questionService.generateQuestionsForQuiz();
        return ResponseEntity.status(200).body(questions);
    }
}
