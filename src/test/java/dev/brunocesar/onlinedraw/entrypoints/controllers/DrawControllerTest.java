package dev.brunocesar.onlinedraw.entrypoints.controllers;

import dev.brunocesar.onlinedraw.entrypoints.controllers.builders.DrawRequestBuilder;
import dev.brunocesar.onlinedraw.entrypoints.dtos.DrawRequest;
import dev.brunocesar.onlinedraw.entrypoints.dtos.DrawResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

/**
 * DrawControllerTest
 *
 * @author : Bruno Cesar
 * @since : 13/10/2020
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DrawControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testDraw() {

        DrawRequest drawRequest = new DrawRequestBuilder()
                .withDraws(2)
                .withMax(new BigDecimal("30"))
                .withMin(new BigDecimal("10"))
                .build();

        webTestClient.post()
                .uri("/api/v1/draw")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(drawRequest)
                .exchange()
                .expectStatus()
                .is2xxSuccessful();
    }

    @Test
    public void testErrorDraw() {

        DrawRequest drawRequest = new DrawRequestBuilder()
                .withDraws(2)
                .withMax(new BigDecimal("10"))
                .withMin(new BigDecimal("20"))
                .build();

        webTestClient.post()
                .uri("/api/v1/draw")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(drawRequest)
                .exchange()
                .expectStatus()
                .is4xxClientError();
    }

}
