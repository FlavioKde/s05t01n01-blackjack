package cat.itacademy.s05.blackjack.model.mysql;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("bets")
public class Bet {
    @Id
    private long id;

    public Bet(){

    }
}
