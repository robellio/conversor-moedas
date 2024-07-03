package br.com.alura.conversor.principal;

import br.com.alura.conversor.model.DadosMoeda;
import br.com.alura.conversor.service.ApiConnection;
import br.com.alura.conversor.service.ConverteDados;

import java.util.Scanner;

public class Principal {
    private final String ENDERECO = "https://v6.exchangerate-api.com/v6/57f65ce9e25c39a3bd68a3ee/latest/USD";
    private Scanner leitura = new Scanner(System.in);
    private ApiConnection apiConnection = new ApiConnection();
    private ConverteDados converteDados = new ConverteDados();

    public Principal() {
        while (true) {
            exibirMenu();
        }
    }

    public void exibirMenu() {
        System.out.println();
        var menu = """
                Conversor de Moedas
                Escolha uma opção:
                1. Para Converter moeda
                2. Sair
                """;

        System.out.println(menu);
        int opcao = leitura.nextInt();

        switch (opcao) {
            case 1:
                converterMoeda();
                break;
            case 2:
                System.out.println("Saindo da aplicação...");
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private void converterMoeda() {
        System.out.print("Digite a moeda de origem (exemplo: USD ou GBP): ");
        String moedaOrigem = leitura.next().toUpperCase();
        System.out.print("Digite a moeda de destino (exemplo: EUR OU JPY): ");
        String moedaDestino = leitura.next().toUpperCase();
        System.out.print("Digite o valor a ser convertido: ");
        double valor = leitura.nextDouble();

        String json = apiConnection.obterDados(ENDERECO);
        DadosMoeda dadosMoeda = converteDados.obterDados(json, DadosMoeda.class);

        if (dadosMoeda.taxasConversao().containsKey(moedaOrigem) && dadosMoeda.taxasConversao().containsKey(moedaDestino)) {
            double taxaOrigem = dadosMoeda.taxasConversao().get(moedaOrigem);
            double taxaDestino = dadosMoeda.taxasConversao().get(moedaDestino);
            double valorConvertido = valor * (taxaDestino / taxaOrigem);

            System.out.printf("Valor convertido: %.2f %s\n", valorConvertido, moedaDestino);
        } else {
            System.out.println("Moeda não encontrada.");
        }
    }
}
