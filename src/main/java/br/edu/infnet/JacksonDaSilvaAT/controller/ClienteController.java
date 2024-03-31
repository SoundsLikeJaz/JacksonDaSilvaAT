package br.edu.infnet.JacksonDaSilvaAT.controller;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Cliente;
import br.edu.infnet.JacksonDaSilvaAT.model.service.ClienteService;
import com.google.gson.Gson;
import spark.Route;

public class ClienteController {
    public static Route obterLista = (req, res) -> {

        return ClienteService.obterLista();
    };

    public static Route incluir = (req, res) -> {

        Cliente cliente = new Gson().fromJson(req.body(), Cliente.class);

        ClienteService.incluir(cliente);

        return "Inclusão realizada com sucesso: " + cliente + "!";
    };

    public static Route excluir = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        Cliente cliente = ClienteService.obterPorId(index);

        ClienteService.excluir(index);

        return "Exclusão realizada com sucesso: " + cliente + "!";
    };

    public static Route obter = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        Cliente cliente = ClienteService.obterPorId(index);

        return "Recuperação realizada com sucesso: " + cliente + "!";
    };
}