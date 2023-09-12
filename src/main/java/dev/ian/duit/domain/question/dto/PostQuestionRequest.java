package dev.ian.duit.domain.question.dto;

import java.util.Set;
import java.util.stream.Collectors;

import dev.ian.duit.domain.question.core.Mcq;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostQuestionRequest {
  private String topic;
  private String question;
  private Set<PostQuestionChoiceDTO> choices;

  public Mcq toEntity() {
    var mcq = new Mcq();
    var ch = choices.stream()
        .map(PostQuestionChoiceDTO::toEntity)
        .collect(Collectors.toSet());
    mcq.setTopic(topic);
    mcq.setQuestion(question);
    mcq.setChoices(ch);
    return mcq;
  } 
}
