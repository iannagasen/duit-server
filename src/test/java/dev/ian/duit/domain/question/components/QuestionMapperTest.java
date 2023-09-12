package dev.ian.duit.domain.question.components;


import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

@MybatisTest
// H2 embedded can be used instead, since it does not require any dev installation
// @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class QuestionMapperTest { // unit test for QuestionQueryMapper and QuestionCommandMapper

  @Autowired private QuestionCommandMapper questionCommandMapper;

  // @Test
  // void questionCommandMapper_saveOneMcq_returnGeneratedId() {

  //   // Arrange
  //   var mcq = Mcq.builder()
  //     .topic("TESTING")
  //     .question("How to test Mybatis")
  //     .build();

  //   // Act
  //   int rowsInserted = questionCommandMapper.saveMcq(mcq);

  //   // Assert
  //   assertEquals(1, rowsInserted, "Rows Inserted must be 1");
  //   assertNotNull(mcq.getId(), "Generated Id must not be null");
  // }

}