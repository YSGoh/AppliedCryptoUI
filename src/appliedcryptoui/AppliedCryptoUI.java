package appliedcryptoui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppliedCryptoUI extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Playfair1 Program");
        
        // initialize grid pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(50);
        grid.setVgap(50);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // Initialize heading
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1); // (column, row, column span, row span)
        
        Label userSelection = new Label("Who Are You?");
        grid.add(userSelection, 0, 1);

        // Radio group for user selection
        RadioButton radioButton1 = new RadioButton("Alice");
        RadioButton radioButton2 = new RadioButton("Bob");

        ToggleGroup radioGroup = new ToggleGroup();

        radioButton1.setToggleGroup(radioGroup);
        radioButton2.setToggleGroup(radioGroup);

        HBox hbox = new HBox(radioButton1, radioButton2);

         // scene created with grid pane as root node
        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
