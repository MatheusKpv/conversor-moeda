package com.one.conversormoeda.util;

import com.one.conversormoeda.enums.OpcoesMoeda;

import java.util.Arrays;

public class ConsoleUtil {

    public static String getMensagemOpcao(final boolean conversaoOrigem) {
        final var sb = new StringBuilder();
        sb.append(conversaoOrigem
                ? "Selecione a moeda que deseja converter:"
                : "Selecione a moeda que o valor será convertido:");
        sb.append("\n");

        Arrays.stream(OpcoesMoeda.values()).forEach(opcao -> {
            sb.append(opcao.getValor().toString());
            sb.append(") ");
            sb.append(opcao.getDescricao());
            sb.append("\n");
        });

        sb.append(OpcoesMoeda.values().length + 1)
                .append(") Sair")
                .append("\n");

        return sb.toString();
    }

    public static String getSeparador() {
        return """
                
                - - - - - - - - - - - - - - - - - -\
                
                """;
    }
}
