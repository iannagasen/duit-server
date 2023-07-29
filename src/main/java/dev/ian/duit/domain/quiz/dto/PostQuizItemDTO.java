package dev.ian.duit.domain.quiz.dto;

import lombok.Data;

@Data
public class PostQuizItemDTO {
  private Long id;
  private Long quizId;
  private Long mcqId;
  private Long selectedChoiceId;
}
