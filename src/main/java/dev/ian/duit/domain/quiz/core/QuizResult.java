package dev.ian.duit.domain.quiz.core;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("QuizResult")
public class QuizResult {
  private Long id;
  private LocalDateTime dateTaken;
  private Long timeTaken;
  private String topic;
  
  // analytics
  private Long totalItems;
  private Long score;

  // could be lazy loaded
  private List<QuizItemResult> results;
}
