package com.brunocesar.onlinedraw.entrypoints.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

/**
 * DrawResponse
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
public class DrawResponse implements Serializable {

    @JsonProperty(value = "result")
    private final Integer result;

    private DrawResponse(Integer result) {
        this.result = result;
    }

    public static DrawResponse of(Integer result) {
        Objects.requireNonNull(result, "result is required");
        return new DrawResponse(result);
    }

    public Integer getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawResponse that = (DrawResponse) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "DrawResponse{" +
                "result=" + result +
                '}';
    }

}
