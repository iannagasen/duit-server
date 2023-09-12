package dev.ian.duit.domain.question.dto;

import dev.ian.duit.domain.question.core.McqChoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostQuestionChoiceDTO {
  private String choice;
  private String explanation;
  private String isCorrect;

  public McqChoice toEntity() {
    var mcqChoice = new McqChoice();
    mcqChoice.setChoice(choice);
    mcqChoice.setExplanation(explanation);
    mcqChoice.setIsCorrect(isCorrect);
    return mcqChoice;
  }
}
