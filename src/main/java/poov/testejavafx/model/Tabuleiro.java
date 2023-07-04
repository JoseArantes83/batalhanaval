package poov.testejavafx.model;

public class Tabuleiro {

    private Posicao[][] posicoes = new Posicao[10][10];
    private int jogador;

    public Tabuleiro(int jogador) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                posicoes[i][j] = new Posicao(i, j);
            }
        }
    }

    public Posicao getPosicao(int linha, int coluna) {
        return posicoes[linha][coluna];
    }

    public int getJogador() {
        return jogador;
    }

    public void setJogador(int jogador) {
        this.jogador = jogador;
    }

    public Posicao[][] getPosicoes() {
        return posicoes;
    }

    public void setPosicoes(Posicao[][] posicoes) {
        this.posicoes = posicoes;
    }

}
