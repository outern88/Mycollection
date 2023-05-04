package Main;

//import libs
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import org.controlsfx.control.Notifications;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.control.ListView;
import javafx.scene.control.CheckBox;
import java.util.List;

import Database.Cards;

public class Ui extends Application {

    private BorderPane root;
    private Scene scene_cards;
    private Scene mainScene;

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        mainScene = new Scene(root, 800, 600);

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
        etbButton.setOnAction(event -> openEtbScene(primaryStage));
        collectionBoxButton.setOnAction(event -> openCollectionBox(primaryStage));
        boosterPacksButton.setOnAction(event -> openBoosterPack(primaryStage));
        miscButton.setOnAction(event -> openMisc(primaryStage));


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

    //"Cards" scene
    private void openNewScene(Stage primaryStage) {
        // Create the new scene's root layout
        BorderPane newSceneRoot = new BorderPane(); // Use a BorderPane instead of a VBox

        // Add the menu bar to the new scene
        MenuBar newSceneMenuBar = createMenuBar(primaryStage);
        newSceneRoot.setTop(newSceneMenuBar); // Set the menu bar to the top of the BorderPane

        // Create card list view and load checked cards from the text file
        ListView<HBox> cardListView = createCardListView();
        loadCheckedCards(cardListView);
        newSceneRoot.setCenter(cardListView); // Add the cardListView to the center of the BorderPane

        // Create a back button to return to the main scene and save the checked card status to the text file
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            saveCheckedCards(cardListView);
            primaryStage.setScene(mainScene);
        });
        newSceneRoot.setBottom(backButton); // Add the backButton to the bottom of the BorderPane

        // Create the new scene and set it to the stage
        Scene scene_cards = new Scene(newSceneRoot, 800, 600);
        primaryStage.setScene(scene_cards);
    }


    //"Etb" scene
    private void openEtbScene(Stage primaryStage) {
        // Create the new scene's root layout
        BorderPane newSceneRoot = new BorderPane(); // Use a BorderPane instead of a VBox

        // Add the menu bar to the new scene
        MenuBar newSceneMenuBar = createMenuBar(primaryStage);
        newSceneRoot.setTop(newSceneMenuBar); // Set the menu bar to the top of the BorderPane


        // Create a back button to return to the main scene and save the checked card status to the text file
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            primaryStage.setScene(mainScene);
        });
        newSceneRoot.setBottom(backButton); // Add the backButton to the bottom of the BorderPane

        // Create the new scene and set it to the stage
        Scene scene_etb = new Scene(newSceneRoot, 800, 600);
        primaryStage.setScene(scene_etb);
    }

    //"Collection box" scene
    private void openCollectionBox(Stage primaryStage) {
        // Create the new scene's root layout
        BorderPane newSceneRoot = new BorderPane(); // Use a BorderPane instead of a VBox

        // Add the menu bar to the new scene
        MenuBar newSceneMenuBar = createMenuBar(primaryStage);
        newSceneRoot.setTop(newSceneMenuBar); // Set the menu bar to the top of the BorderPane


        // Create a back button to return to the main scene and save the checked card status to the text file
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            primaryStage.setScene(mainScene);
        });
        newSceneRoot.setBottom(backButton); // Add the backButton to the bottom of the BorderPane

        // Create the new scene and set it to the stage
        Scene scene_collection_box = new Scene(newSceneRoot, 800, 600);
        primaryStage.setScene(scene_collection_box);
    }


    //"Collection box" scene
    private void openBoosterPack(Stage primaryStage) {
        // Create the new scene's root layout
        BorderPane newSceneRoot = new BorderPane(); // Use a BorderPane instead of a VBox

        // Add the menu bar to the new scene
        MenuBar newSceneMenuBar = createMenuBar(primaryStage);
        newSceneRoot.setTop(newSceneMenuBar); // Set the menu bar to the top of the BorderPane

        // Create a back button to return to the main scene and save the checked card status to the text file
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            primaryStage.setScene(mainScene);
        });
        newSceneRoot.setBottom(backButton); // Add the backButton to the bottom of the BorderPane

        // Create the new scene and set it to the stage
        Scene scene_booster_pack = new Scene(newSceneRoot, 800, 600);
        primaryStage.setScene(scene_booster_pack);
    }


    //"Misc" scene
    private void openMisc(Stage primaryStage) {
        // Create the new scene's root layout
        BorderPane newSceneRoot = new BorderPane(); // Use a BorderPane instead of a VBox

        // Add the menu bar to the new scene
        MenuBar newSceneMenuBar = createMenuBar(primaryStage);
        newSceneRoot.setTop(newSceneMenuBar); // Set the menu bar to the top of the BorderPane

        // Create a back button to return to the main scene and save the checked card status to the text file
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> {
            primaryStage.setScene(mainScene);
        });
        newSceneRoot.setBottom(backButton); // Add the backButton to the bottom of the BorderPane

        // Create the new scene and set it to the stage
        Scene scene_misc = new Scene(newSceneRoot, 800, 600);
        primaryStage.setScene(scene_misc);
    }




    //Makes a listview for the cards list.
    private ListView<HBox> createCardListView() {
        ListView<HBox> listView = new ListView<>();

        // Read card list from cards.java
        List<String> cards = Cards.getCardList();

        // Add cards to the ListView with a checkbox
        for (String card : cards) {
            CheckBox checkBox = new CheckBox();
            Label cardLabel = new Label(card);
            HBox cardBox = new HBox(10, cardLabel, checkBox);
            listView.getItems().add(cardBox);
        }

        return listView;
    }

    //write checkbox status to file
    private void saveCheckedCards(ListView<HBox> listView) {
        File checkedCardsFile = new File("checkedCards.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(checkedCardsFile))) {
            for (HBox cardBox : listView.getItems()) {
                CheckBox checkBox = (CheckBox) cardBox.getChildren().get(1);
                String status = checkBox.isSelected() ? "1" : "0";
                writer.write(status);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Loading the checkboxes to list
    private void loadCheckedCards(ListView<HBox> listView) {
        File checkedCardsFile = new File("checkedCards.txt");

        if (checkedCardsFile.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(checkedCardsFile))) {
                String line;
                int index = 0;

                while ((line = reader.readLine()) != null) {
                    CheckBox checkBox = (CheckBox) listView.getItems().get(index).getChildren().get(1);
                    checkBox.setSelected("1".equals(line));
                    index++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
