package br.edu.infnet.JacksonDaSilvaAT.model.domain;

public class Celular extends Produto {
    private int memoriaRam;
    private int armazenamento;
    private boolean cincoG;

    public Celular() {
        super();
        setMemoriaRam(2);
        setArmazenamento(16);
        setCincoG(false);
    }

    public Celular(float preco, int garantiaMeses, String marca, int memoriaRam) {
        super(preco, garantiaMeses, marca);
        setMemoriaRam(memoriaRam);
    }

    public Celular(float preco, int garantiaMeses, String marca, int memoriaRam, int armazenamento) {
        this(preco, garantiaMeses, marca, memoriaRam);
        setArmazenamento(armazenamento);
    }

    public Celular(float preco, int garantiaMeses, String marca, int memoriaRam, int armazenamento, boolean cincoG) {
        this(preco, garantiaMeses, marca, memoriaRam, armazenamento);
        setCincoG(cincoG);
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) throws IllegalArgumentException {
        if(memoriaRam < 2) throw new IllegalArgumentException("Erro: Capacidade de memória ram abaixo do aceitável " +
                "para vendas.");
        else this.memoriaRam = memoriaRam;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) throws IllegalArgumentException {
        if(armazenamento < 16) throw new IllegalArgumentException("Erro: Capacidade de armazenamento abaixo do " +
                "aceitável " +
                "para vendas.");
        else this.armazenamento = armazenamento;
    }

    public boolean isCincoG() {
        return cincoG;
    }

    public void setCincoG(boolean cincoG) {
        this.cincoG = cincoG;
    }

    @Override
    public String toString() {
        return String.format("%s, Memória Ram: %d, Armazenamento Interno: %d, %sossui 5G", super.toString(),
                getMemoriaRam(), getArmazenamento(), isCincoG() ? "P" : "não p");
    }
}