package org.mock.services;

import cat.itacademy.s05.blackjack.model.mysql.Player;
import cat.itacademy.s05.blackjack.repository.mysql.interfaces.PlayerRepository;
import cat.itacademy.s05.blackjack.services.PlayerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PlayerServiceTest {

    private PlayerRepository playerRepository;
    private PlayerService playerService;

    @BeforeEach
    public void setUp() {
        playerRepository = mock(PlayerRepository.class);
        playerService = new PlayerService(playerRepository);
    }

    @Test
    public void testSave() {
        Player player = new Player();
        player.setId(1L);
        player.setName("Pepo");

        when(playerRepository.save(player)).thenReturn(Mono.just(player));

        Mono<Player> result = playerService.save(player);
        Player savedPlayer = result.block();

        assertNotNull(savedPlayer);
        assertEquals("Pepo", savedPlayer.getName());
        assertEquals(1L, savedPlayer.getId());
    }

    @Test
    public void testUpdate() {
        Player player = new Player();
        player.setId(2L);
        player.setName("Lola");

        when(playerRepository.existsById(2L)).thenReturn(Mono.just(true));

        when(playerRepository.save(player)).thenReturn(Mono.just(player));

        Mono<Player> result = playerService.update(player);
        Player updatedPlayer = result.block();

        assertNotNull(updatedPlayer);
        assertEquals("Lola", updatedPlayer.getName());
        assertEquals(2L, updatedPlayer.getId());
    }

    @Test
    public void testFindAll() {
        Player p1 = new Player();
        p1.setId(1L);
        p1.setName("Pedro");

        Player p2 = new Player();
        p2.setId(2L);
        p2.setName("Lucia");

        when(playerRepository.findAll()).thenReturn(Flux.just(p1, p2));

        Flux<Player> result = playerService.findAll();
        assertEquals(2, result.collectList().block().size());
    }

    @Test
    public void testFindById() {
        Player player = new Player();
        player.setId(1L);
        player.setName("Cata");

        when(playerRepository.findById(1L)).thenReturn(Mono.just(player));

        Mono<Player> result = playerService.findById(1L);
        Player found = result.block();

        assertNotNull(found);
        assertEquals(1L, found.getId());
        assertEquals("Cata", found.getName());
    }

    @Test
    public void testDeleteById() {
        when(playerRepository.deleteById(1L)).thenReturn(Mono.empty());

        Mono<Void> result = playerService.deleteById(1L);
        assertNull(result.block());
        verify(playerRepository, times(1)).deleteById(1L);
    }
}
