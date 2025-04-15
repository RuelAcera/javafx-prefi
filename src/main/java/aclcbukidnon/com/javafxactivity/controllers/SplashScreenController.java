package aclcbukidnon.com.javafxactivity.controllers;

import aclcbukidnon.com.javafxactivity.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class SplashScreenController {

    @FXML
    public ProgressBar progressInitial;

    private Stage stage; // Stage passed from Main

    @FXML
    public void initialize() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, e -> progressInitial.setProgress(0)),
                new KeyFrame(Duration.millis(200), e -> progressInitial.setProgress(0.1)),
                new KeyFrame(Duration.millis(350), e -> progressInitial.setProgress(0.3)),
                new KeyFrame(Duration.millis(400), e -> progressInitial.setProgress(0.5)),
                new KeyFrame(Duration.millis(550), e -> progressInitial.setProgress(0.7)),
                new KeyFrame(Duration.millis(600), e -> progressInitial.setProgress(0.9)),
                new KeyFrame(Duration.millis(1050), e -> progressInitial.setProgress(1.0))
        );

        timeline.setOnFinished(_ -> onCompleted());
        timeline.play();
    }

    private void onCompleted() {
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("dashboard-view.fxml"));
            Scene scene = new Scene(loader.load(), 800, 600);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
