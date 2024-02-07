package org.quizapp.quizservice.feign;

import org.quizapp.quizservice.module.entities.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("/api/generate")
    ResponseEntity<List<Question>> generateQuestionsForQuiz();

}
