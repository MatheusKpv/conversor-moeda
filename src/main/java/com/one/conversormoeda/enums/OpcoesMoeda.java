package com.one.conversormoeda.enums;

import lombok.Getter;

@Getter
public enum OpcoesMoeda {

    BRL(1, "Real"),
    USD(2, "Dólar"),
    ARS(3, "Peso Argentino"),
    COP(4, "Peso Colombiano"),
    EUR(5, "Euro");

    final Integer valor;
    final String descricao;

    OpcoesMoeda(Integer valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public static OpcoesMoeda getByValue(Integer valor) {
        for (OpcoesMoeda opcao : OpcoesMoeda.values()) {
            if (opcao.valor.equals(valor)) {
                return opcao;
            }
        }

        return null;
    }
}
