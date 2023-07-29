package dev.ian.duit.domain.question.core;

import lombok.Data;

@Data
public class McqChoice {
  private Long id;
  private String choice;
  private String explanation;
  private String isCorrect;
}

