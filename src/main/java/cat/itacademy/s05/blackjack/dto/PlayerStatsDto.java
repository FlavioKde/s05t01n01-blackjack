package cat.itacademy.s05.blackjack.dto;

import java.math.BigDecimal;

public class PlayerStatsDto {
    private Long playerId;
    private String playerName;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int gamesDrawn;
    private BigDecimal totalBet;
    private BigDecimal totalWon;

    public PlayerStatsDto(){

    }

    public PlayerStatsDto(Long playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
        this.gamesDrawn = 0;
        this.totalBet = BigDecimal.ZERO;
        this.totalWon = BigDecimal.ZERO;
    }


    public Long getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public void setGamesDrawn(int gamesDrawn) {
        this.gamesDrawn = gamesDrawn;
    }

    public BigDecimal getTotalBet() {
        return totalBet;
    }

    public void setTotalBet(BigDecimal totalBet) {
        this.totalBet = totalBet;
    }

    public BigDecimal getTotalWon() {
        return totalWon;
    }

    public void setTotalWon(BigDecimal totalWon) {
        this.totalWon = totalWon;
    }

}
