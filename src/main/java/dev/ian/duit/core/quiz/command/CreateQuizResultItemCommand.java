package dev.ian.duit.core.quiz.command;

import dev.ian.duit.core.quiz.QuizItemResult;
import lombok.Data;

@Data
public class CreateQuizResultItemCommand {
  private Long mcqId;
  private Long choiceId;

  public QuizItemResult toEntity() {
    return new QuizItemResult(null, null, mcqId, choiceId);
  }
}
