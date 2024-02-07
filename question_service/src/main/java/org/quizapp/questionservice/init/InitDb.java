package org.quizapp.questionservice.init;


import org.quizapp.questionservice.model.entities.Question;
import org.quizapp.questionservice.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InitDb implements CommandLineRunner {

    private final QuestionRepository questionRepository;

    @Autowired
    public InitDb(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (questionRepository.count() == 0) {
            List<Question> questions = List.of(Question.builder()
                            .question("Which is the capital of Bulgaria?")
                            .option1("Rome")
                            .option2("Dubai")
                            .option3("Sofia")
                            .option4("Athena")
                            .correctAnswer("option3")
                            .build(),
                    Question.builder()
                            .question("Which is the capital of Italy?")
                            .option1("Rome")
                            .option2("Dubai")
                            .option3("Sofia")
                            .option4("Athena")
                            .correctAnswer("option1")
                            .build(),
                    Question.builder()
                            .question("Which is the capital of Greece?")
                            .option1("Rome")
                            .option2("Dubai")
                            .option3("Sofia")
                            .option4("Athena")
                            .correctAnswer("option4")
                            .build(),
                    Question.builder()
                            .question("Which is the capital of Saudi Arabia?")
                            .option1("Rome")
                            .option2("Dubai")
                            .option3("Sofia")
                            .option4("Athena")
                            .correctAnswer("option2")
                            .build());
            questionRepository.saveAll(questions);
        }
    }
}
