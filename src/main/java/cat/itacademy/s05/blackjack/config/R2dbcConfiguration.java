package cat.itacademy.s05.blackjack.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@EnableR2dbcRepositories(basePackages = "cat.itacademy.s05.blackjack.repository.mysql")
public class R2dbcConfiguration {

}
