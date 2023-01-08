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
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService javaQuestionService) {
        this.questionService = javaQuestionService;
    }

    @GetMapping("/java/add")
    Question addQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return questionService.add(question, answer);
    }

    @GetMapping
    Collection<Question> getQuestions(){
        return questionService.getAll();
    }

    @GetMapping("java/remove")
    Question removeQuestion(@RequestParam("question") String question, @RequestParam("answer") String answer){
        return questionService.remove(new Question(question, answer));
    }
}
