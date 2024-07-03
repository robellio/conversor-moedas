package br.com.alura.conversor.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMoeda(
        @JsonAlias("base_code")String moedaBase,
        @JsonAlias("conversion_rates") Map<String, Double> taxasConversao) {
}
