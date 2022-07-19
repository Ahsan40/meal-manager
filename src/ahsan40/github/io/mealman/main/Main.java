package ahsan40.github.io.mealman.main;

import dev.pages.ahsan.utils.SceneManager;
import dev.pages.ahsan.utils.Size;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static SceneManager sm;

    @Override
    public void start(Stage stage) throws Exception {
        // Scene Manager
        sm = new SceneManager(stage, Config.css);

        // Config
        sm.setDefaultSize(new Size(Config.h, Config.w));
        sm.hideTitleBar();
        sm.setTitle(Config.title + " " + Config.version);
        sm.setIcon(Config.icon);

        // Scene Transition
        sm.open("dashboard", Config.dashboard);
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
