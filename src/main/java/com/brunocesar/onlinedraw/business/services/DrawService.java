package com.brunocesar.onlinedraw.business.services;

import com.brunocesar.onlinedraw.business.exceptions.DrawException;
import com.brunocesar.onlinedraw.business.validators.DrawRequestValidator;
import com.brunocesar.onlinedraw.domains.Draw;
import com.brunocesar.onlinedraw.entrypoints.dtos.DrawRequest;
import com.brunocesar.onlinedraw.entrypoints.dtos.DrawResponse;
import org.springframework.stereotype.Service;

/**
 * DrawService
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
@Service
public class DrawService {

    public DrawResponse draw(DrawRequest drawRequest) throws DrawException {
        DrawRequestValidator.validate(drawRequest);

        Draw draw = Draw.of(drawRequest);

        int result = draw.execute();

        return DrawResponse.of(result);
    }

}
