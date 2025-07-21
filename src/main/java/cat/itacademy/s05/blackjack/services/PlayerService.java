package cat.itacademy.s05.blackjack.services;

import cat.itacademy.s05.blackjack.exception.exceptions.PlayerNotFoundException;
import cat.itacademy.s05.blackjack.model.mysql.Player;
import cat.itacademy.s05.blackjack.repository.mysql.interfaces.PlayerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;


@Service
public class PlayerService {
    private PlayerRepository playerRepository ;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    //@Override
    public Mono<Player> save(Player player) {
        player.setRegistrationDate(LocalDateTime.now());//seteo y creo la data de registro cuando creo el player
        return playerRepository.save(player);
    }

    //@Override
    public Mono<Player> update (Player player) {
        return playerRepository.existsById(player.getId())
                    .flatMap(exists -> {
                        if (!exists) {
                            return Mono.error(new PlayerNotFoundException(player.getId()));
                        }
                        return playerRepository.save(player);
                    });
        }


    //@Override
    public Flux<Player> findAll(){
        return playerRepository.findAll();
    }

    //@Override
    public Mono<Player>findById(Long id){
        return playerRepository.findById(id);
    }

    //@Override
    public Mono<Void> deleteById(Long id){
        return playerRepository.deleteById(id);
    }
}
