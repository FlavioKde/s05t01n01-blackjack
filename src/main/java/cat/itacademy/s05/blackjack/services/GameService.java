package cat.itacademy.s05.blackjack.services;



import cat.itacademy.s05.blackjack.domain.Game;
import cat.itacademy.s05.blackjack.model.mongodb.Card;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GameService {

    public String determineWinner(Game game){
        int playerScore = calculateHandValue(game.getPlayerCards());
        int dealerScore = calculateHandValue(game.getDealerCards());

        if(playerScore > 21) return "Dealer";
        if(dealerScore > 21) return "Player";
        if(playerScore > dealerScore) return "Player";
        if(dealerScore > playerScore) return "Dealer";
        return "Draw";
    }

    public int calculateHandValue(List<Card>cards){
        int value = 0;
        int aceValue = 0;

        for (Card card: cards) {

            switch (card.getRank()) {
                case ACE:
                    value += 11;
                    aceValue++;
                    break;
                case KING:
                case QUEEN:
                case JACK:
                    value += 10;
                    break;
                default:
                    value += card.getRank().getValue();
                    break;
            }
        }
            while (value > 21 && aceValue > 0) {
                value -= 10;
                aceValue--;
            }

        return value;
    }

}
