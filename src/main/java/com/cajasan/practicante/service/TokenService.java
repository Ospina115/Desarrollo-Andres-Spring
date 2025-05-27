package com.cajasan.practicante.service;

@Service
public class ExternalApiService {
    private final WebClient webClient;
    private final TokenService tokenService;
    public ExternalApiService(WebClient.Builder webClientBuilder, TokenService tokenService) {
        this.webClient = webClientBuilder.build();
        this.tokenService = tokenService;
    }
    public String callExternalApi(String endpointUrl) {
        String token = tokenService.getAccessToken();
        return webClient.get()
            .uri(endpointUrl)
            .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}