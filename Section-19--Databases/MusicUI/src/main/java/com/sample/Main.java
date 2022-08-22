package com.sample;

import com.sample.model.DataSource;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        Controller controller = fxmlLoader.getController();
        controller.listArtists();

        stage.setTitle("Music Database");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        if(!DataSource.getInstance().open()) {
            System.out.println("FATAL ERROR: couldn't connect to database");
            Platform.exit();
        }
        super.init();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        DataSource.getInstance().close();
    }

    public static void main(String[] args) {
        launch();
    }
}
