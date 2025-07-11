package cat.itacademy.s05.blackjack.repository.mongodb.interfaces;

import cat.itacademy.s05.blackjack.model.mongodb.GameLog;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GameLogRepository extends ReactiveMongoRepository<GameLog, String> {
}
