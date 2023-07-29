package dev.ian.duit.domain.quiz.components;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ian.duit.domain.quiz.core.QuizResult;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizQueryService {
  private final QuizQueryMapper quizQueryMapper;

  public List<QuizResult> getQuizResults(String topic) {
    return quizQueryMapper.getQuizResults(topic);
  }
}
