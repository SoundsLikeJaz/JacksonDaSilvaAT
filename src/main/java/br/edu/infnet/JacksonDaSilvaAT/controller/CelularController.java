package br.edu.infnet.JacksonDaSilvaAT.controller;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Celular;
import br.edu.infnet.JacksonDaSilvaAT.model.service.CelularService;
import com.google.gson.Gson;
import spark.Route;

public class CelularController {
    public static Route obterLista = (req, res) -> {

        return CelularService.obterLista();
    };

    public static Route incluir = (req, res) -> {

        Celular celular = new Gson().fromJson(req.body(), Celular.class);

        CelularService.incluir(celular);

        return "Inclusão realizada com sucesso: " + celular + "!";
    };

    public static Route excluir = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        Celular celular = CelularService.obterPorId(index);

        CelularService.excluir(index);

        return "Exclusão realizada com sucesso: " + celular + "!";
    };

    public static Route obter = (req, res) -> {

        Integer index = Integer.valueOf(req.params("id"));

        Celular celular = CelularService.obterPorId(index);

        return celular;
    };
}