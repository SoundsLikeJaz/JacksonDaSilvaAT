package br.edu.infnet.JacksonDaSilvaAT.model.service;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Computador;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ComputadorService {
    private static Map<Integer, Computador> computadores = new HashMap<Integer, Computador>();

    private static Integer id = 0;

    public static void incluir(Computador computador) {

        computador.setId(++id);

        computadores.put(computador.getId(), computador);
    }

    public static void excluir(Integer id) {
        computadores.remove(id);
    }

    public static Collection<Computador> obterLista() {
        return computadores.values();
    }

    public static Computador obterPorId(Integer id) {
        return computadores.get(id);
    }
}