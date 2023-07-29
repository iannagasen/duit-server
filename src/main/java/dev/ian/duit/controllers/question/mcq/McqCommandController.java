package dev.ian.duit.controllers.question.mcq;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ian.duit.core.question.mcq.command.CreateMcqCommand;
import dev.ian.duit.core.question.mcq.command.McqCommandService;
import dev.ian.duit.core.question.mcq.command.UpdateMcqCommand;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/question/mcq")
public class McqCommandController {
  
  private final McqCommandService mcqCommandService;

  @PostMapping
  public Long createMcq(@RequestBody CreateMcqCommand mcq) {
    return mcqCommandService.create(mcq);
  }

  @PutMapping
  public void updateMcq(@RequestBody UpdateMcqCommand mcq) {
    mcqCommandService.update(mcq);
  }
}
