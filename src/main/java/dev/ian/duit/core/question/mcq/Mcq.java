package dev.ian.duit.core.question.mcq;

import java.util.Set;

import lombok.Data;

@Data
public class Mcq {
  private Long id;
  private String topic;
  private String question;
  private Set<McqChoice> choices;
}
