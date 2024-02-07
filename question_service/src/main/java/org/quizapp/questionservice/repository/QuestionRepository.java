package org.quizapp.questionservice.repository;


import org.quizapp.questionservice.model.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {


    @Query(value = "select * from questions q order by RAND() limit 4", nativeQuery = true)
    List<Question> generateQuestionsForQuiz();
}
