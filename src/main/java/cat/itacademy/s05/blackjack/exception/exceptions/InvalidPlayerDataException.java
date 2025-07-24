package cat.itacademy.s05.blackjack.exception.exceptions;

import cat.itacademy.s05.blackjack.model.mysql.Player;

public class InvalidPlayerDataException extends RuntimeException {
    public InvalidPlayerDataException(Player player) {
        super("A name is needed to be able to validate");
    }
}
