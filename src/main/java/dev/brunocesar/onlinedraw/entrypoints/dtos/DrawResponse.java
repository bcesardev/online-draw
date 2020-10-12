package dev.brunocesar.onlinedraw.entrypoints.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * DrawResponse
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
public class DrawResponse implements Serializable {

    @JsonProperty(value = "results")
    private final List<Integer> results;

    private DrawResponse(List<Integer> results) {
        this.results = results;
    }

    public static DrawResponse of(List<Integer> results) {
        Objects.requireNonNull(results, "results is required");
        return new DrawResponse(results);
    }

    public List<Integer> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrawResponse that = (DrawResponse) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "DrawResponse{" +
                "results=" + results +
                '}';
    }

}
