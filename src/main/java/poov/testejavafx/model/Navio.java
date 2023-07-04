package poov.testejavafx.model;

import java.util.ArrayList;

public class Navio {

    private int tamanho;
    private int status; // 0 afundado 1 ativo
    private ArrayList<Posicao> posicoes = new ArrayList<>();

    public Navio(int tamanho) {
        this.tamanho = tamanho;
        status = 1;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ArrayList<Posicao> getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(ArrayList<Posicao> posicoes) {
        this.posicoes = posicoes;
    }

}
