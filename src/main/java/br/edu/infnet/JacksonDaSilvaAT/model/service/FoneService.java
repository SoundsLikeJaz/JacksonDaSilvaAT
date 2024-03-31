package br.edu.infnet.JacksonDaSilvaAT.model.service;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Fone;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FoneService {
    private static Map<Integer, Fone> fones = new HashMap<Integer, Fone>();

    private static Integer id = 0;

    public static void incluir(Fone fone) {

        fone.setId(++id);

        fones.put(fone.getId(), fone);
    }

    public static void excluir(Integer id) {
        fones.remove(id);
    }

    public static Collection<Fone> obterLista() {
        return fones.values();
    }

    public static Fone obterPorId(Integer id) {
        return fones.get(id);
    }
}