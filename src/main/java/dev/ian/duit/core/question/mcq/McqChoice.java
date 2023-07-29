package dev.ian.duit.core.question.mcq;

import lombok.Data;

@Data
public class McqChoice {
  private Long id;
  private String choice;
  private String explanation;
  private String isCorrect;
}
