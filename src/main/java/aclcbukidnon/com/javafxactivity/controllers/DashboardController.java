package aclcbukidnon.com.javafxactivity.controllers;

import aclcbukidnon.com.javafxactivity.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class DashboardController {

    @FXML
    private BorderPane rootPane;

    @FXML
    public void initialize() {
        loadPage("counter-view.fxml"); // default page on load
    }

    @FXML
    protected void onTrafficLightClick() {
        loadPage("traffic-light-view.fxml");
    }

    @FXML
    protected void onCounterClick() {
        loadPage("counter-view.fxml");
    }

    @FXML
    protected void onCalculatorClick() {
        loadPage("calculator-view.fxml");
    }

    @FXML
    protected void onTodoClick() {
        loadPage("todo-view.fxml");
    }

    private void loadPage(String fxmlFile) {
        try {
            Node content = FXMLLoader.load(Main.class.getResource(fxmlFile));
            rootPane.setCenter(content);
        } catch (IOException e) {
            e.printStackTrace(); // You can log this better if needed
        }
    }
}
