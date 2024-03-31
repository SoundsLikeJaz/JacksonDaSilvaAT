package br.edu.infnet.JacksonDaSilvaAT;

import br.edu.infnet.JacksonDaSilvaAT.controller.CelularController;
import br.edu.infnet.JacksonDaSilvaAT.controller.ClienteController;
import br.edu.infnet.JacksonDaSilvaAT.controller.ComputadorController;
import br.edu.infnet.JacksonDaSilvaAT.controller.FoneController;
import br.edu.infnet.JacksonDaSilvaAT.model.domain.Celular;
import br.edu.infnet.JacksonDaSilvaAT.model.domain.Cliente;
import br.edu.infnet.JacksonDaSilvaAT.model.domain.Computador;
import br.edu.infnet.JacksonDaSilvaAT.model.domain.Fone;
import br.edu.infnet.JacksonDaSilvaAT.model.service.CelularService;
import br.edu.infnet.JacksonDaSilvaAT.model.service.ClienteService;
import br.edu.infnet.JacksonDaSilvaAT.model.service.ComputadorService;
import br.edu.infnet.JacksonDaSilvaAT.model.service.FoneService;
import spark.Spark;

public class App {
    public static void main(String[] args) {
        Spark.port(8080);

        Spark.get("/", (req, resp) -> {return App.class.getResourceAsStream("/index.html");});

        //CELULAR
        Spark.get("/produto/celular/lista", CelularController.obterLista);
        Spark.post("/produto/celular/incluir", CelularController.incluir);
        Spark.delete("/produto/celular/:id/excluir", CelularController.excluir);
        Spark.get("/produto/celular/:id", CelularController.obter);

        //FONE
        Spark.get("/produto/fone/lista", FoneController.obterLista);
        Spark.post("/produto/fone/incluir", FoneController.incluir);
        Spark.delete("/produto/fone/:id/excluir", FoneController.excluir);
        Spark.get("/produto/fone/:id", FoneController.obter);

        //COMPUTADOR
        Spark.get("/produto/computador/lista", ComputadorController.obterLista);
        Spark.post("/produto/computador/incluir", ComputadorController.incluir);
        Spark.delete("/produto/computador/:id/excluir", ComputadorController.excluir);
        Spark.get("/produto/computador/:id", ComputadorController.obter);

        //CLIENTE
        Spark.get("/cliente/lista", ClienteController.obterLista);
        Spark.post("/cliente/incluir", ClienteController.incluir);
        Spark.delete("/cliente/:id/excluir", ClienteController.excluir);
        Spark.get("/cliente/:id", ClienteController.obter);

        Computador com1 = new Computador(2780, 24, "Asus", 16, 256, true, "Ryzen 5");
        Computador com2 = new Computador(3500, 24, "Lenovo", 32, 516, true, "Ryzen 7");
        Computador com3 = new Computador(4200, 24, "Dell", 64, 1000, true, "Intel 9");
        Computador com4 = new Computador(1700, 12, "Samsumg", 16, 256, false, "Intel 3");
        ComputadorService.incluir(com1);
        ComputadorService.incluir(com2);
        ComputadorService.incluir(com3);
        ComputadorService.incluir(com4);

        Celular cell1 = new Celular(3500, 6, "Samsumg", 12, 256, true);
        Celular cell2 = new Celular(2100, 3, "Motorola", 6, 128, true);
        Celular cell3 = new Celular(2200, 6, "Apple", 8, 128, false);
        Celular cell4 = new Celular(5600, 12, "Samsumg", 16, 512, true);
        CelularService.incluir(cell1);
        CelularService.incluir(cell2);
        CelularService.incluir(cell3);
        CelularService.incluir(cell4);

        Fone f1 = new Fone(216, 2, "QCY", true, true, "Plástico");
        Fone f2 = new Fone(520, 4, "RedDragon", false, true, "Metal");
        Fone f3 = new Fone(260, 0, "JBL", true, false, "Silicone");
        Fone f4 = new Fone(180, 0, "QCY", false, false, "Plástico");
        FoneService.incluir(f1);
        FoneService.incluir(f2);
        FoneService.incluir(f3);
        FoneService.incluir(f4);

        Cliente cl1 = new Cliente("Jackson", "111.111.111-11", "25937-216");
        Cliente cl2 = new Cliente("Elberth", "222.222.222-22", "20010-020");
        Cliente cl3 = new Cliente("Miguel", "333.333.333-33", "20010-080");
        Cliente cl4 = new Cliente("Sophia", "444.444.444-44", "20020-070");

        cl1.addCarrinho(com1);
        cl1.addCarrinho(cell1);
        cl1.addCarrinho(f1);

        cl2.addCarrinho(com2);
        cl2.addCarrinho(cell2);
        cl2.addCarrinho(f2);

        cl3.addCarrinho(com3);
        cl3.addCarrinho(cell3);
        cl3.addCarrinho(f3);

        ClienteService.incluir(cl1);
        ClienteService.incluir(cl2);
        ClienteService.incluir(cl3);
        ClienteService.incluir(cl4);
    }
}