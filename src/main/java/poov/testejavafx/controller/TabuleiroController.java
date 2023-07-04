package poov.testejavafx.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import poov.testejavafx.App;
import poov.testejavafx.model.Posicao;
import poov.testejavafx.model.Status;

public class TabuleiroController implements Initializable {

    @FXML
    private GridPane grid;

    @FXML
    private RadioButton rbHorizontal;

    @FXML
    private RadioButton rbVertical;

    @FXML
    private TextField tfJogador;

    @FXML
    private ToggleGroup tgDisposicao;

    public static int cont = 0;
    public static int jogador = 1;
    public static int linIni;
    public static int colIni;
    public static int aux;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        EventHandler<ActionEvent> ButtonClickHandler = new ButtonClickHandler();

        int numLinhas = 10;
        int numColunas = 10;

        for (int linha = 0; linha < numLinhas; linha++) {
            for (int coluna = 0; coluna < numColunas; coluna++) {
                // Criação e configuração do botão.
                Button button = new Button();
                button.setId("botao" + linha + " " + coluna);
                GridPane.setHalignment(button, HPos.CENTER);

                // Setando função de ativação com clique no botão.
                button.setOnAction(ButtonClickHandler);

                // Configuração do botão e inserção no gridPane.
                button.setMinSize(43, 43);
                grid.add(button, linha, coluna, 1, 1);
                grid.setAlignment(Pos.CENTER);
            }
        }

        tfJogador.appendText("1");

        // Primeiro: colocar porta-aviões (5 posições)
        // Escolha a posição inicial do porta avião:
    }

    /*
     * public void posicionarBarco(Tabuleiro tabuleiro, ArrayList<Posicao> posicoes,
     * int numBarco, int linha, int coluna) {
     * Posicao posicao = null;
     * 
     * switch (numBarco) {
     * case 1: // Primeiro porta-aviões
     */

    public class ButtonClickHandler implements EventHandler<ActionEvent> {

        ArrayList<Posicao> posClicadas = new ArrayList<>();

        @Override
        public void handle(ActionEvent event) {
            Button botaoClicado = (Button) event.getSource();

            // Obtenção da linha e coluna do botão clicado.
            int linha = GridPane.getRowIndex(botaoClicado);
            int coluna = GridPane.getColumnIndex(botaoClicado);

            if (App.status == Status.POSICIONAMENTO && cont < 6) {
                if (jogador == 1) {
                    Button targetButton = null;
                    if (rbVertical.isSelected()) {

                        for (int i = linha; i < linha + App.navios1.get(cont).getTamanho(); i++) {
                            App.navios1.get(cont).getPosicoes().add(App.tabuleiro1.getPosicao(i, coluna));
                            System.out.println(App.navios1.get(cont).getPosicoes().toString());

                            for (Node node : grid.getChildren()) {
                                if (GridPane.getRowIndex(node) == i && GridPane.getColumnIndex(node) == coluna) {
                                    if (node instanceof Button) {
                                        targetButton = (Button) node;
                                        targetButton.setStyle("-fx-background-color: gray");
                                        break;
                                    }
                                }
                            }
                            // button.setStyle("-fx-background-color: green");
                        }
                    } else {
                        for (int i = coluna; i < coluna + App.navios1.get(cont).getTamanho(); i++) {
                            App.navios1.get(cont).getPosicoes().add(App.tabuleiro1.getPosicao(linha, i));
                            System.out.println(App.navios1.get(cont).getPosicoes().toString());

                            for (Node node : grid.getChildren()) {
                                if (GridPane.getRowIndex(node) == linha && GridPane.getColumnIndex(node) == i) {
                                    if (node instanceof Button) {
                                        targetButton = (Button) node;
                                        targetButton.setStyle("-fx-background-color: gray");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    Button targetButton = null;
                    if (rbVertical.isSelected()) {
                        for (int i = linha; i < linha + App.navios2.get(cont).getTamanho(); i++) {
                            App.navios2.get(cont).getPosicoes().add(App.tabuleiro2.getPosicao(i, coluna));
                            System.out.println(App.navios2.get(cont).getPosicoes().toString());
                            for (Node node : grid.getChildren()) {
                                if (GridPane.getRowIndex(node) == i && GridPane.getColumnIndex(node) == coluna) {
                                    if (node instanceof Button) {
                                        targetButton = (Button) node;
                                        targetButton.setStyle("-fx-background-color: #006400");
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        for (int i = coluna; i < coluna + App.navios2.get(cont).getTamanho(); i++) {
                            App.navios2.get(cont).getPosicoes().add(App.tabuleiro2.getPosicao(linha, i));
                            System.out.println(App.navios2.get(cont).getPosicoes().toString());
                            for (Node node : grid.getChildren()) {
                                if (GridPane.getRowIndex(node) == linha && GridPane.getColumnIndex(node) == i) {
                                    if (node instanceof Button) {
                                        targetButton = (Button) node;
                                        targetButton.setStyle("-fx-background-color: #006400");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }

                cont++;

                if (cont > 5 && jogador == 1) {
                    cont = 0;
                    jogador = 2;
                    tfJogador.clear();
                    tfJogador.appendText("2");
                }

                if (cont == 6) {
                    App.status = Status.ACAO;
                }
            } else if (App.status == Status.ACAO) {

            }
        }
    }
}
