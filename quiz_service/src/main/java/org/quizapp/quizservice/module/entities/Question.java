package org.quizapp.quizservice.module.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Question {

  private Long id;

   private String question;

    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String correctAnswer;

}
