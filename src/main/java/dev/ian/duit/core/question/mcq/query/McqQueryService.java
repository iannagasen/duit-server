package dev.ian.duit.core.question.mcq.query;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class McqQueryService {
  
  private final McqQueryMapper mcqQueryMapper;

  public ListMcqQuery findMcqs() {
    var mcqs = mcqQueryMapper.findMcqs();
    return new ListMcqQuery(mcqs);
  }
}
