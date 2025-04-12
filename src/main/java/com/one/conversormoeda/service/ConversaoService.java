package com.one.conversormoeda.service;

import com.google.gson.Gson;
import com.one.conversormoeda.model.ConversaoDto;
import com.one.conversormoeda.model.MoedaParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ConversaoService {

    @Value("${api.key}")
    private String apiKey;

    private final HttpClient client = HttpClient.newHttpClient();
    private final Gson gson = new Gson();

    public BigDecimal converter(MoedaParam param) {
        try {
            var url = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s/%s"
                    .formatted(apiKey, param.getMoedaOrigem(), param.getMoedaDestino(), param.getValor());

            var request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return gson.fromJson(response.body(), ConversaoDto.class).getResultadoConversao();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Erro na conversão de moeda", e);
        }
    }
}
