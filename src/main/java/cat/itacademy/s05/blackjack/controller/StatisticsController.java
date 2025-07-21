package cat.itacademy.s05.blackjack.controller;


import cat.itacademy.s05.blackjack.dto.PlayerStatsDto;
import cat.itacademy.s05.blackjack.services.StaticsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final StaticsService staticsService;

    public StatisticsController(StaticsService staticsService){
        this.staticsService = staticsService;

    }

    @GetMapping("/{playerId}")
    public Mono<PlayerStatsDto>getStats(@PathVariable Long playerId){
        return staticsService.getStatsForPlayer(playerId);

    }
}
