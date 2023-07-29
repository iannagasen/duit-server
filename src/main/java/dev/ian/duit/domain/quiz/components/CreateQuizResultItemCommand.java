package dev.ian.duit.domain.quiz.components;

import dev.ian.duit.domain.quiz.core.QuizItemResult;
import lombok.Data;

@Data
public class CreateQuizResultItemCommand {
  private Long mcqId;
  private Long choiceId;

  public QuizItemResult toEntity() {
    return new QuizItemResult(null, null, mcqId, choiceId);
  }
}
