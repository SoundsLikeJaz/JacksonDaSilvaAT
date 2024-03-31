package br.edu.infnet.JacksonDaSilvaAT.model.service;

import br.edu.infnet.JacksonDaSilvaAT.model.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ClienteService {
    private static Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();

    private static Integer id = 0;

    public static void incluir(Cliente cliente) {

        cliente.setId(++id);

        clientes.put(cliente.getId(), cliente);
    }

    public static void excluir(Integer id) {
        clientes.remove(id);
    }

    public static Collection<Cliente> obterLista() {
        return clientes.values();
    }

    public static Cliente obterPorId(Integer id) {
        return clientes.get(id);
    }
}