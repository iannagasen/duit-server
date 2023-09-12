package dev.ian.duit.domain.question.core;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class McqAnalytics {
  private Long mcqId;
  private Long timesTaken;
  private Long timesCorrect;
  private List<McqChoiceAnalytics> choiceAnalytics;
}
