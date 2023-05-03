package Main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

public class ui extends Application {

    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        Scene mainScene = new Scene(root, 800, 600);

        // Create menu bar and menu buttons for the main scene
        MenuBar menuBar = createMenuBar(primaryStage);
        root.setTop(menuBar);

        // Create menu buttons for the left side of the menu
        Button kortButton = new Button("Kort");
        Button etbButton = new Button("ETB");
        Button collectionBoxButton = new Button("Collection Box");
        Button boosterPacksButton = new Button("Booster Packs");
        Button miscButton = new Button("Misc");

        // Add EventHandler for "kort" button
        kortButton.setOnAction(event -> openNewScene(primaryStage));

        // Add buttons to a VBox
        VBox menuButtonBox = new VBox();
        menuButtonBox.setSpacing(10);
        menuButtonBox.setPadding(new Insets(20, 10, 10, 10));
        menuButtonBox.getChildren().addAll(kortButton, etbButton, collectionBoxButton, boosterPacksButton, miscButton);

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
        primaryStage.setScene(mainScene);
        primaryStage.show();


    }

    private void openNewScene(Stage primaryStage) {
        // Create the new scene's root layout
        VBox newSceneRoot = new VBox();
        newSceneRoot.setSpacing(10);
        newSceneRoot.setPadding(new Insets(10));

        // Add the menu bar to the new scene
        MenuBar newSceneMenuBar = createMenuBar(primaryStage);
        newSceneRoot.getChildren().add(0, newSceneMenuBar);

        Label newSceneLabel = new Label("This is the new scene.");
        newSceneRoot.getChildren().add(newSceneLabel);

        // Create the new scene and set it to the stage
        Scene newScene = new Scene(newSceneRoot, 800, 600);

        // Create a back button to return to the main scene
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> primaryStage.setScene(root.getScene()));
        newSceneRoot.getChildren().add(backButton);

        // Set the new scene to the stage
        primaryStage.setScene(newScene);
    }

    // Menuline
    private MenuBar createMenuBar(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();
        // Menu main btns
        Menu fileMenu = new Menu("File");
        Menu myCollectionMenu = new Menu("My Collection");
        // Sub btns
        // File:
        MenuItem newMenuItem = new MenuItem("New");
        MenuItem openMenuItem = new MenuItem("Open");
        MenuItem saveMenuItem = new MenuItem("Save");
        MenuItem exitMenuItem = new MenuItem("Exit");
        // Sub btn: "My collection"
        MenuItem cardsMenuItem = new MenuItem("Cards");
        MenuItem etbMenuItem = new MenuItem("ETB");
        MenuItem collectionboxMenuItem = new MenuItem("Collection Box");
        MenuItem miscMenuItem = new MenuItem("Misc");
        // Menu line Actions
        // "file" Actions
        exitMenuItem.setOnAction(event -> primaryStage.close());
        // "My collection" Actions
        cardsMenuItem.setOnAction(event -> openNewScene(primaryStage));

        fileMenu.getItems().addAll(newMenuItem, openMenuItem, saveMenuItem, exitMenuItem);
        myCollectionMenu.getItems().addAll(cardsMenuItem, etbMenuItem, collectionboxMenuItem, miscMenuItem);
        menuBar.getMenus().addAll(fileMenu, myCollectionMenu);

        return menuBar;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
