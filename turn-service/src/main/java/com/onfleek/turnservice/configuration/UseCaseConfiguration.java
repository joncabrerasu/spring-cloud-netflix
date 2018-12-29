package com.onfleek.turnservice.configuration;

import com.onfleek.turnservice.core.usecase.CreateTurn;
import com.onfleek.turnservice.core.usecase.CreateTurnUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    public CreateTurnUseCase createTurnUseCase(CreateTurn createTurn) {
        return new CreateTurnUseCase(createTurn);
    }
}
