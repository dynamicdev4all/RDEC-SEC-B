import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MusicPlayer extends Application {

    @Override
    public void start(Stage arg0) {

        try {
            Media media = new Media(
                    "https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview112/v4/a6/07/c5/a607c578-67ef-7762-0876-97ec1c510973/mzaf_1348531683616885207.plus.aac.p.m4a");
            MediaPlayer player = new MediaPlayer(media);

            player.play();

            System.out.println("Playing");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }


}
// "--module-path \"C:\\Program Files\\JavaFx\\javafx-sdk-21.0.5\\lib\" --add-modules=javafx.media,javafx.controls"
