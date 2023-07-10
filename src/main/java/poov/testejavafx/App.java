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
    public static int vezJogador;
    public static int cont = 0;

    @Override
    public void start(Stage stage) throws IOException {
        inicializacao();

        status = Status.POSICIONAMENTO;
        vezJogador = 1;
        scene = new Scene(loadFXML("tabuleiro1"));
        stage.setScene(scene);
        stage.show();
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
