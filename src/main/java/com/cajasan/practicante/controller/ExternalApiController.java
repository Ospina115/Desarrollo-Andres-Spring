package com.cajasan.practicante.controller;

@RestController
@RequestMapping("/api/external")
public class ExternalApiController {
    private final ExternalApiService externalApiService;
    public ExternalApiController(ExternalApiService externalApiService) {
        this.externalApiService = externalApiService;
    }
    @GetMapping("/data")
    public ResponseEntity<String> getData(@RequestParam String url) {
        String response = externalApiService.callExternalApi(url);
        return ResponseEntity.ok(response);
    }
}