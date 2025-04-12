package com.one.conversormoeda.model;

import com.one.conversormoeda.enums.OpcoesMoeda;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Getter
@Setter
@AllArgsConstructor
public class MoedaParam {

    private boolean conversaoOrigem;

    private BigDecimal valor;

    private OpcoesMoeda moedaOrigem;

    private OpcoesMoeda moedaDestino;

    public BigDecimal getValor() {
        if (this.valor.scale() < 2) {
            return this.valor.setScale(2, RoundingMode.DOWN);
        }

        return this.valor;
    }
}
