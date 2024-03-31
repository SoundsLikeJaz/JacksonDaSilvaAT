package br.edu.infnet.JacksonDaSilvaAT.controller;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Endereco;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViacepController {
    public static Endereco obterEndereco(String cep) {
        try {
            String url = "https://viacep.com.br/ws/" + cep + "/json";
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder responseBuilder = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    responseBuilder.append(line);
                }
                reader.close();

                Gson gson = new Gson();
                return gson.fromJson(responseBuilder.toString(), Endereco.class);
            } else {
                System.out.println("Erro ao obter dados de endereço para o CEP " + cep);
            }
        } catch (Exception e) {
            System.out.println("Erro ao obter dados de endereço para o CEP " + cep + ": " + e.getMessage());
        }
        return null;
    }
}