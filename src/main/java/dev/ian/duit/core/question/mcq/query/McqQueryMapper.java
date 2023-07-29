package dev.ian.duit.core.question.mcq.query;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import dev.ian.duit.core.question.mcq.Mcq;
import dev.ian.duit.core.question.mcq.McqChoice;

@Mapper
public interface McqQueryMapper {

  @Select("""
      SELECT m.id, t.topic, m.question
      FROM mcq m
      JOIN topic t on t.id = m.topic_id
  """)
  @Results(id="mcq", value={
    @Result(javaType=Long.class, column="id", property="id", id=true),
    @Result(javaType=String.class, column="topic", property="topic"),
    @Result(javaType=String.class, column="question", property="question"),
    @Result(many=@Many(select="findMcqChoices"), javaType=Set.class, property="choices", column="id")
  })
  List<Mcq> findMcqs();
  
  @Select("""
      SELECT mc.id, mc.choice, mc.explanation, mc.is_correct
      FROM mcq_choices mc
      WHERE mc.mcq_id = #{mcqId}
  """)
  @Results(id="choiceMap", value={
    @Result(javaType=Long.class, column="id", property="id", id=true),
    @Result(javaType=String.class, column="choice", property="choice"),
    @Result(javaType=String.class, column="explanation", property="explanation"),
    @Result(javaType=String.class, column="is_correct", property="isCorrect")
  })
  Set<McqChoice> findMcqChoices(Long mcqId);

}
