package cat.itacademy.s05.blackjack.services;

import cat.itacademy.s05.blackjack.model.mysql.Player;
import cat.itacademy.s05.blackjack.repository.mysql.interfaces.PlayerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class PlayerService {
    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    //@Override
    public Mono<Player> save(Player player) {
        return playerRepository.save(player);
    }

    //@Override
    public Mono<Player> update (Player player) {
        return playerRepository.save(player);

    }
    //@Override
    public Flux<Player> findAll(){
        return playerRepository.findAll();
    }

    //@Override
    public Mono<Player>findByid(Long id){
        return playerRepository.findById(id);
    }

    //@Override
    public Mono<Void> deleteByid(Long id){
        return playerRepository.deleteById(id);
    }
}
