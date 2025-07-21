package cat.itacademy.s05.blackjack.controller;

import cat.itacademy.s05.blackjack.model.mongodb.GameLog;
import cat.itacademy.s05.blackjack.dto.GamePlayDTO;
import cat.itacademy.s05.blackjack.services.GameLogService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@RestController
@RequestMapping("/game")
public class GameLogController {

    private final GameLogService gameLogService;

    private GameLogController(GameLogService gameLogService){
        this.gameLogService = gameLogService;
    }


    @PostMapping("/new")
    public Mono<GameLog> create(@RequestBody GameLog gameLog){
        return gameLogService.save(gameLog);
    }
    @PutMapping("/update")
    public Mono<GameLog> update(@RequestBody GameLog gameLog){
        return gameLogService.update(gameLog);
    }
    @GetMapping("/getAll")
    public Flux<GameLog> getAll(){
        return gameLogService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<GameLog> findById(@PathVariable String id){
        return gameLogService.findById(id);
    }


    @DeleteMapping("/delete/{id}")
    public Mono<Void> deleteById(@PathVariable String id){
        return gameLogService.deleteById(id);

    }
    @PostMapping("/{id}/play")
    public Mono<GameLog> play(@PathVariable String id, @RequestBody GamePlayDTO playDto) {
        return gameLogService.playMove(id, playDto);
    }

}
