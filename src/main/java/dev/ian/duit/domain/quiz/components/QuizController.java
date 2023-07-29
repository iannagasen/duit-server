package dev.ian.duit.domain.quiz.components;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ian.duit.domain.quiz.core.QuizResult;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/quiz")
public class QuizController {
  private final QuizCommandService quizCommandService;
  private final QuizQueryService quizQueryService;

  @PostMapping()
  public void post(@RequestBody CreateQuizResultCommand quiz) {
    quizCommandService.create(quiz);
  }

  @GetMapping("/analytics/mcq/{topic}")
  public List<QuizResult> getQuizAnalytics(@PathVariable String topic) {
    return quizQueryService.getQuizResults(topic);
  }
  
}