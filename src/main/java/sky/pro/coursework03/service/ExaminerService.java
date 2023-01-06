package sky.pro.coursework03.service;

import sky.pro.coursework03.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
