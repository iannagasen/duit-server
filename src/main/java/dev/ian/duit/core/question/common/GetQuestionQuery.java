package dev.ian.duit.core.question.common;

import dev.ian.duit.core.question.mcq.query.GetMcqQuery;
import dev.ian.duit.core.question.mcq.query.ListMcqQuery;
import dev.ian.duit.core.topic.query.ListTopicQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetQuestionQuery {
  private ListTopicQuery topics;
  private ListMcqQuery mcqs;
}
