package com.example.jdbc;
//账户持久层接口
import com.example.basicLayout.Question;

import java.util.List;

public interface IQuestionDao {
   Question findQuestionbyID(Integer id);

   List<Question> findQuestionbytype(String type);

   List<Question> findQuestionbySubject(String subject);

   void updateQuestion(Question questions);

   List<Question> getallQuestion();

   List<Question> findQuestionbyst(String subject,String type);
}
