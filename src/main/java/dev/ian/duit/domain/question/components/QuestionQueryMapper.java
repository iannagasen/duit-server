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
import dev.ian.duit.domain.question.core.McqAnalytics;
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


  @Select("""
      with question_stat as (
        select qzi.mcq_id
             , count(1) as times_taken
             , count(if(mc.is_correct = 'Y', 1, NULL)) times_correct 
          from mcq_quiz_item qzi
          left join mcq_choices mc on mc.id = qzi.choice_id
         group by qzi.mcq_id
      ), choice_stat as (
        select m.id mcq_id
             , mc.id choice_id
             , mc.is_correct
             , count(1) times_chosen
          from mcq m
          join mcq_choices mc on mc.mcq_id = m.id
          join mcq_quiz_item qzi on qzi.choice_id = mc.id
           and qzi.mcq_id = m.id
         group by m.id
             , mc.id
             , mc.is_correct
      )
      select qs.mcq_id
           , qs.times_taken
           , qs.times_correct
           , cs.choice_id       as c_choice_id
           , cs.times_chosen    as c_times_chosen
           , cs.is_correct      as c_is_correct
        from question_stat qs
        left join choice_stat cs on qs.mcq_id = cs.mcq_id
       where qs.mcq_id = #{mcqId}
  """)
  @ResultMap("mcqAnalyticsMap")
  McqAnalytics getMcqAnalytics(Long mcqId);
  
}
