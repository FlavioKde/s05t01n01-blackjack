package cat.itacademy.s05.blackjack.domain;

import cat.itacademy.s05.blackjack.model.mongodb.Card;
import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Card> playerCards;
    private List<Card> dealerCards;

    public Game(List<Card>playerCards, List<Card>dealerCards){
        this.playerCards = playerCards != null ? playerCards : new ArrayList<>();
        this.dealerCards = dealerCards != null ? dealerCards : new ArrayList<>();
    }

    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public List<Card> getDealerCards() {
        return dealerCards;
    }

    public void setDealerCards(List<Card> dealerCards) {
        this.dealerCards = dealerCards;
    }
}
