package dev.ian.duit.domain.question.core;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mcq {
  private Long id;
  private String topic;
  private String question;
  private Set<McqChoice> choices;
}

