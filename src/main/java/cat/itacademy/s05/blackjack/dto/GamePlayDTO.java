package cat.itacademy.s05.blackjack.dto;

import java.math.BigDecimal;

public class GamePlayDTO {
    private final MoveType moveType;
    private final BigDecimal amount;

    public GamePlayDTO(MoveType moveType, BigDecimal amount){
        this.moveType = moveType;
        this.amount = amount;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

}
