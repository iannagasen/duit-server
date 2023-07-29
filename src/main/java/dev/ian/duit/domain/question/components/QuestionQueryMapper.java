package dev.ian.duit.domain.question.components;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import dev.ian.duit.domain.question.core.Mcq;
import dev.ian.duit.domain.question.core.McqChoice;

@Mapper
public interface QuestionQueryMapper {


  @Select("""
      select m.id, t.topic, m.question
      from mcq m
      join topic t on t.id = m.topic_id
      where t.topic = #{topic}
  """)
  @Results(id="mcqMap", value={
    @Result(javaType=Long.class, column="id", property="id", id=true),
    @Result(javaType=String.class, column="topic", property="topic"),
    @Result(javaType=String.class, column="question", property="question"),
    @Result(many=@Many(select="findMcqChoices"), javaType=Set.class, property="choices", column="id")
  })
  List<Mcq> findAllMcqByTopic(String topic);


  @Select("""
      select m.id, t.topic, m.question
      from mcq m
      join topic t on t.id = m.topic_id
  """)
  @ResultMap("mcqMap")
  List<Mcq> findAllMcq();
  
  // TODO: still under development
  // Mybatis cant use Map<String, Collection>
  // but it can use Map<String, MyObject>
  // consider creating an object rather than using List<Mcq>
  @Select("""
      select m.id, t.topic, m.question
      from mcq m
      join topic t on t.id = m.topic_id
  """)
  @ResultMap("mcqMap")
  @MapKey("topic")
  Map<String, List<Mcq>> getMcqToTopic();


  @Select("""
      select mc.id, mc.choice, mc.explanation, mc.is_correct
      from mcq_choices mc
      where mc.mcq_id = #{mcqId}
  """)
  @Results(id="choiceMap", value={
    @Result(javaType=Long.class, column="id", property="id", id=true),
    @Result(javaType=String.class, column="choice", property="choice"),
    @Result(javaType=String.class, column="explanation", property="explanation"),
    @Result(javaType=String.class, column="is_correct", property="isCorrect")
  })
  Set<McqChoice> findMcqChoices(Long mcqId);
}
