package com.cajasan.demo;

import com.cajasan.demo.config.AuthProperties;
import com.cajasan.demo.service.TokenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestBodyUriSpec;
import org.springframework.web.reactive.function.client.WebClient.RequestBodySpec;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;
import reactor.core.publisher.Mono;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TokenServiceTest {

    @Mock
    private WebClient webClient;

    @Mock
    private RequestBodyUriSpec uriSpec;

    @Mock
    private RequestBodySpec bodySpec;

    @Mock
    private RequestHeadersSpec<?> headersSpec;

    @Mock
    private ResponseSpec responseSpec;

    @Mock
    private AuthProperties authProperties;

    @InjectMocks
    private TokenService tokenService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetBearerToken() {
        String expectedToken = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...";

        when(authProperties.getUsername()).thenReturn("RPA-PIX");
        when(authProperties.getPassword()).thenReturn("PIÑAOROMIEL");
        when(authProperties.getTokenUrl()).thenReturn("https://wsc.cajasan.com/api/auth/token");

        Map<String, String> responseMap = Map.of("access_token", expectedToken);

        when(webClient.post()).thenReturn(uriSpec);
        when(uriSpec.uri("https://wsc.cajasan.com/api/auth/token")).thenReturn(bodySpec);
        when(bodySpec.bodyValue(any())).thenReturn(headersSpec);
        when(headersSpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(Map.class)).thenReturn(Mono.just(responseMap));

        String actualToken = tokenService.getBearerToken();

        assertEquals(expectedToken, actualToken);
        verify(webClient).post();
    }
}