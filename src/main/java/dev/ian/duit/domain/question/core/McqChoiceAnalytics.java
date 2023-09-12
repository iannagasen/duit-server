package dev.ian.duit.domain.question.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class McqChoiceAnalytics {
  private Long choiceId;
  private Long timesChosen;
  private boolean correct;
}
