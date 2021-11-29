package ui;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

import java.io.*;

public class Main extends Application {

    private Game game;
    private GameGUIController controller;
    private static final String GAME_PATH_FILE = "data/savedData.xd";

    public Main(){
        game=new Game();
        loadGameData();
        controller = new GameGUIController(game);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("resources/startMenu.fxml")); //Se cambia por el fxml inicial
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SquidGame 2.0");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void loadGameData() {
        File f = new File(GAME_PATH_FILE);
        if (f.exists()) {
            ObjectInputStream ois;
            try {
                ois = new ObjectInputStream(new FileInputStream(f));
                game = (Game) ois.readObject();
                ois.close();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("File is empty or something else went wrong.");
            }
        }
    }

    @Override
    public void stop() {
        game.initializeGame();
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(GAME_PATH_FILE));
            oos.writeObject(game);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Platform.exit();
        System.exit(0);
        controller.stopTimer();
    }

}
