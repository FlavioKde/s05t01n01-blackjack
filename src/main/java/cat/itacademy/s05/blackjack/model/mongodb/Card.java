package cat.itacademy.s05.blackjack.model.mongodb;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
public class Card {
    @Id
    private String id;

    public Card(){

    }


}
