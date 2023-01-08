package sky.pro.coursework03.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.coursework03.exception.BadRequestException;
import sky.pro.coursework03.model.Question;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.anyInt;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @InjectMocks
    private ExaminerServiceImpl out;

    @Mock
    QuestionService questionService;
    @Mock
    UtilService utilService;

    @BeforeEach
    void setUp(){
        out = new ExaminerServiceImpl(List.of(questionService), utilService);
    }

    @Test
    void getQuestionsWithCorrectAmount(){
        Question expected = new Question("question", "answer");
        Collection<Question> expectedList = Set.of(expected);
        Mockito.when(utilService.getRandomInt(anyInt())).thenReturn(0);
        Mockito.when(questionService.getRandomQuestion()).thenReturn(expected);
        Mockito.when(questionService.getAll()).thenReturn(expectedList);
        Collection<Question> actualList = out.getQuestions(1);
        Assertions.assertEquals(actualList, expectedList);
    }

    @Test
    void getQuestionsWithIncorrectAmount(){
        Mockito.when(questionService.getAll()).thenReturn(Set.of(new Question("question", "answer")));
        Assertions.assertThrows(BadRequestException.class, () -> out.getQuestions(5));
    }

}
