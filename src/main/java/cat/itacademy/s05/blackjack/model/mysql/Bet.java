package cat.itacademy.s05.blackjack.model.mysql;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("bets")
public class Bet {
    @Id
    private long id;
    private BigDecimal amount;
    private Long playerId;
    private String gameId;
    private ResultAmount resultAmount;

    public Bet(){

    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String  getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public ResultAmount getResultAmount() {
        return resultAmount;
    }

    public void setResultAmount(ResultAmount resultAmount) {
        this.resultAmount = resultAmount;
    }
}
