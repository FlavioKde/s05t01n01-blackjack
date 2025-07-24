package cat.itacademy.s05.blackjack.exception.exceptions;

public class PlayerNotFoundException extends RuntimeException {
    public PlayerNotFoundException(Long id) {
        super("The player that mentions does not exist");
    }
}
