package sky.pro.coursework03.repository;

import sky.pro.coursework03.model.Question;

import java.util.Collection;

public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question);
    Collection<Question> getAll();

}
