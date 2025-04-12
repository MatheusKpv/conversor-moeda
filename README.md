# 💱 Conversor de Moedas - Java (Console)

Este é um projeto simples em Java que permite a conversão de moedas diretamente pelo console. Ele utiliza uma **API externa de taxas de câmbio** para obter os valores atualizados e realiza os cálculos conforme os dados fornecidos pelo usuário.

---

## 🚀 Como Funciona

O programa solicita ao usuário:

1. A moeda de origem (ex: `USD`)
2. A moeda de destino (ex: `BRL`)
3. O valor a ser convertido

Com base nessas informações, ele consulta uma API de taxas de câmbio e retorna o valor convertido.

---

## ⚙️ Requisitos

- Java 21 ou superior
- Acesso à internet (para consultar a API de câmbio)
- Uma **chave de API** válida do serviço de câmbio utilizado ([ExchangeRate API](https://www.exchangerate-api.com/))

---

## 🔐 Configuração da API Key

Antes de executar o programa, você deve configurar uma variável de ambiente chamada:

```bash
API_KEY_EXCHANGE_RATE
