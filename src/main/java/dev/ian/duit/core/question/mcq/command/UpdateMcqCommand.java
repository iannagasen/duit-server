package dev.ian.duit.core.question.mcq.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import dev.ian.duit.core.question.mcq.McqChoice;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UpdateMcqCommand {
  private Long id;
  private String updatedQuestion;
  private List<McqChoice> updatedChoices; 
  
  public List<McqChoice> getUpdatedChoices() {
    return Objects.requireNonNullElse(updatedChoices, new ArrayList<>());
  }
}
