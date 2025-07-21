package cat.itacademy.s05.blackjack.services;

import cat.itacademy.s05.blackjack.dto.GamePlayDTO;
import cat.itacademy.s05.blackjack.model.mongodb.GameLog;
import cat.itacademy.s05.blackjack.repository.mongodb.interfaces.GameLogRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;


@Service
public class GameLogService {

    private GameLogRepository gameLogRepository;

    public GameLogService(GameLogRepository gameLogRepository){

        this.gameLogRepository = gameLogRepository;
    }

    //@Override
    public Mono<GameLog> save(GameLog gameLog){
        return gameLogRepository.save(gameLog);
    }

    //@Override
    public Mono<GameLog> update (GameLog gameLog) {
        return gameLogRepository.save(gameLog);

    }
    //@Override
    public Flux<GameLog> findAll(){
        return gameLogRepository.findAll();
    }

    //@Override
    public Mono<GameLog>findById(String id){
        return gameLogRepository.findById(id);
    }

    //@Override
    public Mono<Void> deleteById(String  id){
        return gameLogRepository.deleteById(id);
    }
    public Mono<GameLog> playMove(String id, GamePlayDTO playDto) {
        if (playDto.getAmount() == null || playDto.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            return Mono.error(new IllegalArgumentException("Invalid Bet"));
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



}
