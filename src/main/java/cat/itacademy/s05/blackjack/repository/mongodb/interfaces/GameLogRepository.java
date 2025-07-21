package cat.itacademy.s05.blackjack.repository.mongodb.interfaces;


import cat.itacademy.s05.blackjack.model.mongodb.GameLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface GameLogRepository extends ReactiveMongoRepository<GameLog, String> {

    Flux<GameLog> findGameLogByPlayerId(long playerId); 
}
