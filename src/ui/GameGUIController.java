package ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

public class GameGUIController {
    @FXML
    private Label GAMEhintsCounter;
    @FXML
    private Label GAMElb29;

    @FXML
    private Label GAMElb39;

    @FXML
    private Label GAMElb49;

    @FXML
    private Label GAMElb149;

    @FXML
    private Label GAMElb69;

    @FXML
    private Label GAMElb79;

    @FXML
    private Label GAMElb89;

    @FXML
    private Label GAMElb99;

    @FXML
    private Label GAMElb1010;

    @FXML
    private Label GAMElb1019;

    @FXML
    private Label GAMElb111;

    @FXML
    private Label GAMElb210;

    @FXML
    private Label GAMElb310;

    @FXML
    private Label GAMElb410;

    @FXML
    private Label GAMElb1410;

    @FXML
    private Label GAMElb610;

    @FXML
    private Label GAMElb710;

    @FXML
    private Label GAMElb810;

    @FXML
    private Label GAMElb910;

    @FXML
    private Label GAMElb1020;

    @FXML
    private Label GAMElb10110;

    @FXML
    private Label GAMElb112;

    @FXML
    private Label GAMElb211;

    @FXML
    private Label GAMElb311;

    @FXML
    private Label GAMElb411;

    @FXML
    private Label GAMElb58;

    @FXML
    private Label GAMElb611;

    @FXML
    private Label GAMElb711;

    @FXML
    private Label GAMElb811;

    @FXML
    private Label GAMElb911;

    @FXML
    private Label GAMElb1021;

    @FXML
    private Label GAMElb10111;

    @FXML
    private BorderPane mainPane;

    @FXML
    private Button newGameBTN;

    @FXML
    private Button scoreBoardBTN;

    @FXML
    private Button closeGameBTN;

    @FXML
    private Label graphOptionLabel;

    @FXML
    private Label GAMEtime;

    @FXML
    private Label GAMElb11;

    @FXML
    private Label GAMElb21;

    @FXML
    private Label GAMElb31;

    @FXML
    private Label GAMElb41;

    @FXML
    private Label GAMElb141;

    @FXML
    private Label GAMElb51;

    @FXML
    private Label GAMElb61;

    @FXML
    private Label GAMElb71;

    @FXML
    private Label GAMElb81;

    @FXML
    private Label GAMElb91;

    @FXML
    private Label GAMElb102;

    @FXML
    private Label GAMElb1011;

    @FXML
    private Label GAMElb12;

    @FXML
    private Label GAMElb22;

    @FXML
    private Label GAMElb32;

    @FXML
    private Label GAMElb42;

    @FXML
    private Label GAMElb142;

    @FXML
    private Label GAMElb52;

    @FXML
    private Label GAMElb62;

    @FXML
    private Label GAMElb72;

    @FXML
    private Label GAMElb82;

    @FXML
    private Label GAMElb92;

    @FXML
    private Label GAMElb103;

    @FXML
    private Label GAMElb1012;

    @FXML
    private Label GAMElb13;

    @FXML
    private Label GAMElb23;

    @FXML
    private Label GAMElb33;

    @FXML
    private Label GAMElb43;

    @FXML
    private Label GAMElb143;

    @FXML
    private Label GAMElb53;

    @FXML
    private Label GAMElb63;

    @FXML
    private Label GAMElb73;

    @FXML
    private Label GAMElb83;

    @FXML
    private Label GAMElb93;

    @FXML
    private Label GAMElb104;

    @FXML
    private Label GAMElb1013;

    @FXML
    private Label GAMElb15;

    @FXML
    private Label GAMElb24;

    @FXML
    private Label GAMElb34;

    @FXML
    private Label GAMElb44;

    @FXML
    private Label GAMElb144;

    @FXML
    private Label GAMElb54;

    @FXML
    private Label GAMElb64;

    @FXML
    private Label GAMElb74;

    @FXML
    private Label GAMElb84;

    @FXML
    private Label GAMElb94;

    @FXML
    private Label GAMElb105;

    @FXML
    private Label GAMElb1014;

    @FXML
    private Label GAMElb16;

    @FXML
    private Label GAMElb25;

    @FXML
    private Label GAMElb35;

    @FXML
    private Label GAMElb45;

    @FXML
    private Label GAMElb145;

    @FXML
    private Label GAMElb55;

    @FXML
    private Label GAMElb65;

    @FXML
    private Label GAMElb75;

    @FXML
    private Label GAMElb85;

    @FXML
    private Label GAMElb95;

    @FXML
    private Label GAMElb106;

    @FXML
    private Label GAMElb1015;

    @FXML
    private Label GAMElb17;

    @FXML
    private Label GAMElb26;

    @FXML
    private Label GAMElb36;

    @FXML
    private Label GAMElb46;

    @FXML
    private Label GAMElb146;

    @FXML
    private Label GAMElb56;

    @FXML
    private Label GAMElb66;

    @FXML
    private Label GAMElb76;

    @FXML
    private Label GAMElb86;

    @FXML
    private Label GAMElb96;

    @FXML
    private Label GAMElb107;

    @FXML
    private Label GAMElb1016;

    @FXML
    private Label GAMElb18;

    @FXML
    private Label GAMElb27;

    @FXML
    private Label GAMElb37;

    @FXML
    private Label GAMElb47;

    @FXML
    private Label GAMElb147;

    @FXML
    private Label GAMElb57;

    @FXML
    private Label GAMElb67;

    @FXML
    private Label GAMElb77;

    @FXML
    private Label GAMElb87;

    @FXML
    private Label GAMElb97;

    @FXML
    private Label GAMElb108;

    @FXML
    private Label GAMElb1017;

    @FXML
    private Label GAMElb19;

    @FXML
    private Label GAMElb28;

    @FXML
    private Label GAMElb38;

    @FXML
    private Label GAMElb48;

    @FXML
    private Label GAMElb148;

    @FXML
    private Label GAMElb68;

    @FXML
    private Label GAMElb78;

    @FXML
    private Label GAMElb88;

    @FXML
    private Label GAMElb98;

    @FXML
    private Label GAMElb109;

    @FXML
    private Label GAMElb1018;

    @FXML
    private Label GAMElb110;

    @FXML
    private ImageView bg = new ImageView();

    @FXML
    private ToggleButton musicButton;
    //-------------------------------------     CODE FOR ALL WINDOWS    -------------------------------------
    Game game;

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

    private void openGameScreen() throws FileNotFoundException {
        ((Stage) newGameBTN.getScene().getWindow()).close();
        Image i = new Image(String.valueOf(getClass().getResource("resources/Background.png")));

        launchWindow("resources/Game.fxml","SquidGame 2.0",Modality.NONE, StageStyle.DECORATED);
        bg.setImage(i);

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
    }

    @FXML
    void scoreBoard(ActionEvent event) {

    }

    MediaPlayer mp;
    public GameGUIController(Game game){
        this.game=game;

        //Music code
        String songName = "Squid game song - pink soldiers.mp3";
        String path = "src/ui/resources/" + songName;
        Media media = new Media(new File(path).toURI().toString());
        mp = new MediaPlayer(media);
        mp.setCycleCount(MediaPlayer.INDEFINITE);
        mp.play();

        //Creation of the labels ArrayList
        ArrayList<Label> labelsArray = new ArrayList<>();

        labelsArray.add( GAMElb11);
        labelsArray.add( GAMElb21);
        labelsArray.add( GAMElb31);
        labelsArray.add( GAMElb41);
        labelsArray.add( GAMElb141);
        labelsArray.add( GAMElb51);
        labelsArray.add( GAMElb61);
        labelsArray.add( GAMElb71);
        labelsArray.add( GAMElb81);
        labelsArray.add( GAMElb91);
        labelsArray.add( GAMElb102);
        labelsArray.add( GAMElb1011);
        labelsArray.add( GAMElb12);
        labelsArray.add( GAMElb22);
        labelsArray.add( GAMElb32);
        labelsArray.add( GAMElb42);
        labelsArray.add( GAMElb142);
        labelsArray.add( GAMElb52);
        labelsArray.add( GAMElb62);
        labelsArray.add( GAMElb72);
        labelsArray.add( GAMElb82);
        labelsArray.add( GAMElb92);
        labelsArray.add( GAMElb103);
        labelsArray.add( GAMElb1012);
        labelsArray.add( GAMElb13);
        labelsArray.add( GAMElb23);
        labelsArray.add( GAMElb33);
        labelsArray.add( GAMElb43);
        labelsArray.add( GAMElb143);
        labelsArray.add( GAMElb53);
        labelsArray.add( GAMElb63);
        labelsArray.add( GAMElb73);
        labelsArray.add( GAMElb83);
        labelsArray.add( GAMElb93);
        labelsArray.add( GAMElb104);
        labelsArray.add( GAMElb1013);
        labelsArray.add( GAMElb15);
        labelsArray.add( GAMElb24);
        labelsArray.add( GAMElb34);
        labelsArray.add( GAMElb44);
        labelsArray.add( GAMElb144);
        labelsArray.add( GAMElb54);
        labelsArray.add( GAMElb64);
        labelsArray.add( GAMElb74);
        labelsArray.add( GAMElb84);
        labelsArray.add( GAMElb94);
        labelsArray.add( GAMElb105);
        labelsArray.add( GAMElb1014);
        labelsArray.add( GAMElb16);
        labelsArray.add( GAMElb25);
        labelsArray.add( GAMElb35);
        labelsArray.add( GAMElb45);
        labelsArray.add( GAMElb145);
        labelsArray.add( GAMElb55);
        labelsArray.add( GAMElb65);
        labelsArray.add( GAMElb75);
        labelsArray.add( GAMElb85);
        labelsArray.add( GAMElb95);
        labelsArray.add( GAMElb106);
        labelsArray.add( GAMElb1015);
        labelsArray.add( GAMElb17);
        labelsArray.add( GAMElb26);
        labelsArray.add( GAMElb36);
        labelsArray.add( GAMElb46);
        labelsArray.add( GAMElb146);
        labelsArray.add( GAMElb56);
        labelsArray.add( GAMElb66);
        labelsArray.add( GAMElb76);
        labelsArray.add( GAMElb86);
        labelsArray.add( GAMElb96);
        labelsArray.add( GAMElb107);
        labelsArray.add( GAMElb1016);
        labelsArray.add( GAMElb18);
        labelsArray.add( GAMElb27);
        labelsArray.add( GAMElb37);
        labelsArray.add( GAMElb47);
        labelsArray.add( GAMElb147);
        labelsArray.add( GAMElb57);
        labelsArray.add( GAMElb67);
        labelsArray.add( GAMElb77);
        labelsArray.add( GAMElb87);
        labelsArray.add( GAMElb97);
        labelsArray.add( GAMElb108);
        labelsArray.add( GAMElb1017);
        labelsArray.add( GAMElb19);
        labelsArray.add( GAMElb28);
        labelsArray.add( GAMElb38);
        labelsArray.add( GAMElb48);
        labelsArray.add( GAMElb148);
        labelsArray.add( GAMElb68);
        labelsArray.add( GAMElb78);
        labelsArray.add( GAMElb88);
        labelsArray.add( GAMElb98);
        labelsArray.add( GAMElb109);
        labelsArray.add( GAMElb1018);
        labelsArray.add( GAMElb110);
        labelsArray.add( GAMElb29);
        labelsArray.add( GAMElb39);
        labelsArray.add( GAMElb49);
        labelsArray.add( GAMElb149);
        labelsArray.add( GAMElb69);
        labelsArray.add( GAMElb79);
        labelsArray.add( GAMElb89);
        labelsArray.add( GAMElb99);
        labelsArray.add( GAMElb1010);
        labelsArray.add( GAMElb1019);
        labelsArray.add( GAMElb111);
        labelsArray.add( GAMElb210);
        labelsArray.add( GAMElb310);
        labelsArray.add( GAMElb410);
        labelsArray.add( GAMElb1410);
        labelsArray.add( GAMElb610);
        labelsArray.add( GAMElb710);
        labelsArray.add( GAMElb810);
        labelsArray.add( GAMElb910);
        labelsArray.add( GAMElb1020);
        labelsArray.add( GAMElb10110);
        labelsArray.add( GAMElb112);
        labelsArray.add( GAMElb211);
        labelsArray.add( GAMElb311);
        labelsArray.add( GAMElb411);
        labelsArray.add( GAMElb58);
        labelsArray.add( GAMElb611);
        labelsArray.add( GAMElb711);
        labelsArray.add( GAMElb811);
        labelsArray.add( GAMElb911);
        labelsArray.add( GAMElb1021);
        labelsArray.add( GAMElb10111);
    }

    @FXML
    void GAMEgiveUp(ActionEvent event) {

    }

    @FXML
    void GAMEhint(ActionEvent event) {

    }

    @FXML
    void useAdjacencyList(ActionEvent event) throws FileNotFoundException {
       ((Stage) graphOptionLabel.getScene().getWindow()).close();
        openGameScreen();
    }

    @FXML
    void useAdjacencyMatrix(ActionEvent event) throws FileNotFoundException {
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
