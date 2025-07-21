package cat.itacademy.s05.blackjack.exception.handler;

import cat.itacademy.s05.blackjack.exception.exceptions.PlayerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //error 404
    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<String> handleFruitNotFound(PlayerNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }
}
