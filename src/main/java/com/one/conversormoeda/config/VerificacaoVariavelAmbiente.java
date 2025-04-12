package com.one.conversormoeda.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class VerificacaoVariavelAmbiente {

    @Value("${api.key}")
    private String apiKey;

    @PostConstruct
    public void verificarVariavelAmbiente() {

        if ("INVALID".equals(apiKey)) {
            System.err.println("Erro: A variável de ambiente API_KEY_EXCHANGE_RATE não está configurada.");
            throw new RuntimeException("Variável de ambiente API_KEY_EXCHANGE_RATE não configurada. O sistema será encerrado.");
        }

        System.out.println("Variável de ambiente API_KEY_EXCHANGE_RATE configurada com sucesso.");
    }
}
