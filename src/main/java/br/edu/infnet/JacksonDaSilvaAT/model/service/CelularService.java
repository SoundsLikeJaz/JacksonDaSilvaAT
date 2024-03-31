package br.edu.infnet.JacksonDaSilvaAT.model.service;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Celular;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CelularService {
    private static Map<Integer, Celular> celulares = new HashMap<Integer, Celular>();

    private static Integer id = 0;

    public static void incluir(Celular celular) {

        celular.setId(++id);

        celulares.put(celular.getId(), celular);
    }

    public static void excluir(Integer id) {
        celulares.remove(id);
    }

    public static Collection<Celular> obterLista() {
        return celulares.values();
    }

    public static Celular obterPorId(Integer id) {
        return celulares.get(id);
    }
}