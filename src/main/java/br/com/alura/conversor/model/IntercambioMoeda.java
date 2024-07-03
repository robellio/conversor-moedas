package br.com.alura.conversor.model;

import java.util.Map;

public class IntercambioMoeda {

    private String moedaBase;
    private Map<String, Double> taxaConversao;

    public IntercambioMoeda(DadosMoeda dadosMoeda) {
        this.moedaBase = dadosMoeda.moedaBase();
        this.taxaConversao = dadosMoeda.taxasConversao();
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public void setMoedaBase(String moedaBase) {
        this.moedaBase = moedaBase;
    }

    public Map<String, Double> getTaxaConversao() {
        return taxaConversao;
    }

    public void setTaxaConversao(Map<String, Double> taxaConversao) {
        this.taxaConversao = taxaConversao;
    }

    @Override
    public String toString() {
        return "moedaBase='" + moedaBase + '\'' +
                ", taxaConversao=" + taxaConversao;

    }
}
