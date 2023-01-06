package sky.pro.coursework03;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExaminerExceptionController {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> moreThanFiveRequestsException (IllegalArgumentException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
