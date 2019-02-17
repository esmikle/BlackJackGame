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
public class Card {
    private Suit suit;
    private Rank rank;
    
    public Card(Rank rank, Suit suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    public String getSuit(){
        return suit.printSuit();
    }
    
    public int getRank(){
        return rank.getRank();
    }
    
    public String printCard(){
        return rank.printRank()+" of "+suit.printSuit();
    }
}    
