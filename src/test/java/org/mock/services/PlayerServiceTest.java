package org.mock.services;

import cat.itacademy.s05.blackjack.model.mysql.Player;
import cat.itacademy.s05.blackjack.repository.mysql.interfaces.PlayerRepository;
import cat.itacademy.s05.blackjack.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PlayerServiceTest {

    @Test
    public void testSave() {

        //given
        PlayerRepository playerRepository = new PlayerRepository() ;

        PlayerService playerService = new PlayerService(playerRepository);


        //When



        //them
        return playerRepository.save(fr);
    }

    @Test
    public void testUpdate () {
        return playerRepository.save();

    }
    @Test
    public void testFindAll(){
        return playerRepository.findAll();
    }

    @Test
    public void testFindByid(){
        return playerRepository.findById();
    }

    @Test
    public void TestDeleteByid(){
        playerRepository.deleteById();
    }
}
