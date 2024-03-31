package br.edu.infnet.JacksonDaSilvaAT.model.domain;

public class Computador extends Produto {
    private int memoriaRam;
    private int armazenamento;
    private boolean ssd;
    private String processador;

    public Computador() {
        super();
        setMemoriaRam(2);
        setArmazenamento(16);
        setSsd(false);
        setProcessador("Ryzen 3");
    }

    public Computador(float preco, int garantiaMeses, String marca, int memoriaRam) {
        super(preco, garantiaMeses, marca);
        setMemoriaRam(memoriaRam);
    }

    public Computador(float preco, int garantiaMeses, String marca, int memoriaRam, int armazenamento) {
        this(preco, garantiaMeses, marca, memoriaRam);
        setArmazenamento(armazenamento);
    }

    public Computador(float preco, int garantiaMeses, String marca, int memoriaRam, int armazenamento, boolean ssd) {
        this(preco, garantiaMeses, marca, memoriaRam, armazenamento);
        setSsd(ssd);
    }

    public Computador(float preco, int garantiaMeses, String marca, int memoriaRam, int armazenamento, boolean ssd, String processador) {
        this(preco, garantiaMeses, marca, memoriaRam, armazenamento, ssd);
        setProcessador(processador);
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

    public boolean isSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) throws IllegalArgumentException {
        if(!processador.isEmpty()) this.processador = processador;
        else throw new IllegalArgumentException("Erro: Processador inválido");
    }

    @Override
    public String toString() {
        return String.format("%s, Memória Ram: %d, Armazenamento Interno: %dgb em %s, ",
                super.toString(),
                getMemoriaRam(), getArmazenamento(), isSsd() ? "SSD" : "HD ");
    }
}