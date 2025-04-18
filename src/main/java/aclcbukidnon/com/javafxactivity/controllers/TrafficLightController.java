package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class TrafficLightController {

    private enum TrafficLightColor {
        STOP,
        HOLD,
        GO
    }

    private TrafficLightColor currentColor = TrafficLightColor.STOP;

    private Timeline timeline;

    @FXML
    private Circle redLight;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle greenLight;

    @FXML
    public void initialize() {
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        updateLights(); // set initial state
    }

    @FXML
    protected void onStartClick() {
        timeline.play();
    }

    @FXML
    protected void onStopClick() {
        timeline.stop();
        currentColor = TrafficLightColor.STOP; // Optional: reset to red
        updateLights();
    }

    private void onTimerChange() {
        switch (currentColor) {
            case STOP -> currentColor = TrafficLightColor.HOLD;
            case HOLD -> currentColor = TrafficLightColor.GO;
            case GO -> currentColor = TrafficLightColor.STOP;
        }
        updateLights();
    }

    private void updateLights() {
        redLight.setFill(currentColor == TrafficLightColor.STOP ? Color.RED : Color.GRAY);
        yellowLight.setFill(currentColor == TrafficLightColor.HOLD ? Color.YELLOW : Color.GRAY);
        greenLight.setFill(currentColor == TrafficLightColor.GO ? Color.LIMEGREEN : Color.GRAY);
    }
}
