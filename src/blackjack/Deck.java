/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import javafx.scene.image.Image;

/**
 *
 * @author elizabethsmikle
 */
public class Deck extends Hand {
    
    public void initDeck() {

        for (Rank r : Rank.values()) {
            for (Suit s : Suit.values()) {
                Image img = new Image("cards/" + r.printRank() + "_of_" + s.printSuit() + ".png");
                Card c = new Card(r, s, img);
                this.addCard(c);
            }
        }
    }

    public void deal(Hand player, Hand dealer, int number) {
        Card c;
        for (int i = 0; i < number; i++) {
            c = this.removeCard(0);
            player.addCard(c);
            
            c = this.removeCard(0);
            if(i == 0){
                c.setFace(false);
            }
            dealer.addCard(c);
        }
    }
    
    public void deal(Hand hand){
        Card c = this.removeCard(0);
        hand.addCard(c);
    }

    public void shuffle() {
        for(int i = 0; i < 51; i++){
            int rand = (int)(1+Math.random()*50);
            Card pick = this.getCard(rand);
            Card last = this.getCard(i);
            this.setCard(i, pick);
            this.setCard(rand, last);
        }
    }

}
