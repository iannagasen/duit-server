package dev.ian.duit.core.topic.query;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import dev.ian.duit.core.topic.Topic;

@Mapper
public interface TopicQueryMapper {
  
  @Select("SELECT * FROM topic")
  List<Topic> getTopics();
}
