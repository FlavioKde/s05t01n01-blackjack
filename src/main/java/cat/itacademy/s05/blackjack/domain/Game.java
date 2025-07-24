package cat.itacademy.s05.blackjack.domain;

import cat.itacademy.s05.blackjack.model.mongodb.Card;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Card> playerCards;
    private final List<Card> dealerCards;

    public Game(List<Card>playerCards, List<Card>dealerCards){
        this.playerCards = playerCards != null ? playerCards : new ArrayList<>();
        this.dealerCards = dealerCards != null ? dealerCards : new ArrayList<>();
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

}
