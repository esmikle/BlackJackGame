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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
    // Create Deck, Player and Dealer Hand

    Deck deck = new Deck();
    Hand player = new Hand();
    Hand dealer = new Hand();

    private FlowPane playerPanel;
    private FlowPane dealerPanel;

    @Override
    public void start(Stage primaryStage) {
        // Set up window
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("Blackjack");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Button panel 
        FlowPane buttonPanel = new FlowPane();
        buttonPanel.setAlignment(Pos.CENTER);
        root.setBottom(buttonPanel);

        // Create player panel for cards
        playerPanel = new FlowPane();
        root.setCenter(playerPanel);
        playerPanel.setAlignment(Pos.CENTER);

        // Create dealer panel for cards
        dealerPanel = new FlowPane();
        root.setTop(dealerPanel);
        dealerPanel.setAlignment(Pos.CENTER);

        // Initialize Deck
        deck.initDeck();
        deck.deal(player, dealer, 2);
        player.showHand(playerPanel);
        dealer.showHand(dealerPanel);
        
        // Hit button action 
        Button hit = new Button("Hit");
        hit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                //dealToPlayer then check if player busted
                deck.deal(player);
                player.showHand(playerPanel);
                if (player.isOver()) {
                    // Message box player is busted
                   Alert busted = new Alert(AlertType.INFORMATION, "You're Busted!", ButtonType.CLOSE);
                   busted.showAndWait();
                   root.setCenter(playerPanel);
                }
                // Player can continue
            }
        });

        // Stay Button action
        Button stay = new Button("Stay");
        stay.setOnAction((e) -> {
            System.out.println("Staying");
        });

        // Add buttons to window
        buttonPanel.getChildren().addAll(hit, stay);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
