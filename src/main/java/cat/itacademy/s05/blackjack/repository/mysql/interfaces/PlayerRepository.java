package cat.itacademy.s05.blackjack.repository.mysql.interfaces;

import cat.itacademy.s05.blackjack.model.mysql.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

import java.util.Optional;

public interface PlayerRepository extends ReactiveCrudRepository<Player, Long> {

}
