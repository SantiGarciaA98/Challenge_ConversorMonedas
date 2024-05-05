package com.challenges.conversormonedas;

public record Moneda(String base_code,
                     String target_code,
                     Float conversion_rate,
                     Float conversion_result) {
}
