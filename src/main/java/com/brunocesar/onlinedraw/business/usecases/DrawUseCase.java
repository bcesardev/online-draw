package com.brunocesar.onlinedraw.business.usecases;

import com.brunocesar.onlinedraw.business.exceptions.DrawException;
import com.brunocesar.onlinedraw.business.validators.DrawRequestValidator;
import com.brunocesar.onlinedraw.domains.Draw;
import com.brunocesar.onlinedraw.entrypoints.dtos.DrawRequest;
import com.brunocesar.onlinedraw.entrypoints.dtos.DrawResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DrawUseCase
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
@Service
public class DrawUseCase {

    public DrawResponse draw(DrawRequest drawRequest) throws DrawException {
        DrawRequestValidator.validate(drawRequest);

        List<Integer> results = new ArrayList<>();

        for (int count = 1; count <= drawRequest.getDraws(); count++) {
            Draw draw = Draw.of(drawRequest);
            results.add(draw.execute());
        }

        return DrawResponse.of(results);
    }

}
