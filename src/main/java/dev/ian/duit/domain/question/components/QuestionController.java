package dev.ian.duit.domain.question.components;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ian.duit.domain.question.core.Mcq;
import dev.ian.duit.domain.question.core.McqAnalytics;
import dev.ian.duit.domain.question.dto.PostQuestionRequest;
import dev.ian.duit.domain.question.dto.PutQuestionRequest;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/question")
public class QuestionController {
  private final QuestionCommandService questionCommandService;
  private final QuestionQueryService questionQueryService;

  // TODO: make this "/mcq/topic/{topic}"
  @GetMapping("/mcq/{topic}")
  public List<Mcq> getQuestionResponse(@PathVariable String topic) {
    return questionQueryService.findAllMcqByTopic(topic);
  }

  @GetMapping("/mcq")
  public Map<String, List<Mcq>> getQuestionMap() {
    return questionQueryService.getMcqToTopic();
  }

  @PostMapping("/mcq")
  public Long createMcq(@RequestBody PostQuestionRequest question) {
    return questionCommandService.createMcq(question);
  }

  @PutMapping("/mcq")
  public void updateMcq(@RequestBody PutQuestionRequest question) {
    questionCommandService.updateMcq(question);
  }

  @GetMapping("/mcq/{id}/analytics")
  public McqAnalytics getQuestionAnalytics(@PathVariable Long id) {
    return questionQueryService.getQuestionAnalytics(id);
  }
}
