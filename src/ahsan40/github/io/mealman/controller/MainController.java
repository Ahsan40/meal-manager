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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
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

    @FXML
    private ImageView icon;

    private HashMap<String, Page> tabs;
    private HashMap<String, Button> tabButtons;

    private void init() throws Exception {
        // Window Config
        title.setText(Config.title + " " + Config.version);
        icon.setImage(new Image(Objects.requireNonNull(getClass().getResource(Config.icon)).toURI().toString()));

        // Configure Pages
        tabs = initTab();
        tabButtons = initTabButtons();

        // Set Active
        changeScene(tabs.get(Config.defaultTab).location);
    }

    @FXML
    void dashboardAction(ActionEvent event) {
        String text = ((Button) event.getSource()).getText();
        Page p = tabs.get(text.toLowerCase());
        if (!p.activated) {
            changeScene(p.location, p.name, Config.activeTabClass);
        }
    }

    // Internal Private Function
    private void changeScene(String scene) {
        try {
            // Load FXML
            Node node = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(scene)));
            this.mainPane.getChildren().setAll(node);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void changeScene(String scene, String name, String activeClass) {
        changeScene(scene);

        // Changing(Disabling) Active State of Current Active Tab
        this.tabs.get("active").activated = false;
        this.tabButtons.get("active").getStyleClass().remove(activeClass);

        // Assigning New Active Tab
        this.tabs.put("active", this.tabs.get(name));
        this.tabButtons.put("active", this.tabButtons.get(name));

        // Changing(Enabling) Active State of New Active Tab
        this.tabs.get("active").activated = true;
        this.tabButtons.get("active").getStyleClass().add(activeClass);
    }

    private HashMap<String, Page> initTab() {
        HashMap<String, Page> t = new HashMap<>();
        t.put("dashboard", new Page("dashboard", Config.dashboard, false));
        t.put("meal", new Page("meal", Config.meal, false));
        t.put("bazzar", new Page("bazzar", Config.bazzar, false));
        t.put("payments", new Page("payments", Config.payments, false));
        t.put("people", new Page("people", Config.people, false));
        t.put("extra", new Page("extra", Config.extra, false));

        // Default Tab Config
        t.put("active", t.get(Config.defaultTab));
        t.get(Config.defaultTab).activated = true;
        return t;
    }

    private HashMap<String, Button> initTabButtons() {
        HashMap<String, Button> tb = new HashMap<>();
        tb.put("dashboard", btnDashboard);
        tb.put("meal", btnMeal);
        tb.put("bazzar", btnBazzar);
        tb.put("payments", btnPayments);
        tb.put("people", btnPeople);
        tb.put("extra", btnExtra);

        // Default Tab Button Config
        tb.put("active", tb.get(Config.defaultTab));
        tb.get(Config.defaultTab).getStyleClass().add(Config.activeTabClass);
        return tb;
    }


    // Constant Handlers/Methods
    @FXML
    private void exit() {
        System.exit(0);
    }

    @FXML
    private void minimize() {
        Main.sm.minimize();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
