package dev.ian.duit.core.question.mcq.command;

import java.util.Set;
import java.util.stream.Collectors;

import dev.ian.duit.core.question.mcq.Mcq;
import dev.ian.duit.core.question.mcq.McqChoice;
import lombok.Data;

@Data
public class CreateMcqCommand {
  private String topic;
  private String question;
  private Set<CreateChoicesCommand> choices;

  public Mcq toEntity() {
    var mcq = new Mcq();
    var ch = choices.stream()
        .map(CreateChoicesCommand::toEntity)
        .collect(Collectors.toSet());
    mcq.setTopic(topic);
    mcq.setQuestion(question);
    mcq.setChoices(ch);
    return mcq;
  } 
}
