/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author elizabethsmikle
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Blackjack");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Button b1 = new Button("Happy");
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Image happy = new Image("smiley-face.jpeg");
                ImageView iv = new ImageView(happy);
                //root.getChildren().add(iv);
                root.setCenter(iv);
            }
        });
        
        Button b2 = new Button("Sad");
        b2.setOnAction((a) -> {
            Image sad = new Image("sad-face.jpeg");
            ImageView iv = new ImageView(sad);
            root.setCenter(iv);
        });
        
        FlowPane buttonPanel = new FlowPane();
        buttonPanel.setAlignment(Pos.CENTER);
        buttonPanel.getChildren().addAll(b1, b2);
        
        root.setBottom(buttonPanel);
       
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
