package dev.ian.duit.domain.quiz.components;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import dev.ian.duit.domain.quiz.core.QuizItemResult;
import dev.ian.duit.domain.quiz.core.QuizResult;

@Mapper
public interface QuizQueryMapper {
  
  @Select("""
    with quiz_analytics as (
      select 
          qi.quiz_id,
          count(1) total_count,
          count(case is_correct when 'Y' then 1 end) total_correct
      from mcq_quiz_item qi 
      left join mcq_choices c on c.id = qi.choice_id
      group by qi.quiz_id
    )
    select 
        q.id                  as id,
        q.date_taken          as date_taken,
        q.time_taken          as time_taken,
        t.topic               as topic,
        qi_a.total_count      as total_items,
        qi_a.total_correct    as score,

        qi.id                 as res_id,

        mc_s.id               as res_mcs_id,
        mc_s.choice           as res_mcs_choice,
        mc_s.explanation      as res_mcs_explanation, 
        mc_s.is_correct       as res_mcs_is_correct,

        m.id                  as res_mc_id,
        t.topic               as res_mc_topic,
        m.question            as res_mc_question,

        mc.id                 as res_mc_c_id,
        mc.choice             as res_mc_c_choice,
        mc.explanation        as res_mc_c_explanation, 
        mc.is_correct         as res_mc_c_is_correct
    from mcq_quiz q
      join topic t on q.topic_id = t.id
      join quiz_analytics qi_a on qi_a.quiz_id = q.id

    left join mcq_quiz_item qi on qi.quiz_id = q.id
      join mcq m on m.id = qi.mcq_id
      join mcq_choices mc on mc.mcq_id = m.id
      left join mcq_choices mc_s on mc_s.id = qi.choice_id

    where t.topic = #{topic}
  """)
  @ResultMap("quizMap")
  List<QuizResult> getQuizResults(String topic);

  List<QuizItemResult> getQuizItemResults(String topic);
}
