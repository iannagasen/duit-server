package dev.ian.duit.core.question.mcq.command;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import dev.ian.duit.core.question.mcq.McqChoice;

@Mapper
public interface McqChoiceCommandMapper {

  @Insert("""
      INSERT INTO mcq_choices
      VALUES(null, #{id}, #{c.choice}, #{c.explanation}, #{c.isCorrect})
  """)
  @Options(useGeneratedKeys=true, keyProperty="c.id", keyColumn="id")
  int save(McqChoice c, Long id);

  @Update("""
      UPDATE mcq_choices
      SET choice = #{choice},
          explanation = #{explanation},
          is_correct = #{isCorrect}
      WHERE id = #{id}
  """)
  int update(McqChoice choice);
}
