package poov.testejavafx.model;

public class Posicao {

    private int linha;
    private int coluna;
    private boolean atirado = false;
    private boolean temNavio = false;
    private Navio navio = null;

    
    // talvez criar variável acertou.

    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public boolean isAtirado() {
        return atirado;
    }

    public void setAtirado(boolean atirado) {
        this.atirado = atirado;
    }

    @Override
    public String toString() {
        return "Posicao [linha=" + linha + ", coluna=" + coluna + "]";
    }

    public boolean isTemNavio() {
        return temNavio;
    }

    public void setTemNavio(boolean temNavio) {
        this.temNavio = temNavio;
    }

    public Navio getNavio() {
        return navio;
    }

    public void setNavio(Navio navio) {
        this.navio = navio;
    }

}
