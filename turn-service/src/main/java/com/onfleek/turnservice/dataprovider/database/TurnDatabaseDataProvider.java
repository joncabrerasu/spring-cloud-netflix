package com.onfleek.turnservice.dataprovider.database;

import com.onfleek.turnservice.core.usecase.CreateTurn;
import com.onfleek.turnservice.dataprovider.database.entity.Turn;
import com.onfleek.turnservice.dataprovider.database.repository.TurnMongoRepository;

public class TurnDatabaseDataProvider implements CreateTurn {

    private final TurnMongoRepository turnMongoRepository;


    public TurnDatabaseDataProvider(TurnMongoRepository turnMongoRepository) {
        this.turnMongoRepository = turnMongoRepository;
    }

    @Override
    public com.onfleek.turnservice.core.entity.Turn createTurn(com.onfleek.turnservice.core.entity.Turn turn) {
        return map(turnMongoRepository.save(map(turn)));
    }

    private Turn map(com.onfleek.turnservice.core.entity.Turn turn) {
        Turn result = new Turn();
        result.setId(turn.getId());
        result.setSource(turn.getSource());
        result.setTarget(turn.getTarget());
        result.setStatus(turn.getStatus());
        result.setRequestDate(turn.getRequestDate());
        result.setFinishDate(turn.getFinishDate());
        result.setGitUrl(turn.getGitUrl());
        return result;
    }

    private com.onfleek.turnservice.core.entity.Turn map(Turn turn) {
        com.onfleek.turnservice.core.entity.Turn result = new com.onfleek.turnservice.core.entity.Turn();
        result.setId(turn.getId());
        result.setSource(turn.getSource());
        result.setTarget(turn.getTarget());
        result.setStatus(turn.getStatus());
        result.setRequestDate(turn.getRequestDate());
        result.setFinishDate(turn.getFinishDate());
        result.setGitUrl(turn.getGitUrl());
        return result;
    }
}
