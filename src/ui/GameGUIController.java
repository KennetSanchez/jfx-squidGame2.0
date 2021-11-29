package ui;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Game;

import javax.swing.text.Style;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class GameGUIController {
    @FXML
    private Label GAMEhintsCounter = new Label();

    @FXML
    private Label GAMElb1= new Label();

    @FXML
    private Label GAMElb2= new Label();

    @FXML
    private Label GAMElb3= new Label();

    @FXML
    private Label GAMElb4= new Label();

    @FXML
    private Label GAMElb5= new Label();

    @FXML
    private Label GAMElb6= new Label();

    @FXML
    private Label GAMElb7= new Label();

    @FXML
    private Label GAMElb8= new Label();

    @FXML
    private Label GAMElb9= new Label();

    @FXML
    private Label GAMElb10= new Label();

    @FXML
    private Label GAMElb11= new Label();

    @FXML
    private Label GAMElb12= new Label();

    @FXML
    private Label GAMElb13= new Label();

    @FXML
    private Label GAMElb14= new Label();

    @FXML
    private Label GAMElb15= new Label();

    @FXML
    private Label GAMElb16= new Label();

    @FXML
    private Label GAMElb17= new Label();

    @FXML
    private Label GAMElb18= new Label();

    @FXML
    private Label GAMElb19= new Label();

    @FXML
    private Label GAMElb20= new Label();

    @FXML
    private Label GAMElb21= new Label();

    @FXML
    private Label GAMElb22= new Label();

    @FXML
    private Label GAMElb23= new Label();

    @FXML
    private Label GAMElb24= new Label();

    @FXML
    private Label GAMElb25= new Label();

    @FXML
    private Label GAMElb26= new Label();

    @FXML
    private Label GAMElb27= new Label();

    @FXML
    private Label GAMElb28= new Label();

    @FXML
    private Label GAMElb29= new Label();

    @FXML
    private Label GAMElb30= new Label();

    @FXML
    private Label GAMElb31= new Label();

    @FXML
    private Label GAMElb32= new Label();

    @FXML
    private Label GAMElb33= new Label();

    @FXML
    private Label GAMElb34= new Label();

    @FXML
    private Label GAMElb35= new Label();

    @FXML
    private Label GAMElb36= new Label();

    @FXML
    private Label GAMElb37= new Label();

    @FXML
    private Label GAMElb38= new Label();

    @FXML
    private Label GAMElb39= new Label();

    @FXML
    private Label GAMElb40= new Label();

    @FXML
    private Label GAMElb41= new Label();

    @FXML
    private Label GAMElb42= new Label();

    @FXML
    private Label GAMElb43= new Label();

    @FXML
    private Label GAMElb44= new Label();

    @FXML
    private Label GAMElb45= new Label();

    @FXML
    private Label GAMElb46= new Label();

    @FXML
    private Label GAMElb47= new Label();

    @FXML
    private Label GAMElb48= new Label();

    @FXML
    private Label GAMElb49= new Label();

    @FXML
    private Label GAMElb50= new Label();

    @FXML
    private Label GAMElb51= new Label();

    @FXML
    private Label GAMElb52= new Label();

    @FXML
    private Label GAMElb53= new Label();

    @FXML
    private Label GAMElb54= new Label();

    @FXML
    private Label GAMElb55= new Label();

    @FXML
    private Label GAMElb56= new Label();

    @FXML
    private Label GAMElb57= new Label();

    @FXML
    private Label GAMElb58= new Label();

    @FXML
    private Label GAMElb59= new Label();

    @FXML
    private Label GAMElb60= new Label();

    @FXML
    private Label GAMElb61= new Label();

    @FXML
    private Label GAMElb62= new Label();

    @FXML
    private Label GAMElb63= new Label();

    @FXML
    private Label GAMElb64= new Label();

    @FXML
    private Label GAMElb65= new Label();

    @FXML
    private Label GAMElb66= new Label();

    @FXML
    private Label GAMElb67= new Label();

    @FXML
    private Label GAMElb68= new Label();

    @FXML
    private Label GAMElb69= new Label();

    @FXML
    private Label GAMElb70= new Label();

    @FXML
    private Label GAMElb71= new Label();

    @FXML
    private Label GAMElb72= new Label();

    @FXML
    private Label GAMElb73= new Label();

    @FXML
    private Label GAMElb74= new Label();

    @FXML
    private Label GAMElb75= new Label();

    @FXML
    private Label GAMElb76= new Label();

    @FXML
    private Label GAMElb77= new Label();

    @FXML
    private Label GAMElb78= new Label();

    @FXML
    private Label GAMElb79= new Label();

    @FXML
    private Label GAMElb80= new Label();

    @FXML
    private Label GAMElb81= new Label();

    @FXML
    private Label GAMElb82= new Label();

    @FXML
    private Label GAMElb83= new Label();

    @FXML
    private Label GAMElb84= new Label();

    @FXML
    private Label GAMElb85= new Label();

    @FXML
    private Label GAMElb86= new Label();

    @FXML
    private Label GAMElb87= new Label();

    @FXML
    private Label GAMElb88= new Label();

    @FXML
    private Label GAMElb89= new Label();

    @FXML
    private Label GAMElb90= new Label();

    @FXML
    private Label GAMElb91= new Label();

    @FXML
    private Label GAMElb92= new Label();

    @FXML
    private Label GAMElb93= new Label();

    @FXML
    private Label GAMElb94= new Label();

    @FXML
    private Label GAMElb95= new Label();

    @FXML
    private Label GAMElb96= new Label();

    @FXML
    private Label GAMElb97= new Label();

    @FXML
    private Label GAMElb98= new Label();

    @FXML
    private Label GAMElb99= new Label();

    @FXML
    private Label GAMElb100= new Label();

    @FXML
    private Label GAMElb101= new Label();

    @FXML
    private Label GAMElb102= new Label();

    @FXML
    private Label GAMElb103= new Label();

    @FXML
    private Label GAMElb104= new Label();

    @FXML
    private Label GAMElb105= new Label();

    @FXML
    private Label GAMElb106= new Label();

    @FXML
    private Label GAMElb107= new Label();

    @FXML
    private Label GAMElb108= new Label();

    @FXML
    private Label GAMElb109= new Label();

    @FXML
    private Label GAMElb110= new Label();

    @FXML
    private Label GAMElb111= new Label();

    @FXML
    private Label GAMElb112= new Label();

    @FXML
    private Label GAMElb113= new Label();

    @FXML
    private Label GAMElb114= new Label();

    @FXML
    private Label GAMElb115= new Label();

    @FXML
    private Label GAMElb116= new Label();

    @FXML
    private Label GAMElb117= new Label();

    @FXML
    private Label GAMElb118= new Label();

    @FXML
    private Label GAMElb119= new Label();

    @FXML
    private Label GAMElb120= new Label();

    @FXML
    private Label GAMElb121= new Label();

    @FXML
    private ArrayList<Label> labelList;

    @FXML
    private BorderPane mainPane;

    @FXML
    private Button newGameBTN;

    @FXML
    private Button scoreBoardBTN;

    @FXML
    private Button closeGameBTN;

    @FXML
    private Label graphOptionLabel = new Label();

    @FXML
    private Label GAMEtime = new Label();

    @FXML
    private ImageView GAMEBackground = new ImageView();

    @FXML
    private ImageView GAMECharacter = new ImageView();

    @FXML
    private ToggleButton musicButton;

    @FXML
    private ImageView GAMEPlatforms = new ImageView();

    @FXML
    private Button GAMEhintButton;
    //-------------------------------------     CODE FOR ALL WINDOWS    -------------------------------------
    Game game;

    private final double originalX = 718;
    private final double originalY = 929;
    private ArrayList<Label> labelsArray;
    private Label[] labelArray;
    private final double maxX = 1377;
    private final double minX = 57;
    private final double maxY = 112;
    private int boardNumber = -5;
    private int[] random;
    private boolean pausedGame;
    private int hintCounter;

    @FXML
    void changeMusicState(ActionEvent event) {
        if("PLAYING".equalsIgnoreCase(mp.getStatus() + "")){
            mp.pause();
        }else{
            mp.play();
        }
    }


    @FXML
    void closeGame(ActionEvent event) {

    }

    @FXML
    void newGame(ActionEvent event) {
        launchWindow("resources/GraphOption.fxml","Choose your graph",Modality.NONE,StageStyle.DECORATED);
    }

    private void openGameScreen() throws FileNotFoundException, InterruptedException {
        pausedGame=true;
        ((Stage) newGameBTN.getScene().getWindow()).close();
        launchWindow("resources/Game.fxml","SquidGame 2.0",Modality.NONE, StageStyle.DECORATED);
        GAMEBackground.setImage(new Image(String.valueOf(getClass().getResource("resources/Background.png"))));
        GAMEPlatforms.setImage(new Image(String.valueOf(getClass().getResource("resources/Platforms.png"))));
        GAMECharacter.setImage(new Image(String.valueOf(getClass().getResource("resources/Character.png"))));
        GAMECharacter.setLayoutX(originalX);
        GAMECharacter.setLayoutY(originalY);

        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                secs++;
                if (secs > 59) {
                    secs = 0;
                    min++;
                }
                if (min > 59) {
                    min = 0;
                    hour++;
                }
                Platform.runLater(() -> GAMEtime.setText(String.format("%02d:%02d", min, secs)));
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
        fillLabels();
        waitT(10000);
    }

    private void waitT(long time) throws InterruptedException {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                cleanLabels();
                pausedGame=false;
            }
        });
        new Thread(sleeper).start();
    }

    @FXML
    void GAMEmove(KeyEvent event) {
        char keyPressed = event.getText().toLowerCase().charAt(0);
        double x = GAMECharacter.getLayoutX();
        double y = GAMECharacter.getLayoutY();
        if(!pausedGame){
            switch (keyPressed){
                case 'w':
                    if(y>=maxY || x==originalX){
                        if(game.getObstaclesString().contains(","+(boardNumber+11)+",")){
                            boardNumber=-5;
                            GAMECharacter.setLayoutX(originalX);
                            GAMECharacter.setLayoutY(originalY);
                        }
                        else{
                            boardNumber+=11;
                            GAMECharacter.setLayoutY(y-77);
                        }
                    }
                    //Aqui se debe mirar cuando gana y terminar el juego
                    break;
                case 'a':
                    if(y!=originalY && x >= minX+3){
                        if(game.getObstaclesString().contains(","+(boardNumber-1)+",")) {
                            boardNumber=-5;
                            GAMECharacter.setLayoutX(originalX);
                            GAMECharacter.setLayoutY(originalY);
                        }
                        else {
                            boardNumber--;
                            GAMECharacter.setLayoutX(x - 132);
                        }
                    }
                    break;
                case 's':
                    if(y+77<=originalY-77){
                        if(game.getObstaclesString().contains(","+(boardNumber-11)+",")) {
                            boardNumber=-5;
                            GAMECharacter.setLayoutX(originalX);
                            GAMECharacter.setLayoutY(originalY);
                        }
                        else {
                            boardNumber-=11;
                            GAMECharacter.setLayoutY(y + 77);
                        }
                    }
                    break;
                case 'd':
                    if(y!=originalY && x <= maxX){
                        if(game.getObstaclesString().contains(","+(boardNumber+1)+",")) {
                            boardNumber=-5;
                            GAMECharacter.setLayoutX(originalX);
                            GAMECharacter.setLayoutY(originalY);
                        }
                        else {
                            boardNumber++;
                            GAMECharacter.setLayoutX(x + 132);
                        }
                    }
                    break;
            }
            game.giveNegativeScore(boardNumber);
            System.out.println(game.getActualPlayerNegativeScore());
        }
    }

    @FXML
    void scoreBoard(ActionEvent event) {

    }

    MediaPlayer mp;
    public GameGUIController(Game game){
        this.game=game;
        random = game.getRandom();
        hintCounter=5;
        //Music code
        String songName = "Squid game song - pink soldiers.mp3";
        String path = "src/ui/resources/" + songName;
        Media media = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(media);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.play();
    }

    @FXML
    void GAMEgiveUp(ActionEvent event) {

    }

    @FXML
    void GAMEhint(ActionEvent event) throws InterruptedException {
        if(hintCounter!=1){
            pausedGame=true;
            fillLabels();
            waitT(5000);
            hintCounter--;
            GAMEhintsCounter.setText((hintCounter)+" / 5");
        }
        else{
            pausedGame=true;
            fillLabels();
            waitT(5000);
            hintCounter--;
            GAMEhintsCounter.setText((hintCounter)+" / 5");
            GAMEhintButton.setDisable(true);
        }
    }

    @FXML
    void useAdjacencyList(ActionEvent event) throws FileNotFoundException, InterruptedException {
       ((Stage) graphOptionLabel.getScene().getWindow()).close();
        openGameScreen();
    }

    @FXML
    void useAdjacencyMatrix(ActionEvent event) throws FileNotFoundException, InterruptedException {
        ((Stage) graphOptionLabel.getScene().getWindow()).close();
        openGameScreen();
    }

    private Timer timer = new Timer();
    private int secs = 0, min = 0, hour = 0;

    public void stopTimer(){
        min = 0;
        secs= 0;
        timer.cancel();
    }

    private void fillLabels(){
        for(int i=0;i<labelList.size();i++){
            int text = random[i+1];
            if(text==-1){
                labelList.get(i).setText("X");
                labelList.get(i).setTextFill(Color.RED);
            }
            else{
                labelList.get(i).setText(text+"");
                labelList.get(i).setTextFill(Color.BLACK);
            }
        }
    }

    private void cleanLabels(){
        for(int i=0;i<labelList.size();i++){
            labelList.get(i).setText("");
        }
    }

    private void launchWindow(String fxml, String title, Modality modality, StageStyle style) {
        try {
            Parent loadedPane = loadFxml(fxml);
            Stage stage = new Stage();
            stage.setScene(new Scene(loadedPane));
            stage.setTitle(title);
            stage.initModality(modality);
            stage.initStyle(style);
            stage.setResizable(false);
            stage.show();
        } catch (NullPointerException npe) {
            System.out.println("Can't load requested window right now.\nRequested window: \"" + fxml + "\"");
            System.err.println(npe.getMessage());
        }
    }



    private Parent loadFxml(String resources) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resources));
            fxmlLoader.setController(this);
            return fxmlLoader.load();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Can't load requested document right now.\nRequested document: \"" + resources + "\"");
            throw new NullPointerException("Document is null");
        }
    }

}
