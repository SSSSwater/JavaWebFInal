package com.example.springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionController {

//    aa
//    @ResponseBody
//    @RequestMapping(value = "/tiku",method = RequestMethod.GET)
//    public Object getQuestion(HttpServletRequest request, Model model){
//        List<Question> questions=new ArrayList<>();
//        questions.add(new Question(1,"Chinese","single"));
//        questions.add(new Question(2,"Chinese","multiple"));
//        questions.add(new Question(3,"Math","single"));
//        questions.add(new Question(4,"Math","judge"));
//        questions.add(new Question(5,"Math","multiple"));
//
//        for(Question q:questions){
//            System.out.println(q);
//        }
//
//        List<Question> questionList=new ArrayList<>();
//        int id=Integer.parseInt(request.getParameter("id"));
//        String subject=request.getParameter("subject");
//        String type=request.getParameter("type");
//        for(Question q:questions){
//            if(!(id==0||subject==null||type==null)){
//                if(q.getId()==id||q.getType()==type||q.getSubject()==subject){
//                    questionList.add(q);
//                }
//            }
//            if(id!=0){
//                if(subject!=null){
//                    if(type!=null){
//                        if(q.getId()==id&&q.getSubject()==subject&&q.getType()==type){
//                            questionList.add(q);
//                        }
//                    }else if(q.getId()==id&&q.getSubject()==subject){
//                        questionList.add(q);
//                    }
//                }else{
//                    if(type!=null){
//                        if(q.getId()==id&&q.getType()==type){
//                            questionList.add(q);
//                        }
//                    }else if(q.getId()==id){
//                        questionList.add(q);
//                    }
//                }
//            }else{
//                if(type!=null){
//                    if(subject!=null){
//                        if(q.getSubject()==subject&&q.getType()==type){
//                            questionList.add(q);
//                        }
//                    }else if(q.getType()==type){
//                        questionList.add(q);
//                    }
//                }else if(q.getSubject()==subject){
//                    questionList.add(q);
//                }
//            }
//        }


//        return questions;
//    }

}
