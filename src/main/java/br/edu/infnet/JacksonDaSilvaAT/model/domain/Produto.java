package br.edu.infnet.JacksonDaSilvaAT.model.domain;

public abstract class Produto {
    private int id;
    private float preco;
    private int garantiaMeses;
    private String marca;

    public Produto() {
        this.setPreco(100000);
        this.setGarantiaMeses(0);
        this.setMarca("Piratex");
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto(float preco) {
        this();
        this.setPreco(preco);
    }

    public Produto(float preco, int garantiaMeses) {
        this(preco);
        setGarantiaMeses(garantiaMeses);
    }

    public Produto(float preco, int garantiaMeses, String marca) {
        this(preco, garantiaMeses);
        setMarca(marca);
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) throws IllegalArgumentException {
        if(preco > 0) this.preco = preco;
        else throw new IllegalArgumentException("Erro: Preço inválido.");
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) throws IllegalArgumentException {
        if(garantiaMeses > -1 && garantiaMeses < 36) this.garantiaMeses = garantiaMeses;
        else throw new IllegalArgumentException("Erro: Garantia inválida.");
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) throws IllegalArgumentException {
        this.marca = marca;
        if(!marca.isEmpty()) this.marca = marca;
        else throw new IllegalArgumentException("Erro: Marca inválida.");
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Valor: %.2f, Marca: %s, Garantia %d meses",
                getId(),
                getPreco(),
                getMarca(),
                getGarantiaMeses());
    }
}