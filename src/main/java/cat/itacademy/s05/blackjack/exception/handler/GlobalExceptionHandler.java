package cat.itacademy.s05.blackjack.exception.handler;

import cat.itacademy.s05.blackjack.exception.exceptions.InvalidPlayerDataException;
import cat.itacademy.s05.blackjack.exception.exceptions.PlayerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PlayerNotFoundException.class)
    public Mono<Map<String, Object>> handlePlayerNotFound(PlayerNotFoundException e) {
        return Mono.just(Map.of(
                "status", HttpStatus.NOT_FOUND.value(),
                "error", "Player Not Found",
                "message", e.getMessage()
        ));
    }

    @ExceptionHandler(InvalidPlayerDataException.class)
    public Mono<Map<String, Object>> handleInvalidPlayerData(InvalidPlayerDataException e) {
        return Mono.just(Map.of(
                "status", HttpStatus.BAD_REQUEST.value(),
                "error", "Invalid Player Data",
                "message", e.getMessage()
        ));
    }
}
