package com.onfleek.turnservice.core.usecase;

import com.onfleek.turnservice.core.entity.Turn;
import org.apache.commons.lang.StringUtils;
import java.util.Date;

public class CreateTurnUseCase {

    private final CreateTurn createTurn;

    private final ExistsAccount existsAccount;

    public CreateTurnUseCase(CreateTurn createTurn, ExistsAccount existsAccount) {
        this.createTurn = createTurn;
        this.existsAccount = existsAccount;
    }

    public Turn createTurn(Turn newTurn) {
        validateNewTurn(newTurn);
        composeTurn(newTurn);
        return createTurn.createTurn(newTurn);
    }

    private void validateNewTurn(Turn newTurn) {
        if(StringUtils.isBlank(newTurn.getSource())) {
            throw new TurnBadRequestException("Source can not be blank");
        }

        if(!existsAccount.exists(newTurn.getSource())) {
            throw new TurnBadRequestException("Source username " + newTurn.getSource() + " doesn't exists");
        }
    }

    private void composeTurn(Turn newTurn) {
        if(StringUtils.isNotBlank(newTurn.getId())) {
            newTurn.setId("");
        }
        newTurn.setStatus("OPENED");
        newTurn.setRequestDate(new Date());
        newTurn.setFinishDate(null);
        newTurn.setGitUrl("");
        newTurn.setTarget("");
    }
}
