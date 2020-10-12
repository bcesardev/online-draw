package com.brunocesar.onlinedraw.entrypoints.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DrawRequest
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
public class DrawRequest implements Serializable {

    @JsonProperty(value = "min")
    private BigDecimal min;

    @JsonProperty(value = "max")
    private BigDecimal max;

    @JsonProperty(value = "draws")
    private Integer draws;

    public DrawRequest() {
    }

    public BigDecimal getMin() {
        return min;
    }

    public void setMin(BigDecimal min) {
        this.min = min;
    }

    public BigDecimal getMax() {
        return max;
    }

    public void setMax(BigDecimal max) {
        this.max = max;
    }

    public Integer getDraws() {
        return draws;
    }

    public void setDraws(Integer draws) {
        this.draws = draws;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawRequest that = (DrawRequest) o;
        return Objects.equals(min, that.min) &&
                Objects.equals(max, that.max) &&
                Objects.equals(draws, that.draws);
    }

    @Override
    public int hashCode() {
        return Objects.hash(min, max, draws);
    }

    @Override
    public String toString() {
        return "DrawRequest{" +
                "min=" + min +
                ", max=" + max +
                ", draws=" + draws +
                '}';
    }
}
