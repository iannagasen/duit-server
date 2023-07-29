package dev.ian.duit.domain.question.dto;

import java.util.List;

import dev.ian.duit.domain.question.core.McqChoice;
import lombok.Data;

@Data
public class PutQuestionRequest {
  private Long id;
  private String updatedQuestion;
  private List<McqChoice> updatedChoices; 
}
