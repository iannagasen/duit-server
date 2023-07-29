package dev.ian.duit.core.quiz;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class QuizResult {
  private Long id;
  private LocalDateTime dateTaken;
  private Long timeTaken;
  private String topic;
  private List<QuizItemResult> results;

  // analytics
  private Long totalItems;
  private Long score;
}
