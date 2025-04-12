package com.one.conversormoeda.controller;

import com.one.conversormoeda.enums.OpcoesMoeda;
import com.one.conversormoeda.model.MoedaParam;
import com.one.conversormoeda.service.ConversaoService;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;

import static com.one.conversormoeda.util.ConsoleUtil.getMensagemOpcao;
import static com.one.conversormoeda.util.ConsoleUtil.getSeparador;
import static com.one.conversormoeda.util.InputHelper.lerBigDecimal;
import static com.one.conversormoeda.util.InputHelper.lerInteger;

@Controller
public class ConversaoController {

    private static final int OPCAO_SAIR = OpcoesMoeda.values().length + 1;
    private final ConversaoService service;

    public ConversaoController(ConversaoService service) {
        this.service = service;
    }

    public void iniciarConversao() {
        System.out.println(getSeparador());
        System.out.println("Seja bem vindo ao conversor de moeda!");

        final var moedaParam = new MoedaParam(true, BigDecimal.ZERO, null, null);
        Integer opcao;

        do {
            System.out.println(getSeparador());
            System.out.println(getMensagemOpcao(moedaParam.isConversaoOrigem()));

            opcao = lerInteger("R: ");

            if (opcao >= 1 && opcao <= 5) {
                if (moedaParam.isConversaoOrigem()) {
                    System.out.println(getSeparador());

                    moedaParam.setValor(lerBigDecimal("Digite o valor que deseja converter: "));
                    moedaParam.setConversaoOrigem(false);
                    moedaParam.setMoedaOrigem(OpcoesMoeda.getByValue(opcao));
                } else {
                    moedaParam.setConversaoOrigem(true);
                    moedaParam.setMoedaDestino(OpcoesMoeda.getByValue(opcao));

                    System.out.println(getSeparador());
                    System.out.println(getMensagemResultado(moedaParam));
                }
            }

            if (opcao < 1 || opcao > OPCAO_SAIR) {
                System.out.println(getSeparador());
                System.out.println("Valor invalido!");
            }
        } while (!opcao.equals(OPCAO_SAIR));

        System.out.println(getSeparador());
        System.out.println("-     Saindo... Até a próxima!    -");
        System.out.println(getSeparador());
    }

    private String getMensagemResultado(MoedaParam moedaParam) {
        return moedaParam.getMoedaOrigem().toString()
                .concat(" -> ")
                .concat(moedaParam.getValor().toString())
                .concat("\n")
                .concat(moedaParam.getMoedaDestino().toString())
                .concat(" -> ")
                .concat(service.converter(moedaParam).toString());
    }
}
