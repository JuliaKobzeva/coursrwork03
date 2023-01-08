package sky.pro.coursework03.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.coursework03.exception.BadRequestException;
import sky.pro.coursework03.model.Question;
import sky.pro.coursework03.repository.QuestionRepository;

import java.util.Collection;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @InjectMocks
    private MathQuestionService out;

    @Mock
    private QuestionRepository questionRepository;
    @Mock
    private UtilService utilService;

    @BeforeEach
    void setUp(){
        out = new MathQuestionService(questionRepository, utilService);
    }

    @Test
    void addNewQuestion(){
        Question expected = new Question("question", "answer");
        Mockito.when(questionRepository.add(any())).thenReturn(expected);
        Question actual = out.add(expected);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void addQuestionAndAnswer(){
        Question expected = new Question("question", "answer");
        Mockito.when(questionRepository.add(any())).thenReturn(expected);
        Question actual = out.add(expected.getQuestion(), expected.getAnswer());
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void addNullQuestionA(){
        Assertions.assertThrows(BadRequestException.class, () -> out.add(null, null));
    }

    @Test
    void removeQuestion(){
        Question expected = new Question("question", "answer");
        Mockito.when(questionRepository.remove(any())).thenReturn(expected);
        Question actual = out.remove(expected);
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getAllQuestions(){
        Collection<Question> expected = List.of(new Question("question", "answer"));
        Mockito.when(questionRepository.getAll()).thenReturn(expected);
        Collection<Question> actual = out.getAll();
        Assertions.assertEquals(actual, expected);
    }

    @Test
    void getRandomQuestion(){
        Question expected = new Question("question", "answer");
        Collection<Question> expectedList = List.of(expected);
        Mockito.when(questionRepository.getAll()).thenReturn(expectedList);
        Mockito.when(utilService.getRandomQuestion(expectedList)).thenReturn(expected);
        Question actual = out.getRandomQuestion();
        Assertions.assertEquals(actual, expected);
    }
}
