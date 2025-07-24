package cat.itacademy.s05.blackjack.services;

import cat.itacademy.s05.blackjack.dto.GamePlayDTO;
import cat.itacademy.s05.blackjack.dto.PlayerStatsDto;
import cat.itacademy.s05.blackjack.exception.exceptions.InvalidBetException;
import cat.itacademy.s05.blackjack.model.mongodb.GameLog;
import cat.itacademy.s05.blackjack.repository.mongodb.interfaces.GameLogRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;


@Service
public class GameLogService {

    private GameLogRepository gameLogRepository;

    public GameLogService(GameLogRepository gameLogRepository){

        this.gameLogRepository = gameLogRepository;
    }

    public Mono<GameLog> save(GameLog gameLog){
        return gameLogRepository.save(gameLog);
    }

    public Mono<GameLog> update (GameLog gameLog) {
        return gameLogRepository.save(gameLog);

    }

    public Flux<GameLog> findAll(){
        return gameLogRepository.findAll();
    }


    public Mono<GameLog>findById(String id){
        return gameLogRepository.findById(id);
    }


    public Mono<Void> deleteById(String  id){
        return gameLogRepository.deleteById(id);
    }


    public Mono<GameLog> playMove(String id, GamePlayDTO playDto) {
        if (playDto.getAmount() == null || playDto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {

            return Mono.error(new InvalidBetException("The bet placed is not correct"));
        }

        return gameLogRepository.findById(id)
                .flatMap(gameLog -> {

                    gameLog.setLastMoveType(playDto.getMoveType());


                    BigDecimal amount = playDto.getAmount();
                    gameLog.setBetAmount(amount);

                    BigDecimal previousTotal = gameLog.getTotalAmount() != null
                            ? gameLog.getTotalAmount()
                            : BigDecimal.ZERO;
                    gameLog.setTotalAmount(previousTotal.add(amount));

                    return gameLogRepository.save(gameLog);
                });
    }

    public Flux<PlayerStatsDto> getPlayersRanking() {


        return gameLogRepository.findAll()
                .collectList()
                .flatMapMany(gameLogs -> {
                    Map<Long, PlayerStatsDto> statsMap = new HashMap<>();

                    for (GameLog gameLog : gameLogs) {
                        Long playerId = gameLog.getPlayerId();
                        String playerName = gameLog.getPlayerName();

                        PlayerStatsDto stats = statsMap.getOrDefault(playerId, new PlayerStatsDto(playerId, playerName));

                        stats.setGamesPlayed(stats.getGamesPlayed() + 1);
                        stats.setTotalBet(stats.getTotalBet().add(gameLog.getBetAmount() != null ? gameLog.getBetAmount() : BigDecimal.ZERO));

                        switch (gameLog.getGameStatus()) {
                            case WON -> stats.setGamesWon(stats.getGamesWon() + 1);
                            case LOST -> stats.setGamesLost(stats.getGamesLost() + 1);
                            case DRAW -> stats.setGamesDrawn(stats.getGamesDrawn() + 1);
                            default -> {}
                        }

                        statsMap.put(playerId, stats);
                    }

                    return Flux.fromIterable(statsMap.values())
                            .sort(Comparator.comparingInt(PlayerStatsDto::getGamesWon).reversed());
                });
    }

}




