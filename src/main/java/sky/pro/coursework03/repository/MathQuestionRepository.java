package sky.pro.coursework03.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import sky.pro.coursework03.exception.BadRequestException;
import sky.pro.coursework03.exception.NotFoundException;
import sky.pro.coursework03.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository{
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init(){
        questions.add(new Question("1+1", "2"));
        questions.add(new Question("2+2", "4"));
        questions.add(new Question("3+3", "6"));
        questions.add(new Question("4+4", "8"));
        questions.add(new Question("5+5", "10"));
    }

    @Override
    public Question add(Question question) {
        if(question == null){
            throw new BadRequestException("Введите вопрос");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if(!questions.contains(question)){
            throw new NotFoundException("Вопрос не найден");
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
