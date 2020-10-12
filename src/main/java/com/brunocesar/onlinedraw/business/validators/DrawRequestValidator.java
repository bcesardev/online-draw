package com.brunocesar.onlinedraw.business.validators;

import com.brunocesar.onlinedraw.entrypoints.dtos.DrawRequest;
import com.brunocesar.onlinedraw.business.exceptions.DrawException;

import java.math.BigDecimal;

/**
 * DrawValidator
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
public final class DrawRequestValidator {

    private static final BigDecimal MAX_VALUE = new BigDecimal(Integer.MAX_VALUE - 1);

    private DrawRequestValidator() {
    }

    public static void validate(DrawRequest drawRequest) throws DrawException {
        BigDecimal min = drawRequest.getMin();
        BigDecimal max = drawRequest.getMax();

        validateMin(min);
        validateMax(max);

        if (min.compareTo(max) > 0) {
            throw new DrawException("min cannot be equal or more than max");
        }
    }

    private static void validateMin(BigDecimal min) throws DrawException {
        if (min == null || (min.compareTo(BigDecimal.ZERO) <= 0)) {
            throw new DrawException("min cannot be zero or less");
        }

        if (min.compareTo(MAX_VALUE) > 0) {
            throw new DrawException("min cannot be more than " + MAX_VALUE);
        }
    }

    private static void validateMax(BigDecimal max) throws DrawException {
        if (max == null || (max.compareTo(BigDecimal.ZERO) <= 0)) {
            throw new DrawException("max cannot be zero or less");
        }

        if (max.compareTo(MAX_VALUE) > 0) {
            throw new DrawException("max cannot be more than " + MAX_VALUE);
        }
    }

}
