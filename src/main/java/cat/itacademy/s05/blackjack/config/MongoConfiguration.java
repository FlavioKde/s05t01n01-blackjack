package cat.itacademy.s05.blackjack.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "cat.itacademy.s05.blackjack.repository.mongodb")
public class MongoConfiguration {
}
