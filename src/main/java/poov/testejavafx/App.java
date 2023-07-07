package poov.testejavafx;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import poov.testejavafx.model.Navio;
import poov.testejavafx.model.Status;
import poov.testejavafx.model.Tabuleiro;

public class App extends Application {

    public static Scene scene;

    public static Tabuleiro tabuleiro1;
    public static Tabuleiro tabuleiro2;
    public static ArrayList<Navio> navios1;
    public static ArrayList<Navio> navios2;
    public static Status status;
    public static int momento;
    public static int vezJogador;
    public static boolean posicionando;
    public static boolean posicionamento1;
    public static boolean posicionamento2;

    @Override
    public void start(Stage stage) throws IOException {
        // status = Status.INICIALIZACAO;
        inicializacao();

        // posicionando = false;
        status = Status.POSICIONAMENTO;
        vezJogador = 1;
        scene = new Scene(loadFXML("tabuleiro1"));
        stage.setScene(scene);
        stage.show();
        /*
         * 
         * scene2 = new Scene(loadFXML("tabuleiro2"));
         * 
         * //setar botões do tabuleiro 1
         * /*
         * while (posicionando == true) {
         * 
         * while (vezJogador == 1) {
         * // posicionamento jogador 1
         * // Mostrando o tabuleiro 1
         * 
         * // verificação se a vez do 2 já acabou é feita no handle
         * if (vezJogador == 2) {
         * scene2 = new Scene(loadFXML("tabuleiro2"));
         * stage.setScene(scene2);
         * stage.show();
         * 
         * //setar botões do tabuleiro 2
         * }
         * }
         * 
         * while (vezJogador == 2) {
         * 
         * }
         * }
         */

        // Aqui é um sequencial que posso usar como orientação do jogo
        // ou tenho que fazer tudo orientado a eventos no handle?

    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

    public void inicializacao() {
        tabuleiro1 = new Tabuleiro(1);
        tabuleiro2 = new Tabuleiro(2);

        // Os tabuleiros já estão com suas posições criadas.

        navios1 = new ArrayList<>();

        Navio navio = new Navio(5);
        navios1.add(navio);
        navio = new Navio(4);
        navios1.add(navio);
        navio = new Navio(4);
        navios1.add(navio);
        navio = new Navio(2);
        navios1.add(navio);
        navio = new Navio(2);
        navios1.add(navio);
        navio = new Navio(2);
        navios1.add(navio);

        navios2 = new ArrayList<>();
        navio = new Navio(5);
        navios2.add(navio);
        navio = new Navio(4);
        navios2.add(navio);
        navio = new Navio(4);
        navios2.add(navio);
        navio = new Navio(2);
        navios2.add(navio);
        navio = new Navio(2);
        navios2.add(navio);
        navio = new Navio(2);
        navios2.add(navio);
    }

}
