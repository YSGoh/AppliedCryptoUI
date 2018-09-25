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
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppliedCryptoUI extends Application {
    
    Stage window;
    Scene scene1, scene2;
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Playfair1 Program");
        
        
        // initialize grid pane
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10); // horizontal spacing
        grid.setVgap(20); // vertical spacing
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // initialize grid2 pane
        GridPane grid2 = new GridPane();
        grid2.setAlignment(Pos.CENTER);
        grid2.setHgap(10); // horizontal spacing
        grid2.setVgap(20); // vertical spacing
        grid2.setPadding(new Insets(25, 25, 25, 25));
        
        // scene created with grid pane as root node
        Scene scene1 = new Scene(grid, 300, 250);
        Scene scene2 = new Scene(grid2, 300, 250);
        
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
        
        // add radio button to gridpane
        grid.add(radioButton1, 0,2,1,1);
        grid.add(radioButton2, 1,2,1,1);
       
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
        grid.add(button, 1,3,1,1);
        
        // button event
        button.setOnAction(e -> window.setScene(scene2));
       
        
        // initialize label
        Label input1 = new Label("Plaintext");
        grid2.add(input1, 0, 0);
        
        // initialize label
        Label input2 = new Label("Ciphertext");
        grid2.add(input2, 0, 2);
        
        TextField textField1 = new TextField();
        grid2.add(textField1, 0,1,1,1);
        
        TextField textField2 = new TextField();
        grid2.add(textField2, 0,3,1,1);
        
        window.setScene(scene1);
        window.show();
    }
    
    
}
