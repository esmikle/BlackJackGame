/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author elizabethsmikle
 */
public class Hand {

    private ArrayList<Card> hand;

    public Hand() {
        this.hand = new ArrayList<>();
    }

    public void addCard(Card givenCard) {
        hand.add(givenCard);
    }

    public Card removeCard(int index) {
        return hand.remove(index);
    }

    public void showHand(FlowPane panel) {
        panel.getChildren().clear();
        for (Card c : hand) {
            panel.getChildren().add(c.getImage());
            c.getImage().setPreserveRatio(true);
            c.getImage().setFitWidth(100);
        }
    }

    public boolean isOver() {
        // CHALLENGE: Calculate the sum
        int sum = 0;
        for (Card c : hand) {
            sum += c.getRank();
        }
        return sum > 21;
    }

    public void clearHand() {
        hand.clear();
    }
}
