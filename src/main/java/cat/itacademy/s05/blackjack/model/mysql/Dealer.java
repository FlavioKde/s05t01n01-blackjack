package cat.itacademy.s05.blackjack.model.mysql;


import cat.itacademy.s05.blackjack.model.mongodb.Card;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("dealers")
public class Dealer {
    @Id
    private long id;
    private Card card;

    public Dealer(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
