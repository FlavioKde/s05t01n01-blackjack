package cat.itacademy.s05.blackjack.model.mongodb;

import cat.itacademy.s05.blackjack.dto.MoveType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


@Document(collection="gameLogs")
public class GameLog {
    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    @Id
    private String id;
    private String playerName;
    private long playerId;
    private List<Card> playerCards;
    private List<Card> dealerCards;
    private GameStatus gameStatus;
    private BigDecimal betAmount;
    private MoveType lastMoveType;
    private BigDecimal totalAmount;



    public GameLog(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

    public void setDealerCards(List<Card> dealerCards) {
        this.dealerCards = dealerCards;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public MoveType getLastMoveType() {
        return lastMoveType;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setLastMoveType(MoveType lastMoveType) {
        this.lastMoveType = lastMoveType;
    }

    public BigDecimal getBetAmount() {
        return betAmount;
    }

    public void setBetAmount(BigDecimal betAmount) {
        this.betAmount = betAmount;
    }

    @Override
    public boolean equals(Object object) {
        if(this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        GameLog gameLog = (GameLog) object;
        return Objects.equals(id, gameLog.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);

    }
}
