package dev.ian.duit.domain.question.components;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import dev.ian.duit.domain.question.core.Mcq;
import dev.ian.duit.domain.question.core.McqChoice;


@Mapper
public interface QuestionCommandMapper {

  @Insert("""
      insert into mcq 
      values(
        null, 
        (select t.id from topic t where t.topic = #{topic}),
        #{question})
  """)
  @Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
  int saveMcq(Mcq mcq);

  @Update("""
      update mcq
      set question = #{updatedQuestion}
      where id = #{id}
  """)
  int updateMcq(Long id, String updatedQuestion);


  @Insert("""
      insert into mcq_choices
      values(null, #{id}, #{c.choice}, #{c.explanation}, #{c.isCorrect})
  """)
  @Options(useGeneratedKeys=true, keyProperty="c.id", keyColumn="id")
  int saveChoice(McqChoice c, Long id);

  @Update("""
      update mcq_choices
      set choice = #{choice},
        explanation = #{explanation},
        is_correct = #{isCorrect}
      where id = #{id}
  """)
  int updateChoice(McqChoice choice);
}
