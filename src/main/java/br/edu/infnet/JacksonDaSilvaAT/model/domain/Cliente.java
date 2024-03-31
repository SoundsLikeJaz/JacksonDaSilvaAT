package br.edu.infnet.JacksonDaSilvaAT.model.domain;

import br.edu.infnet.JacksonDaSilvaAT.controller.ViacepController;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String cep;
    private List<Produto> Carrinho = new ArrayList<>();
    private Endereco endereco;

    public Cliente() {

    }

    public Cliente(String nome) {
        setNome(nome);
    }

    public Cliente(String nome, String cpf) {
        this(nome);
        setCpf(cpf);
    }

    public Cliente(String nome, String cpf, String cep) {
        this(nome, cpf);
        setCep(cep);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if(!nome.isEmpty()) this.nome = nome;
        else throw new IllegalArgumentException("Erro: Nome inválido.");
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws IllegalArgumentException {
        if(!cpf.isEmpty()) this.cpf = cpf;
        else throw new IllegalArgumentException("Erro: CPF inválido.");
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) throws IllegalArgumentException {
        if(!cep.isEmpty()) {
            cep = cep.replaceAll("\\D+", "");
                this.cep = cep;
                endereco = ViacepController.obterEndereco(getCep());
        } else throw new IllegalArgumentException("Erro: CEP vazio.");
    }

    public void addCarrinho(Produto produto) {
        Carrinho.add(produto);
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.Carrinho = carrinho;
    }

    public List<Produto> getCarrinho() {
        return Carrinho;
    }

    public StringBuilder listarProdutos() {
        StringBuilder lista = new StringBuilder();
        for(Produto produto : Carrinho) {
            lista.append(produto).append("\n");
        }
        return lista;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Nome: %s, CPF: %s, Carrinho: %s \nEndereço: %s",
                getId(),
                getNome(),
                getCpf(),
                Carrinho.isEmpty() ? "Vazio." : listarProdutos(),
                ViacepController.obterEndereco(getCep()));
    }
}