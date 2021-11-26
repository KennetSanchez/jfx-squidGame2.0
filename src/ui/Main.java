package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Game;

public class Main extends Application {

    private Game game = new Game();
    private GameGUIController controller = new GameGUIController(game);

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/startMenu.fxml")); //Se cambia por el fxml inicial
        fxmlLoader.setController(controller);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("SquidGame 2.0");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

}
