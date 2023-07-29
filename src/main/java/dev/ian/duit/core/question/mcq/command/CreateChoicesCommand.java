package dev.ian.duit.core.question.mcq.command;

import dev.ian.duit.core.question.mcq.McqChoice;
import lombok.Data;

@Data
public class CreateChoicesCommand {
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
