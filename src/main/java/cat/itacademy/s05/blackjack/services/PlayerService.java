package cat.itacademy.s05.blackjack.services;

import cat.itacademy.s05.blackjack.exception.exceptions.InvalidPlayerDataException;
import cat.itacademy.s05.blackjack.exception.exceptions.PlayerNotFoundException;
import cat.itacademy.s05.blackjack.model.mysql.Player;
import cat.itacademy.s05.blackjack.repository.mysql.interfaces.PlayerRepository;
import jakarta.validation.constraints.Null;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static reactor.core.publisher.Mono.error;


@Service
public class PlayerService {
    private PlayerRepository playerRepository ;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }


    public Mono<Player> save(Player player) {
        return Mono.defer(() -> {
            player.setRegistrationDate(LocalDateTime.now());

            String name = player.getName();
            if (name == null || name.trim().isEmpty()) {
                return Mono.error(new InvalidPlayerDataException(player));
            }

            name = name.trim();
            player.setName(name);

            return playerRepository.save(player);
        });
    }


    public Mono<Player> update (Player player) {
        return playerRepository.existsById(player.getId())
                    .flatMap(exists -> {
                        if (!exists) {
                            return error(new PlayerNotFoundException(player.getId()));
                        }
                        return playerRepository.save(player);
                    });
        }



    public Flux<Player> findAll(){
        return playerRepository.findAll();
    }


    public Mono<Player>findById(Long id){
        return playerRepository.findById(id);
    }


    public Mono<Void> deleteById(Long id){
        return playerRepository.deleteById(id);
    }
}
