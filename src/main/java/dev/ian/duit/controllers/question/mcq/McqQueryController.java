package dev.ian.duit.controllers.question.mcq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ian.duit.core.question.mcq.query.ListMcqQuery;
import dev.ian.duit.core.question.mcq.query.McqQueryService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question/mcq")
public class McqQueryController {
  
  private final McqQueryService mcqQueryService;

  @GetMapping
  public ListMcqQuery getMcqs() {
    return mcqQueryService.findMcqs();
  }
}
