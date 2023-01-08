package sky.pro.coursework03.service;

import org.springframework.stereotype.Service;
import sky.pro.coursework03.exception.BadRequestException;
import sky.pro.coursework03.model.Question;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final List<QuestionService> questionServices;
    private final UtilService utilService;

    public ExaminerServiceImpl(List<QuestionService> questionServices, UtilService utilService) {
        this.questionServices = questionServices;
        this.utilService = utilService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if(amount <=0 || calculateAmountOfQuestions() < amount){
            throw new BadRequestException("Некорректное число");
        }
        Set<Question> result = new HashSet<>();
        while(result.size() < amount){
            var serviceNumber = utilService.getRandomInt(questionServices.size());
            var questionService = questionServices.get(serviceNumber);
            result.add(questionService.getRandomQuestion());
        }

        return result;
    }

    private int calculateAmountOfQuestions(){
        return questionServices.stream()
                .mapToInt(e -> e.getAll().size())
                .sum();
    }

}
