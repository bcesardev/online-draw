package com.brunocesar.onlinedraw.domains;

import com.brunocesar.onlinedraw.business.exceptions.DrawException;
import com.brunocesar.onlinedraw.entrypoints.dtos.DrawRequest;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

/**
 * OnlineDraw
 *
 * @author : Bruno Cesar
 * @since : 12/10/2020
 **/
public class Draw {

    private int max;

    private int min;

    public Draw(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static Draw of(DrawRequest drawRequest) throws DrawException {
        int min = drawRequest.getMin().intValue();
        int max = drawRequest.getMax().intValue();
        return new Draw(min, max);
    }

    public int execute() {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Draw that = (Draw) o;
        return max == that.max &&
                min == that.min;
    }

    @Override
    public int hashCode() {
        return Objects.hash(max, min);
    }


    @Override
    public String
    toString() {
        return "OnlineDraw{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

}