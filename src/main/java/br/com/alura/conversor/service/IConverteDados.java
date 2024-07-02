package br.com.alura.conversor.service;

public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
