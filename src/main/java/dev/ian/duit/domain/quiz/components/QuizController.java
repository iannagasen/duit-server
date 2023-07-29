package dev.ian.duit.domain.quiz.components;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/quiz")
public class QuizController {
  
  private final QuizCommandService quizCommandService;

  @PostMapping()
  public void post(@RequestBody CreateQuizResultCommand quiz) {
    quizCommandService.create(quiz);
  }

  @GetMapping("/analytics/mcq/{topic}")
  public void getQuizAnalytics(@PathVariable String topic) {
    
  }
  
}