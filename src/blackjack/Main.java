/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
        root.setStyle("-fx-background-color: #228B22;");
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

        Button start = new Button("Start");
        start.setOnAction(e -> {
            // Initialize Deck
            deck.initDeck();
            deck.shuffle();
            deck.deal(player, dealer, 2);
            player.showHand(playerPanel, false);
            dealer.showHand(dealerPanel, false);
        });

        // Hit button action 
        Button hit = new Button("Hit");
        hit.setOnAction((ActionEvent e) -> {
            //dealToPlayer then check if player busted
            deck.deal(player);
            player.showHand(playerPanel, false);
            if (player.calculateSum() > 21) {
                // Message box player is busted
                Alert busted = new Alert(AlertType.INFORMATION, "You're Busted!", ButtonType.CLOSE);
                busted.showAndWait();
                root.setCenter(playerPanel);
                playerPanel.getChildren().clear();
                dealerPanel.getChildren().clear();
                player.clearHand();
                dealer.clearHand();
                deck.clearHand();
            }
        });

        // Stay Button action
        Button stay = new Button("Stay");
        stay.setOnAction((e) -> {
            String winner;
            while (dealer.calculateSum() < 15 && isWinner() != dealer) {
                deck.deal(dealer);
                dealer.showHand(dealerPanel, false);
            }
            if (isWinner() == dealer) {
                winner = "Dealer";
            } else {
                winner = "Player";
            }
            dealer.showHand(dealerPanel, true);
            Alert win = new Alert(AlertType.INFORMATION, winner + " Wins!", ButtonType.CLOSE);
            win.showAndWait();
            root.setCenter(playerPanel);
            playerPanel.getChildren().clear();
            dealerPanel.getChildren().clear();
            player.clearHand();
            dealer.clearHand();
            deck.clearHand();

        });

        Button clear = new Button("Clear");
        clear.setOnAction(e -> {
            playerPanel.getChildren().clear();
            dealerPanel.getChildren().clear();
            player.clearHand();
            dealer.clearHand();
            deck.clearHand();
        });

        Button quit = new Button("Quit");
        quit.setOnAction(e -> {
            primaryStage.close();
        });

        // Add buttons to window
        buttonPanel.getChildren().addAll(start, hit, stay, clear, quit);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Hand isWinner() {
        if (dealer.calculateSum() < 21 && dealer.calculateSum() > player.calculateSum()) {
            return dealer;
        } else if (dealer.calculateSum() == 21) {
            return dealer;
        } else if (player.calculateSum() > 21) {
            return dealer;
        } else {
            return player;
        }
    }
}
