package cat.itacademy.s05.blackjack.dto;

import java.math.BigDecimal;

public class GamePlayDTO {
    private  MoveType moveType;
    private  BigDecimal amount;

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

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
