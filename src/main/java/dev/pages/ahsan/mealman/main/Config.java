package dev.pages.ahsan.mealman.main;

import dev.pages.ahsan.mealman.classes.Page;

import java.util.ArrayList;

public class Config {
    // App Configs
    public static String title = "Meal Manager";
    public static String version = "v1.0";
    public static String icon = "/img/icon3.png";
    public static String css = "/css/styles.css";
    public static double h = 487;
    public static double w = 822;

    // Scene Settings
    public static String mainScene = "/fxml/MainScene.fxml";

    // Tab Settings
    public static String defaultTab = "dashboard";
    public static String activeTabClass = "menu-item-active";
    public static ArrayList<Page> tabs = new ArrayList<>();

    static {
        // Corresponding button needs to be added in MainController class and MainScene fxml.
        tabs.add(new Page("dashboard", "/fxml/Dashboard.fxml"));
        tabs.add(new Page("meal", "/fxml/Meal.fxml"));
        tabs.add(new Page("bazaar", "/fxml/Bazaar.fxml"));
        tabs.add(new Page("payments", "/fxml/Payments.fxml"));
        tabs.add(new Page("people", "/fxml/People.fxml"));
        tabs.add(new Page("extra", "/fxml/Extra.fxml"));
    }
}
