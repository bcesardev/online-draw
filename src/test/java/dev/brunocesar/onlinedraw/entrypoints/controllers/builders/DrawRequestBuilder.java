package dev.brunocesar.onlinedraw.entrypoints.controllers.builders;

import dev.brunocesar.onlinedraw.entrypoints.dtos.DrawRequest;

import java.math.BigDecimal;

/**
 * DrawRequestBuilder
 *
 * @author : Bruno Cesar
 * @since : 13/10/2020
 **/
public class DrawRequestBuilder {

    private BigDecimal max;
    private BigDecimal min;
    private int draws;

    public DrawRequestBuilder withMax(BigDecimal max) {
        this.max = max;
        return this;
    }

    public DrawRequestBuilder withMin(BigDecimal min) {
        this.min = min;
        return this;
    }

    public DrawRequestBuilder withDraws(int draws) {
        this.draws = draws;
        return this;
    }

    public DrawRequest build() {
        DrawRequest drawRequest = new DrawRequest();
        drawRequest.setMax(max);
        drawRequest.setMin(min);
        drawRequest.setDraws(draws);
        return drawRequest;
    }

}
