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
    
    public Card getCard(int index) {
        return hand.get(index);
    }
    
    public void setCard(int index, Card c) {
        hand.set(index, c);
    }

    public void showHand(FlowPane panel, boolean win) {

        panel.getChildren().clear();
        for (Card c : hand) {
            if (win) {
                c.setFace(true);
            }
            panel.getChildren().add(c.getImage());
            c.getImage().setPreserveRatio(true);
            c.getImage().setFitWidth(100);
        }
    }

    public int calculateSum() {
        // CHALLENGE: Calculate the sum
        int sum = 0;
        boolean hasAce = false;
        for (Card c : hand) {
            sum += c.getRank();
            if(c.getRank() == 1){
                hasAce = true;
            }
        }
        if(hasAce==true && sum <= 11){
            sum += 10;
        }
        return sum;
    }

    public void clearHand() {
        hand.clear();
    }
}
