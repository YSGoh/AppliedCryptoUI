package appliedcryptoui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
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
        grid.setHgap(10); // horizontal spacing
        grid.setVgap(20); // vertical spacing
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // Initialize heading
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1); // (column, row, column span, row span)
        
        // initialize label
        Label userSelection = new Label("Who Are You?");
        grid.add(userSelection, 0, 1);

        final ToggleGroup radioGroup = new ToggleGroup();

        // Initialize radio group for user selection
        RadioButton radioButton1 = new RadioButton("Alice");
        radioButton1.setToggleGroup(radioGroup);
        radioButton1.setUserData("Alice");
        
        RadioButton radioButton2 = new RadioButton("Bob");
        radioButton2.setToggleGroup(radioGroup);
        radioButton2.setUserData("Bob");
       
        // event listener for radio button group
        radioGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            public void changed(ObservableValue<? extends Toggle> ov,
                Toggle old_toggle, Toggle new_toggle) {
              if (radioGroup.getSelectedToggle() != null) {
                System.out.println(radioGroup.getSelectedToggle().getUserData().toString());
              }
            }
          });
        
        // initialize button
        Button button = new Button("Next");
        
        // button event
        button.setOnAction((ActionEvent e) -> {
            System.out.println("clicked");
        });
        
        // add radio button to gridpane
        grid.add(radioButton1, 0,2,1,1);
        grid.add(radioButton2, 1,2,1,1);
        grid.add(button, 1,3,1,1);

        // scene created with grid pane as root node
        Scene scene = new Scene(grid, 300, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
//    public static void main(String[] args) {
//        Application.launch(args);
//    }
//    
}
