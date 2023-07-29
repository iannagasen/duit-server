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
    select 
        m.id          as id,
        t.topic       as topic,
        m.question    as question,
        c.id          as c_id,
        c.choice      as c_choice,
        c.explanation as c_explanation,
        c.is_correct  as c_is_correct
    from mcq m
        join topic t on t.id = m.topic_id
        join mcq_choices c on c.mcq_id = m.id
    where t.topic = #{topic}
  """)
  @ResultMap("mcqMap")
  List<Mcq> findAllMcqByTopic(String topic);


  @Select("""
    select 
        m.id          as id,
        t.topic       as topic,
        m.question    as question,
        c.id          as c_id,
        c.choice      as c_choice,
        c.explanation as c_explanation,
        c.is_correct  as c_is_correct
    from mcq m
        join topic t on t.id = m.topic_id
        join mcq_choices c on c.mcq_id = m.id
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
  
}
