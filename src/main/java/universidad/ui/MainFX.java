package universidad.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Font.loadFont(MainFX.class.getResourceAsStream("/fonts/Inter_18pt-Regular.ttf"), 15);
        Font.loadFont(MainFX.class.getResourceAsStream("/fonts/Inter_18pt-SemiBold.ttf"), 15);
        Font.loadFont(MainFX.class.getResourceAsStream("/fonts/Inter_24pt-Bold.ttf"), 24);

        FXMLLoader loader = new FXMLLoader(
                MainFX.class.getResource("/ui/dashboard.fxml"));

        Scene scene = new Scene(loader.load());

        stage.setTitle("Sistema Académico");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}