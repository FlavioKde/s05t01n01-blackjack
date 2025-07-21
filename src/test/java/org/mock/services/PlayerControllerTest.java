package org.mock.services;


import cat.itacademy.s05.blackjack.controller.PlayerController;
import cat.itacademy.s05.blackjack.model.mysql.Player;
import cat.itacademy.s05.blackjack.services.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreatePlayer() {

        Player player = new Player();
        player.setId(1L);
        player.setName("Petete");


        when(playerService.save(any(Player.class))).thenReturn(Mono.just(player));


        Mono<Player> responseMono = playerController.create(player);


        Player responsePlayer = responseMono.block();


        assertNotNull(responsePlayer);
        assertEquals(1L, responsePlayer.getId());
        assertEquals("Petete", responsePlayer.getName());


        verify(playerService, times(1)).save(any(Player.class));
    }
    @Test
    public void testUpdatePlayer(){

        Player player = new Player();
        player.setId(2L);
        player.setName("Lucia");

        when(playerService.update(any(Player.class))).thenReturn(Mono.just(player));


        Mono<Player> responseMono = playerController.update(player);

        Player updatePlayer = responseMono.block();

        assertNotNull(updatePlayer);
        assertEquals("Lucia", updatePlayer.getName());
        verify(playerService, times(1)).update(player);


    }

    @Test
    public void testGetAll(){
        Player p1 = new Player();
        p1.setId(1L);
        p1.setName("Petete");

        Player p2 = new Player();
        p2.setId(2L);
        p2.setName("Lucia");


        when(playerService.findAll()).thenReturn(Flux.just(p1, p2));

        Flux<Player> responseFlux = playerController.getAll();


        List<Player> players = responseFlux.collectList().block();

        assertEquals(1l,players.get(0).getId());
        assertEquals("Petete", players.get(0).getName());

        assertEquals(2l,players.get(1).getId());
        assertEquals("Lucia", players.get(1).getName());


        verify(playerService, times(1)).findAll();
    }

    @Test
    public void testFindById(){
        Player player = new Player();
        player.setId(2L);
        player.setName("Lucia");

        when(playerService.findById(2L)).thenReturn(Mono.just(player));

        Mono<Player> responseMono = playerController.findById(2L);
        Player responsePlayer = responseMono.block();

        assertNotNull(responsePlayer);
        assertEquals(2L, responsePlayer.getId());
        assertEquals("Lucia", responsePlayer.getName());

        verify(playerService, times(1)).findById(2L);

    }

    @Test
    public void deleteById(){
        when(playerService.deleteById(2L)).thenReturn(Mono.empty());

        Mono<Void> responseMono = playerController.deleteById(2L);

        Void result = responseMono.block();


        assertNull(result);

        verify(playerService, times(1)).deleteById(2L);

    }
}
