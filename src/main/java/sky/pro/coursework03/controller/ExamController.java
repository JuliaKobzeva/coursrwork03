package sky.pro.coursework03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sky.pro.coursework03.model.Question;
import sky.pro.coursework03.service.ExaminerService;

import java.util.Collection;

@RestController
public class ExamController {
    ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("")
    public Collection<Question> getQuestions(int amount) {
        return null;
    }
}
