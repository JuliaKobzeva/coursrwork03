package sky.pro.coursework03.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import sky.pro.coursework03.exception.BadRequestException;
import sky.pro.coursework03.model.Question;
import sky.pro.coursework03.repository.QuestionRepository;

import java.util.Collection;

@Service
public class MathQuestionService implements QuestionService{
    private final QuestionRepository questionRepository;
    private final UtilService utilService;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository questionRepository, UtilService utilService) {
        this.questionRepository = questionRepository;
        this.utilService = utilService;
    }

    @Override
    public Question add(String question, String answer) {
        if(question.isEmpty() || question.isBlank()){
            throw new BadRequestException("Введите вопрос");
        }
        if(answer.isEmpty() || answer.isBlank()){
            throw new BadRequestException("Введите ответ");
        }
        return questionRepository.add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        return utilService.getRandomQuestion(questionRepository.getAll());
    }
}
