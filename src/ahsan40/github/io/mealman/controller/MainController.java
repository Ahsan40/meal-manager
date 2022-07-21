package ahsan40.github.io.mealman.controller;


import ahsan40.github.io.mealman.classes.Page;
import ahsan40.github.io.mealman.main.Config;
import ahsan40.github.io.mealman.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button btnBazzar;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnExtra;

    @FXML
    private Button btnMeal;

    @FXML
    private Button btnPayments;

    @FXML
    private Button btnPeople;

    @FXML
    private Pane mainPane;

    @FXML
    private Text title;

//    private Page[] tabs;
    private HashMap<String, Page> tabs;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        title.setText(Config.title + " " + Config.version);

        // Configure Pages
        tabs = new HashMap<>();
        tabs.put("dashboard", new Page("dashboard", Config.dashboard, true));
        tabs.put("meal", new Page("meal", Config.meal, false));
        tabs.put("bazzar", new Page("bazzar", Config.bazzar, false));
        tabs.put("payments", new Page("payments", Config.payments, false));
        tabs.put("people", new Page("people", Config.people, false));
        tabs.put("extra", new Page("extra", Config.extra, false ));
        tabs.put("default", tabs.get("dashboard"));

        // Default Page
        changeScene(tabs.get("default").location);
        btnDashboard.getStyleClass().add("button-active");
    }

    @FXML
    void dashboardAction(ActionEvent event) throws IOException {
        Button b = ((Button)event.getSource());
        String text = b.getText();
        Page p = tabs.get(text.toLowerCase());
        if(!p.activated) {
            changeScene(p.location, p.name);
            removeStyle("button-active");
            b.getStyleClass().add("button-active");
        }
    }

    // Internal Private Function
    private void removeStyle(String name){
        btnDashboard.getStyleClass().remove(name);
        btnMeal.getStyleClass().remove(name);
        btnBazzar.getStyleClass().remove(name);
        btnPayments.getStyleClass().remove(name);
        btnPeople.getStyleClass().remove(name);
        btnExtra.getStyleClass().remove(name);
    }
    private void changeScene(String scene) {
        try {
            // Load FXML
            Node node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(scene)));
            this.mainPane.getChildren().setAll(node);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void changeScene(String scene, String name) {
        changeScene(scene);
        // Mark
        for(Map.Entry<String, Page> p: tabs.entrySet()) {
            p.getValue().activated = false;
        }
        tabs.get(name).activated = true;
    }
    @FXML
    private void exit(MouseEvent event) {
        System.exit(0);
    }

    @FXML
    private void minimize(MouseEvent event) {
        Main.sm.minimize();
    }
}
