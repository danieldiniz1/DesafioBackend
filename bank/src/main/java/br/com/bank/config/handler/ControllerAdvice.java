package br.com.bank.config.handler;

import br.com.bank.exception.ModelNotFoundException;
import br.com.bank.exception.ModelSimpleSaveException;
import br.com.bank.exception.UserExistsException;
import br.com.bank.exception.UserUnactiveException;
import br.com.bank.model.domain.StandardErrorModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestValueException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    private static final Logger LOGGER = LogManager.getLogger();

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<StandardErrorModel> modelNotFound (ModelNotFoundException ex) {
        return ResponseEntity.status(400).body(StandardErrorModel.valueOf(ex));
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<StandardErrorModel> userExists (ModelNotFoundException ex) {
        return ResponseEntity.status(400).body(StandardErrorModel.valueOf(ex));
    }

    @ExceptionHandler(ModelSimpleSaveException.class)
    public ResponseEntity<StandardErrorModel> saveProblems (ModelSimpleSaveException ex) {
        return ResponseEntity.status(400).body(StandardErrorModel.valueOf(ex));
    }

    @ExceptionHandler(MissingRequestValueException.class)
    public ResponseEntity<StandardErrorModel> genericValidProblems (MissingRequestValueException ex) {
        return ResponseEntity.status(400).body(StandardErrorModel.valueOf(ex));
    }

    @ExceptionHandler(UserUnactiveException.class)
    public ResponseEntity<StandardErrorModel> userExcluded (UserUnactiveException ex) {
        return ResponseEntity.status(400).body(StandardErrorModel.valueOf(ex));
    }
}
