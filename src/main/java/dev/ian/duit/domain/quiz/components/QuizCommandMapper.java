package dev.ian.duit.domain.quiz.components;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import dev.ian.duit.domain.quiz.core.QuizItemResult;
import dev.ian.duit.domain.quiz.core.QuizResult;
import dev.ian.duit.domain.quiz.dto.PostQuizItemDTO;

@Mapper
public interface QuizCommandMapper {

  @Insert("""
    insert into mcq_quiz
    values (
      null,
      (select id from topic where topic = #{topic}),
      #{dateTaken},
      #{timeTaken}
    )
  """)
  @Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
  int create(QuizResult quizResult);


  @Insert("""
    insert into mcq_quiz_item
    values (
      null,
      #{quizId},
      #{item.mcqId},
      #{item.selectedChoiceId}
    )    
  """)
  @Options(useGeneratedKeys=true, keyColumn="id", keyProperty="item.id")
  int createQuizItem(Long quizId, PostQuizItemDTO item);
}
