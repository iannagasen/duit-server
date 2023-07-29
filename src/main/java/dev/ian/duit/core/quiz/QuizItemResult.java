package dev.ian.duit.core.quiz;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizItemResult {
  private Long id;
  private Long quizId;
  private Long mcqId;
  private Long selectedChoiceId;
}
