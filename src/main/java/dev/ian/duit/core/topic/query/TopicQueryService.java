package dev.ian.duit.core.topic.query;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TopicQueryService {
  private final TopicQueryMapper topicQueryMapper;

  public ListTopicQuery getAll() {
    var list = topicQueryMapper.getTopics();
    return new ListTopicQuery(list);
  }
}
