package dev.ian.duit.core.question.mcq.command;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class McqCommandService {
  
  private final McqCommandMapper mcqCommandMapper;
  private final McqChoiceCommandMapper mcqChoiceCommandMapper;
  
  public Long create(CreateMcqCommand mcqCommand) {
    // save mcq - saveMcq will now have an Id after insertion
    var savedMcq = mcqCommand.toEntity();
    int rowsInserted = mcqCommandMapper.save(savedMcq);
    if (rowsInserted == 0) throw new RuntimeException("Question not saved");

    // save choices
    savedMcq.getChoices().forEach(c -> 
      mcqChoiceCommandMapper.save(c, savedMcq.getId())
    );

    return savedMcq.getId();
  }

  public void update(UpdateMcqCommand mcq) {
    mcqCommandMapper.update(mcq.getId(), mcq.getUpdatedQuestion());
    mcq.getUpdatedChoices().forEach(mcqChoiceCommandMapper::update);
  }
  
}
