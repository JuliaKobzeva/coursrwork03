package sky.pro.coursework03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.coursework03.model.Question;
import sky.pro.coursework03.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    QuestionService questionService;

    public JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/java/add")
    Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return null;
    }

    @GetMapping("java/remove")
    Collection<Question> getQuestions(){
        return null;
    }

    @GetMapping
    Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return null;
    }
}
