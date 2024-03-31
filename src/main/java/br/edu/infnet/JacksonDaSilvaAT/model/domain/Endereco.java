package br.edu.infnet.JacksonDaSilvaAT.model.domain;

public class Endereco {
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    public Endereco() {

    }

    public Endereco(String cep) {
        this();
        setCep(cep);
    }

    public Endereco(String cep, String logradouro) {
        this(cep);
        setLogradouro(logradouro);
    }

    public Endereco(String cep, String logradouro, String bairro) {
        this(cep, logradouro);
        setBairro(bairro);
    }

    public Endereco(String cep, String logradouro, String bairro, String localidade) {
        this(cep, logradouro, bairro);
        setLocalidade(localidade);
    }

    public Endereco(String cep, String logradouro, String bairro, String localidade, String uf) {
        this(cep, logradouro, bairro, localidade);
        setUf(uf);
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return String.format("CEP: %s, Logradouro: %s, Bairro: %s, Localidade: %s, UF: %s",
                getCep(), getLogradouro(), getBairro(), getLocalidade(), getUf());
    }
}