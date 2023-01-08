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
public class JavaQuestionRepository implements QuestionRepository{
    private final Set<Question> questions = new HashSet<>();

    @PostConstruct
    private void init(){
        questions.add(new Question("Do you like ice-cream?", "Yes"));
        questions.add(new Question("Do you believe in unicorns?", "Maybe"));
        questions.add(new Question("Is the sky blue?", "Yes"));
        questions.add(new Question("Is the grass green?", "Yes"));
        questions.add(new Question("Is the ice cold?", "Yes"));
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
