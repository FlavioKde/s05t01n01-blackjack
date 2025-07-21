package cat.itacademy.s05.blackjack.controller;

import cat.itacademy.s05.blackjack.model.mongodb.GameLog;
import cat.itacademy.s05.blackjack.model.mysql.Player;
import cat.itacademy.s05.blackjack.services.PlayerService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService = playerService;
    }


    @PostMapping("/new")
    public Mono<Player> create(@RequestBody Player player){
        return playerService.save(player);
    }
    @PutMapping("/update")
    public Mono<Player> update(@RequestBody Player player){
        return playerService.update(player);
    }
    @GetMapping("/getAll")
    public Flux<Player> getAll(){
        return playerService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Player> findById(@PathVariable Long id){
        return playerService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteById(@PathVariable Long id){
        return playerService.deleteById(id);

    }
}
