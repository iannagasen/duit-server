package dev.ian.duit.controllers.quiz;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ian.duit.core.quiz.command.QuizCommandService;
import dev.ian.duit.core.quiz.command.CreateQuizResultCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/quiz")
public class QuizCommandController {
  
  private final QuizCommandService quizCommandService;

  @PostMapping()
  public void post(@RequestBody CreateQuizResultCommand quiz) {
    quizCommandService.create(quiz);
  }

  @GetMapping("/analytics/mcq/{topic}")
  public void getQuizAnalytics(@PathVariable String topic) {
    
  }
  
}
