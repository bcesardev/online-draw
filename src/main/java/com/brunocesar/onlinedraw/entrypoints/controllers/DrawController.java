package com.brunocesar.onlinedraw.entrypoints.controllers;

import com.brunocesar.onlinedraw.entrypoints.dtos.DrawRequest;
import com.brunocesar.onlinedraw.entrypoints.dtos.DrawResponse;
import com.brunocesar.onlinedraw.business.exceptions.DrawException;
import com.brunocesar.onlinedraw.business.usecases.DrawUseCase;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DrawController
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
@RestController
@RequestMapping(value = "/api/v1")
public class DrawController {

    private final DrawUseCase drawUseCase;

    public DrawController(DrawUseCase drawUseCase) {
        this.drawUseCase = drawUseCase;
    }

    @PostMapping(value = "/draw", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DrawResponse draw(@RequestBody DrawRequest drawRequest) throws DrawException {
        return drawUseCase.draw(drawRequest);
    }

}
