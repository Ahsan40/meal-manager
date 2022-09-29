module meal.manager {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;

    opens dev.pages.ahsan.mealman.main to javafx.fxml;
    exports dev.pages.ahsan.mealman.main to javafx.graphics;

    opens dev.pages.ahsan.mealman.classes to javafx.fxml;
    exports dev.pages.ahsan.mealman.classes to javafx.graphics;

    opens dev.pages.ahsan.mealman.controller to javafx.fxml;
    exports dev.pages.ahsan.mealman.controller to javafx.graphics;

    opens dev.pages.ahsan.utils to javafx.fxml;
    exports dev.pages.ahsan.utils to javafx.graphics;
}