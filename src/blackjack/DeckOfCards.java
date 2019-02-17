/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author elizabethsmikle
 */
public class DeckOfCards {

    private Card[] deck = new Card[52];
    private final static String[] SUITS = {"Hearts", "Spades", "Diamonds", "Clubs"};

    public DeckOfCards() {
        for (int j = 0; j < SUITS.length; j++) {
            for (int i = 0; i < deck.length; i++) {
                deck[i].setRank(i + 1);
                deck[i].setSuit(SUITS[j]);
            }
        }
    }
    
    public void shuffleDeck(int numberOfTimes) {
        
    } 
        
            
}
