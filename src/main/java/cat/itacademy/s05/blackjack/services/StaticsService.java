package cat.itacademy.s05.blackjack.services;

import cat.itacademy.s05.blackjack.dto.PlayerStatsDto;
import cat.itacademy.s05.blackjack.model.mongodb.GameLog;
import cat.itacademy.s05.blackjack.repository.mongodb.interfaces.GameLogRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class StaticsService {
    private GameLogRepository gameLogRepository;

    public StaticsService(GameLogRepository gameLogRepository){
        this.gameLogRepository = gameLogRepository;
    }

    public Mono<PlayerStatsDto> getStatsForPlayer(Long playerId){
        return gameLogRepository.findGameLogByPlayerId(playerId)
                .collectList()
                .map(gameLogs-> {
                    int won = 0, lost = 0, draw = 0;
                    BigDecimal totalBet = BigDecimal.ZERO;
                    BigDecimal totalWon = BigDecimal.ZERO;

                    //lost y draw supuestamente sobre, mirarlo cuando reviso código
                    BigDecimal totalLost = BigDecimal.ZERO;
                    BigDecimal totalDraw = BigDecimal.ZERO;

                    for (GameLog gameLog: gameLogs){
                        switch (gameLog.getGameStatus()){
                            case WON -> {
                                won ++;
                                totalWon = totalWon.add(BigDecimal.valueOf(50));
                            }
                            case LOST -> {
                                lost ++;
                                totalLost = totalLost.add(BigDecimal.valueOf(50));

                            }
                            case DRAW -> {
                                draw ++;
                                totalDraw = totalDraw.add(BigDecimal.valueOf(50));
                            }

                        }
                        totalBet = totalBet.add(BigDecimal.valueOf(50));
                    }
                    PlayerStatsDto playerStatsDto = new PlayerStatsDto();
                    playerStatsDto.setPlayerId(playerId);
                    playerStatsDto.setGamesPlayed(gameLogs.size());
                    playerStatsDto.setGamesWon(won);
                    playerStatsDto.setGamesLost(lost);
                    playerStatsDto.setGamesDrawn(draw);
                    playerStatsDto.setTotalBet(totalBet);
                    playerStatsDto.setTotalWon(totalWon);

                    return playerStatsDto;
                });

    }



}
