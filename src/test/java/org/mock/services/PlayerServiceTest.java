package org.mock.services;

import cat.itacademy.s05.blackjack.model.mysql.Player;
import cat.itacademy.s05.blackjack.repository.mysql.interfaces.PlayerRepository;
import cat.itacademy.s05.blackjack.services.PlayerService;
import org.junit.jupiter.api.Test;

import org.reactivestreams.Publisher;
import org.springframework.data.relational.core.sql.When;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    PlayerRepository playerRepository = mock(PlayerRepository.class);

    PlayerService playerService = new PlayerService(playerRepository);

    @Test
    public void testSave() {

        Player player = new Player();

        player.setId(1l);
        player.setName("Pepo");


        when(playerRepository.save(player)).thenReturn(Mono.just(player));

        Mono<Player> result = playerService.save(player);

        Player savedPlayer = result.block();

        assertNotNull(savedPlayer);
        assertEquals("Pepo", savedPlayer.getName());
        assertEquals(1l, savedPlayer.getId());



    }
/*
    @Test
    public void testUpdate () {
        return playerRepository.save();

    }

 */
    @Test
    public void testFindAll(){
        Flux<Player> result = playerService.findAll();
                 assertNotNull(result);
                 //assertFalse(result.);
                 //assertEquals("Pedro", result.(0).getName());
    }

    @Test
    public void testFindById(){
        return playerRepository.findById();
    }

    @Test
    public void testDeleteById(){
        playerRepository.deleteById();
    }
}
