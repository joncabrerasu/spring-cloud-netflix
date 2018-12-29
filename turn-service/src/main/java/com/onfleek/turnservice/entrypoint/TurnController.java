package com.onfleek.turnservice.entrypoint;

import com.onfleek.turnservice.core.usecase.CreateTurnUseCase;
import com.onfleek.turnservice.core.usecase.TurnBadRequestException;
import com.onfleek.turnservice.entrypoint.entity.Turn;
import com.onfleek.turnservice.entrypoint.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TurnController {

    private final CreateTurnUseCase createTurnUseCase;

    public TurnController(CreateTurnUseCase createTurnUseCase) {
        this.createTurnUseCase = createTurnUseCase;
    }

    @PostMapping("/turns")
    public ResponseEntity<Turn> create(@RequestBody Turn turn) {
        try {
            return new ResponseEntity<>(map(createTurnUseCase.createTurn(map(turn))), HttpStatus.CREATED);
        }catch (TurnBadRequestException e) {
            throw new BadRequestException(e.getMessage());
        }
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
