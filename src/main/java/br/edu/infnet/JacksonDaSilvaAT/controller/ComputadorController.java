package br.edu.infnet.JacksonDaSilvaAT.controller;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Computador;
import br.edu.infnet.JacksonDaSilvaAT.model.service.ComputadorService;
import com.google.gson.Gson;
import spark.Route;

public class ComputadorController {
    public static Route obterLista = (req, res) -> {

        return ComputadorService.obterLista();
    };

    public static Route incluir = (req, res) -> {

        Computador computador = new Gson().fromJson(req.body(), Computador.class);

        ComputadorService.incluir(computador);

        return "Inclusão realizada com sucesso: " + computador + "!";
    };

    public static Route excluir = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        Computador computador = ComputadorService.obterPorId(index);

        ComputadorService.excluir(index);

        return "Exclusão realizada com sucesso: " + computador + "!";
    };

    public static Route obter = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        Computador computador = ComputadorService.obterPorId(index);

        return "Recuperação realizada com sucesso: " + computador + "!";
    };
}