package dev.ian.duit.domain.quiz.core;


import dev.ian.duit.domain.question.core.Mcq;
import dev.ian.duit.domain.question.core.McqChoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuizItemResult {
  private Long id;
  private Mcq mcq;
  private McqChoice selectedChoice;
}
