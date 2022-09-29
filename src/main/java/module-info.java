module meal.manager {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens ahsan40.github.io.mealman.main to javafx.fxml;
    exports ahsan40.github.io.mealman.main to javafx.graphics;

    opens ahsan40.github.io.mealman.classes to javafx.fxml;
    exports ahsan40.github.io.mealman.classes to javafx.graphics;

    opens ahsan40.github.io.mealman.controller to javafx.fxml;
    exports ahsan40.github.io.mealman.controller to javafx.graphics;

    opens dev.pages.ahsan.utils to javafx.fxml;
    exports dev.pages.ahsan.utils to javafx.graphics;
}