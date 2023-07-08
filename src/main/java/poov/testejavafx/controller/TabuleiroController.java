package poov.testejavafx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import poov.testejavafx.App;
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

    public static int linIni;
    public static int colIni;
    public static int aux;
    public static Scene scene2;

    public TabuleiroController() {
        System.out.println("Construtor executado.");
    }

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

        // System.out.println("initialize 1 rodando");

        // tfJogador.appendText("1");

        // Primeiro: colocar porta-aviões (5 posições)
        // Escolha a posição inicial do porta avião:
        // App.posicionando = true;
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

        /// ArrayList<Posicao> posClicadas = new ArrayList<>();

        @Override
        public void handle(ActionEvent event) {
            Button botaoClicado = (Button) event.getSource();

            // Obtenção da linha e coluna do botão clicado.
            int linha = GridPane.getRowIndex(botaoClicado);
            int coluna = GridPane.getColumnIndex(botaoClicado);

            if (App.status == Status.POSICIONAMENTO && App.cont < 6) {
                if (App.vezJogador == 1) {
                    Button targetButton = null;
                    Boolean coincide = false;
                    if (rbVertical.isSelected()) {

                        if ((linha + App.navios1.get(App.cont).getTamanho()) > 10) {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.initModality(Modality.WINDOW_MODAL);
                            alert.setTitle("INVÁLIDO");
                            alert.setHeaderText("Posição Inválida!");
                            alert.setContentText("Por favor, tente novamente.");
                            alert.showAndWait();
                            App.cont--;
                        } else {
                            for (int i = linha; i < linha + App.navios1.get(App.cont).getTamanho(); i++) {
                                if (App.tabuleiro1.getPosicao(i, coluna).getNavio() != null) {
                                    coincide = true;
                                }
                            }

                            if (coincide) {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.initModality(Modality.WINDOW_MODAL);
                                alert.setTitle("INVÁLIDO");
                                alert.setHeaderText("Posição Inválida!");
                                alert.setContentText("Por favor, tente novamente.");
                                alert.showAndWait();
                                App.cont--;
                            } else {
                                for (int i = linha; i < linha + App.navios1.get(App.cont).getTamanho(); i++) {
                                    App.tabuleiro1.getPosicao(i, coluna).setTemNavio(true);
                                    App.tabuleiro1.getPosicao(i, coluna).setNavio(App.navios1.get(App.cont));
                                    App.navios1.get(App.cont).getPosicoes().add(App.tabuleiro1.getPosicao(i, coluna));
                                    System.out.println(App.navios1.get(App.cont).getPosicoes().toString());

                                    for (Node node : grid.getChildren()) {
                                        if (GridPane.getRowIndex(node) == i
                                                && GridPane.getColumnIndex(node) == coluna) {
                                            if (node instanceof Button) {
                                                targetButton = (Button) node;
                                                targetButton.setStyle("-fx-background-color: gray");
                                                break;
                                            }
                                        }
                                    }
                                    // button.setStyle("-fx-background-color: green");
                                }
                            }

                        }

                        // Verificar se as posições do navio são válidas.
                        // Se elas estão dentro do tabuleiro
                        // Se elas não passam encima de outro navio já posicionado.

                    } else {
                        if ((coluna + App.navios1.get(App.cont).getTamanho()) > 10) {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.initModality(Modality.WINDOW_MODAL);
                            alert.setTitle("INVÁLIDO");
                            alert.setHeaderText("Posição Inválida!");
                            alert.setContentText("Por favor, tente novamente.");
                            alert.showAndWait();
                            App.cont--;
                        } else {
                            for (int i = coluna; i < coluna + App.navios1.get(App.cont).getTamanho(); i++) {
                                if (App.tabuleiro1.getPosicao(linha, i).getNavio() != null) {
                                    coincide = true;
                                }
                            }

                            if (coincide) {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.initModality(Modality.WINDOW_MODAL);
                                alert.setTitle("INVÁLIDO");
                                alert.setHeaderText("Posição Inválida!");
                                alert.setContentText("Por favor, tente novamente.");
                                alert.showAndWait();
                                App.cont--;
                            } else {
                                for (int i = coluna; i < coluna + App.navios1.get(App.cont).getTamanho(); i++) {
                                    App.tabuleiro1.getPosicao(linha, i).setTemNavio(true);
                                    App.tabuleiro1.getPosicao(linha, i).setNavio(App.navios1.get(App.cont));
                                    App.navios1.get(App.cont).getPosicoes().add(App.tabuleiro1.getPosicao(linha, i));
                                    System.out.println(App.navios1.get(App.cont).getPosicoes().toString());

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

                        }
                    }
                } else if (App.vezJogador == 2) {
                    if (App.cont == -1) {
                        try {
                            scene2 = new Scene(App.loadFXML("tabuleiro2"));
                            Stage stage = (Stage) botaoClicado.getScene().getWindow();
                            stage.setScene(scene2);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    } else {
                        Button targetButton = null;
                        Boolean coincide = false;
                        if (rbVertical.isSelected()) {

                            if ((linha + App.navios2.get(App.cont).getTamanho()) > 10) {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.initModality(Modality.WINDOW_MODAL);
                                alert.setTitle("INVÁLIDO");
                                alert.setHeaderText("Posição Inválida!");
                                alert.setContentText("Por favor, tente novamente.");
                                alert.showAndWait();
                                App.cont--;
                            } else {
                                for (int i = linha; i < linha + App.navios2.get(App.cont).getTamanho(); i++) {
                                    if (App.tabuleiro2.getPosicao(i, coluna).getNavio() != null) {
                                        coincide = true;
                                    }
                                }

                                if (coincide) {
                                    Alert alert = new Alert(AlertType.WARNING);
                                    alert.initModality(Modality.WINDOW_MODAL);
                                    alert.setTitle("INVÁLIDO");
                                    alert.setHeaderText("Posição Inválida!");
                                    alert.setContentText("Por favor, tente novamente.");
                                    alert.showAndWait();
                                    App.cont--;
                                } else {
                                    for (int i = linha; i < linha + App.navios2.get(App.cont).getTamanho(); i++) {
                                        App.tabuleiro2.getPosicao(i, coluna).setTemNavio(true);
                                        App.tabuleiro2.getPosicao(i, coluna).setNavio(App.navios2.get(App.cont));
                                        App.navios2.get(App.cont).getPosicoes()
                                                .add(App.tabuleiro2.getPosicao(i, coluna));
                                        System.out.println(App.navios2.get(App.cont).getPosicoes().toString());
                                        for (Node node : grid.getChildren()) {
                                            if (GridPane.getRowIndex(node) == i
                                                    && GridPane.getColumnIndex(node) == coluna) {
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

                        } else {

                            if ((coluna + App.navios2.get(App.cont).getTamanho()) > 10) {
                                Alert alert = new Alert(AlertType.WARNING);
                                alert.initModality(Modality.WINDOW_MODAL);
                                alert.setTitle("INVÁLIDO");
                                alert.setHeaderText("Posição Inválida!");
                                alert.setContentText("Por favor, tente novamente.");
                                alert.showAndWait();
                                App.cont--;
                            } else {
                                for (int i = coluna; i < coluna + App.navios2.get(App.cont).getTamanho(); i++) {
                                    if (App.tabuleiro2.getPosicao(linha, i).getNavio() != null) {
                                        coincide = true;
                                    }
                                }

                                if (coincide) {
                                    Alert alert = new Alert(AlertType.WARNING);
                                    alert.initModality(Modality.WINDOW_MODAL);
                                    alert.setTitle("INVÁLIDO");
                                    alert.setHeaderText("Posição Inválida!");
                                    alert.setContentText("Por favor, tente novamente.");
                                    alert.showAndWait();
                                    App.cont--;
                                } else {
                                    for (int i = coluna; i < coluna + App.navios2.get(App.cont).getTamanho(); i++) {
                                        App.tabuleiro2.getPosicao(linha, i).setTemNavio(true);
                                        App.tabuleiro2.getPosicao(linha, i).setNavio(App.navios2.get(App.cont));
                                        App.navios2.get(App.cont).getPosicoes()
                                                .add(App.tabuleiro2.getPosicao(linha, i));
                                        System.out.println(App.navios2.get(App.cont).getPosicoes().toString());
                                        for (Node node : grid.getChildren()) {
                                            if (GridPane.getRowIndex(node) == linha
                                                    && GridPane.getColumnIndex(node) == i) {
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

                        }
                    }
                }

                App.cont++;

                if (App.cont == 6 && App.vezJogador == 1) {
                    App.cont = -1;
                    App.vezJogador = 2;
                    // tfJogador.clear();
                    // tfJogador.appendText("2");
                } else if (App.cont == 6 && App.vezJogador == 2) {
                    App.status = Status.ACAO;
                    App.vezJogador = 1;
                    App.cont = -1;
                }

            } else if (App.status == Status.ACAO) {
                Boolean afundou;
                Boolean ganhou;
                Stage stage;

                if (App.cont == -1) {
                    try { // limpando tabuleiros
                        App.scene = new Scene(App.loadFXML("tabuleiro1"));
                        scene2 = new Scene(App.loadFXML("tabuleiro2"));
                        stage = (Stage) botaoClicado.getScene().getWindow();
                        stage.setScene(scene2);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (App.vezJogador == 1) {

                        // Isso está mudando o tabuleiro atual e não a scene que só é setada após a
                        // função acabar.
                        // Como aqui nesse momento o tabuleiro 2 está setado, estou modificando a sua
                        // label.
                        tfJogador.clear();
                        tfJogador.setText("t2j1");

                        if (App.tabuleiro2.getPosicao(linha, coluna).isAtirado() /* && App.cont != 0 */) {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.initModality(Modality.WINDOW_MODAL);
                            alert.setTitle("INVÁLIDO");
                            alert.setHeaderText("Posição Inválida!");
                            alert.setContentText("Por favor, tente novamente.");
                            alert.showAndWait();
                            App.cont--;
                        } else if (!App.tabuleiro2.getPosicao(linha, coluna).isAtirado() /* && App.cont != 0 */) {
                            App.tabuleiro2.getPosicao(linha, coluna).setAtirado(true);

                            if (App.tabuleiro2.getPosicao(linha, coluna).isTemNavio()) { // Acertou
                                botaoClicado.setText("M");

                                afundou = true;
                                // Análise se afundou
                                for (int i = 0; i < App.tabuleiro2.getPosicao(linha, coluna).getNavio().getPosicoes()
                                        .size(); i++) {
                                    if (!App.tabuleiro2.getPosicao(linha, coluna).getNavio().getPosicoes().get(i)
                                            .isAtirado()) {
                                        afundou = false;
                                    }
                                }

                                if (afundou) {
                                    App.tabuleiro2.getPosicao(linha, coluna).getNavio().setAfundado(true);

                                    ganhou = true;
                                    for (int i = 0; i < App.navios2.size(); i++) {
                                        if (!App.navios2.get(i).isAfundado()) {
                                            ganhou = false;
                                        }
                                    }

                                    if (ganhou) {
                                        ganhar(App.vezJogador);
                                    }
                                }
                            } else {
                                botaoClicado.setText("A");

                            }

                            stage = (Stage) botaoClicado.getScene().getWindow();

                            if (stage.getScene() != App.scene) {
                                stage.setScene(App.scene);
                            }

                            App.vezJogador = 2;
                        }

                    } else if (App.vezJogador == 2) {

                        // Como aqui nesse momento o tabuleiro 1 está setado, estou modificando a sua
                        // label.
                        tfJogador.clear();
                        tfJogador.setText("t1j2");

                        if (App.tabuleiro1.getPosicao(linha, coluna).isAtirado()) {
                            Alert alert = new Alert(AlertType.WARNING);
                            alert.initModality(Modality.WINDOW_MODAL);
                            alert.setTitle("INVÁLIDO");
                            alert.setHeaderText("Posição Inválida!");
                            alert.setContentText("Por favor, tente novamente.");
                            alert.showAndWait();
                        } else if (!App.tabuleiro1.getPosicao(linha, coluna).isAtirado()) {
                            App.tabuleiro1.getPosicao(linha, coluna).setAtirado(true);

                            if (App.tabuleiro1.getPosicao(linha, coluna).isTemNavio()) { // Acertou
                                botaoClicado.setText("M");

                                afundou = true;
                                for (int i = 0; i < App.tabuleiro1.getPosicao(linha, coluna).getNavio().getPosicoes()
                                        .size(); i++) {
                                    if (!App.tabuleiro1.getPosicao(linha, coluna).getNavio().getPosicoes().get(i)
                                            .isAtirado()) {
                                        afundou = false;
                                    }
                                }

                                if (afundou) {
                                    App.tabuleiro1.getPosicao(linha, coluna).getNavio().setAfundado(true);

                                    ganhou = true;
                                    for (int i = 0; i < App.navios1.size(); i++) {
                                        if (!App.navios1.get(i).isAfundado()) {
                                            ganhou = false;
                                        }
                                    }

                                    if (ganhou) {
                                        ganhar(App.vezJogador);
                                    }
                                }
                            } else {
                                botaoClicado.setText("A");
                            }

                            stage = (Stage) botaoClicado.getScene().getWindow();

                            if (stage.getScene() != scene2) {
                                stage.setScene(scene2);
                            }

                            App.vezJogador = 1;
                        }

                    }
                }

                App.cont++;
            }
        }

        private void ganhar(int vencedor) {
            System.out.println("O jogador " + vencedor + " ganhou a partida!");
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initModality(Modality.WINDOW_MODAL);
            alert.setTitle("FIM DE JOGO");
            alert.setHeaderText("Temos um Vencedor!");
            alert.setContentText("O jogador " + vencedor + " venceu a partida!");
            alert.showAndWait();

            Platform.exit();
        }
    }
}
