package cat.itacademy.s05.blackjack.services;

import cat.itacademy.s05.blackjack.model.mongodb.GameLog;
import cat.itacademy.s05.blackjack.model.mysql.Bet;
import cat.itacademy.s05.blackjack.model.mysql.Player;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class BetService {

    private static final BigDecimal DEFAULT_BET_AMOUNT = BigDecimal.valueOf(50);

    public BigDecimal placeBet(GameLog gameLog){


        if(gameLog.getId() != null && gameLog.getPlayerId() != null ){

            Bet bet = new Bet();
            bet.setAmount(DEFAULT_BET_AMOUNT);
            bet.setPlayerId(gameLog.getPlayerId());
            bet.setGameId(gameLog.getId());
            return DEFAULT_BET_AMOUNT;


        }
        return BigDecimal.ZERO;
    }
}
