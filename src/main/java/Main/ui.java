package Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

public class ui extends Application {

    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);

        // Create menu bar and menu buttons
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(event -> primaryStage.close()); // set action to close window
        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, exitMenuItem);
        menuBar.getMenus().addAll(fileMenu);

        // Add menu bar to the top of the border pane
        root.setTop(menuBar);

        // Create menu buttons for the left side of the menu
        Button kortButton = new Button("Kort");
        Button etbButton = new Button("ETB");
        Button collectionBoxButton = new Button("Collection Box");
        Button boosterPacksButton = new Button("Booster Packs");
        Button miscButton = new Button("Misc");

        // Add buttons to a VBox
        VBox menuButtonBox = new VBox(10, kortButton, etbButton, collectionBoxButton, boosterPacksButton, miscButton);
        menuButtonBox.setPadding(new Insets(20, 10, 10, 10));

        // Add VBox to a StackPane
        StackPane menuButtonPane = new StackPane(menuButtonBox);

        // Add StackPane to the left side of the border pane
        root.setLeft(menuButtonPane);

        // Add some UI components to the center of the border pane
        StackPane centerPane = new StackPane();
        centerPane.setStyle("-fx-background-color: #d3d3d3;");
        root.setCenter(centerPane);

        // Create a notification to demonstrate ControlsFX
        Notifications.create().owner(primaryStage).title("Welcome").text("My Collection program is running!").show();

        // Set window title and show the window
        primaryStage.setTitle("My Collection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}