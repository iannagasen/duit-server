package dev.ian.duit.domain.question.components;

import org.springframework.stereotype.Service;

import dev.ian.duit.domain.question.dto.PostQuestionRequest;
import dev.ian.duit.domain.question.dto.PutQuestionRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionCommandService {
  private final QuestionCommandMapper questionCommandMapper;

  public Long createMcq(PostQuestionRequest question) {
    // save mcq - saveMcq will now have an Id after insertion
    var savedMcq = question.toEntity();
    int rowsInserted = questionCommandMapper.saveMcq(savedMcq);
    if (rowsInserted == 0) throw new RuntimeException("Question not saved");

    // save choices
    savedMcq.getChoices().forEach(c -> 
      questionCommandMapper.saveChoice(c, savedMcq.getId())
    );

    return savedMcq.getId();
  }


  public void updateMcq(PutQuestionRequest question) {
    // update question
    questionCommandMapper.updateMcq(question.getId(), question.getUpdatedQuestion());
    question.getUpdatedChoices().forEach(questionCommandMapper::updateChoice);
  }
}
