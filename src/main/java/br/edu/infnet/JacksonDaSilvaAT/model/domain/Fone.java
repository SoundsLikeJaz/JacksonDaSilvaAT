package br.edu.infnet.JacksonDaSilvaAT.model.domain;

public class Fone extends Produto {
    private boolean bluetooth;
    private boolean anc;
    private String material;

    public Fone() {
        super();
        setBluetooth(false);
        setAnc(false);
        setMaterial("Plástico");
    }

    public Fone(float preco, int garantiaMeses, String marca, boolean bluetooth) {
        super(preco, garantiaMeses, marca);
        setBluetooth(bluetooth);
    }

    public Fone(float preco, int garantiaMeses, String marca, boolean bluetooth, boolean anc) {
        this(preco, garantiaMeses, marca, bluetooth);
        setBluetooth(bluetooth);
    }

    public Fone(float preco, int garantiaMeses, String marca, boolean bluetooth, boolean anc, String material) {
        this(preco, garantiaMeses, marca, bluetooth, anc);
        setMaterial(material);
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isAnc() {
        return anc;
    }

    public void setAnc(boolean anc) {
        this.anc = anc;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) throws IllegalArgumentException {
        if(!material.isEmpty()) this.material = material;
        else throw new IllegalArgumentException("Erro: Material desconhecido.");
    }

    @Override
    public String toString() {
        return String.format("%s, Material: %s, Bluetooth: %s, ANC: %s",
                super.toString(),
                getMaterial(),
                isBluetooth() ? "Possui" : "Não possui",
                isAnc() ? "Possui" : "Não possui");
    }
}