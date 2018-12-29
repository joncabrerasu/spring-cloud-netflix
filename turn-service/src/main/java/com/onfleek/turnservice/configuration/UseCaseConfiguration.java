package com.onfleek.turnservice.configuration;

import com.onfleek.turnservice.core.usecase.CreateTurn;
import com.onfleek.turnservice.core.usecase.CreateTurnUseCase;
import com.onfleek.turnservice.core.usecase.ExistsAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateTurnUseCase createTurnUseCase(CreateTurn createTurn, ExistsAccount existsAccount) {
        return new CreateTurnUseCase(createTurn, existsAccount);
    }
}
