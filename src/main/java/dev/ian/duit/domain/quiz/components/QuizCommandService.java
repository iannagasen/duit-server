package dev.ian.duit.domain.quiz.components;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizCommandService {

  private final QuizCommandMapper quizCommandMapper;
  
  @Transactional
  public Long create(CreateQuizResultCommand quizCommand) {
    // create quiz result
    var quiz = quizCommand.toEntity();
    var rowsInserted = quizCommandMapper.create(quiz);
    if (rowsInserted == 0) throw new RuntimeException("No Quiz Created");

    // create quiz item result
    quiz.getResults().forEach(i -> {
      log.info("1 - " + quiz.getId());
      log.info("2 - " + i.getMcqId());
      log.info("3 - " + i.getSelectedChoiceId());
      quizCommandMapper.createQuizItem(quiz.getId(), i);
    });

    return quiz.getId();
  }

}
