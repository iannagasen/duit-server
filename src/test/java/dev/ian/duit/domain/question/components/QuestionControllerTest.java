package dev.ian.duit.domain.question.components;


import java.util.Set;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import dev.ian.duit.domain.question.dto.PostQuestionChoiceDTO;
import dev.ian.duit.domain.question.dto.PostQuestionRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionControllerTest {

  @Autowired private MockMvc mvc;
  @Autowired private ObjectMapper mapper;

  @Test
  void testGetQuestionResponse() throws Exception {
    var mcqTopic = "AWS";
    mvc.perform(
        get("/question/mcq/" + mcqTopic)
          .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }

  @Test
  void testCreateMcq() throws Exception {
    var mcqTopic = "AWS";
    var req = PostQuestionRequest.builder()
      .topic(mcqTopic)
      .question("What is JUnit")
      .choices(Set.of(
        new PostQuestionChoiceDTO("a unit testing library", null, null),
        new PostQuestionChoiceDTO("a ORM library", null, null),
        new PostQuestionChoiceDTO("a frontend library", null, "Y")))
      .build();
    String reqJSON = mapper.writeValueAsString(req);

    mvc.perform(
        post("/question/mcq")
          .content(reqJSON)
          .contentType(MediaType.APPLICATION_JSON)
          .accept(MediaType.APPLICATION_JSON))
      .andExpect(status().isOk());
  }
}
