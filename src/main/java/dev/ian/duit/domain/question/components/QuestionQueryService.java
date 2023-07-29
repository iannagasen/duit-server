package dev.ian.duit.domain.question.components;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.ian.duit.domain.question.core.Mcq;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionQueryService {
  private final QuestionQueryMapper queryMapper;

  public List<Mcq> findAllMcqByTopic(String topic) {
    return queryMapper.findAllMcqByTopic(topic);
  }

  public Map<String, List<Mcq>> getMcqToTopic() {
    return queryMapper.findAllMcq()
        .stream()
        .collect(Collectors.groupingBy(Mcq::getTopic));
  }
}
