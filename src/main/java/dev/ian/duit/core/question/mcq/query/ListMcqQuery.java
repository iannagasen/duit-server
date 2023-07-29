package dev.ian.duit.core.question.mcq.query;

import java.util.Collections;
import java.util.List;

import dev.ian.duit.core.question.mcq.Mcq;

public class ListMcqQuery {

  private final List<Mcq> mcqs;

  public ListMcqQuery(List<Mcq> mcqs) {
    this.mcqs = mcqs;
  }

  public List<Mcq> getList() {
    return Collections.unmodifiableList(mcqs);
  }
}
