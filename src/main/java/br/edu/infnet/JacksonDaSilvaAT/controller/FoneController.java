package br.edu.infnet.JacksonDaSilvaAT.controller;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Fone;
import br.edu.infnet.JacksonDaSilvaAT.model.service.FoneService;
import com.google.gson.Gson;
import spark.Route;

public class FoneController {
    public static Route obterLista = (req, res) -> {

        return FoneService.obterLista();
    };

    public static Route incluir = (req, res) -> {

        Fone fone = new Gson().fromJson(req.body(), Fone.class);

        FoneService.incluir(fone);

        return "Inclusão realizada com sucesso: " + fone + "!";
    };

    public static Route excluir = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        Fone fone = FoneService.obterPorId(index);

        FoneService.excluir(index);

        return "Exclusão realizada com sucesso: " + fone + "!";
    };

    public static Route obter = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        Fone fone = FoneService.obterPorId(index);

        return "Recuperação realizada com sucesso: " + fone + "!";
    };
}