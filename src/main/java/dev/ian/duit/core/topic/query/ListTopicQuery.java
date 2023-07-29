package dev.ian.duit.core.topic.query;

import java.util.List;

import dev.ian.duit.core.topic.Topic;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ListTopicQuery {
  private List<Topic> topics;
}
