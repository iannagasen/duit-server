package dev.ian.duit.controllers.question;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ian.duit.core.question.common.GetQuestionQuery;
import dev.ian.duit.core.question.mcq.query.McqQueryService;
import dev.ian.duit.core.topic.query.TopicQueryService;
import dev.ian.duit.core.util.Origins;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
@CrossOrigin(origins = { Origins.LOCAL })
public class QuestionQueryController {
  private final McqQueryService mcqQueryService;
  private final TopicQueryService topicQueryService;

  @GetMapping
  public GetQuestionQuery get() {
    var mcqs = mcqQueryService.findMcqs();
    var topics = topicQueryService.getAll();
    return new GetQuestionQuery(topics, mcqs);
  } 
}
