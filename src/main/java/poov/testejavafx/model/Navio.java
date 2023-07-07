package poov.testejavafx.model;

import java.util.ArrayList;

public class Navio {

    private int tamanho;
    private boolean afundado = false; 
    private ArrayList<Posicao> posicoes = new ArrayList<>();

    public Navio(int tamanho) {
        this.tamanho = tamanho;
        afundado = false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isAfundado() {
        return afundado;
    }

    public void setAfundado(boolean afundado) {
        this.afundado = afundado;
    }

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(ArrayList<Posicao> posicoes) {
        this.posicoes = posicoes;
    }
}
