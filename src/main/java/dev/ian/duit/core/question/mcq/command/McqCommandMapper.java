package dev.ian.duit.core.question.mcq.command;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

import dev.ian.duit.core.question.mcq.Mcq;

@Mapper
public interface McqCommandMapper {

  @Insert("""
    INSERT INTO mcq 
    VALUES(
      null, 
      (SELECT t.id FROM topic t where t.topic = #{topic}),
      #{question})
  """)
  @Options(useGeneratedKeys=true, keyColumn="id", keyProperty="id")
  int save(Mcq mcq);

  @Update("""
    UPDATE mcq
    SET question = #{updatedQuestion}
    WHERE id = #{id}
  """)
  int update(Long id, String updatedQuestion);
  
}
