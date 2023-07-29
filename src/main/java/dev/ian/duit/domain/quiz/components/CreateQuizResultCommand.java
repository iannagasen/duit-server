package dev.ian.duit.domain.quiz.components;

import java.time.LocalDateTime;
import java.util.List;

import dev.ian.duit.domain.quiz.core.QuizResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateQuizResultCommand {
  private LocalDateTime dateTaken;
  private Long timeTaken;
  private List<CreateQuizResultItemCommand> results;
  private String topic;

  public QuizResult toEntity() {
    var quiz = new QuizResult();
    quiz.setDateTaken(dateTaken);
    quiz.setTopic(topic);
    quiz.setResults(results.stream().map(CreateQuizResultItemCommand::toEntity).toList());
    return quiz;
  }
}
