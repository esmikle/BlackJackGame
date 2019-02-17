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
    private String suit;
    private int rank;
    
    public Card (int givenRank, String givenSuit) {
        if(suit.equals("Hearts")||suit.equals("Spades")||suit.equals("Diamonds")||suit.equals("Clubs")){
            this.suit = givenSuit;
        } else {
            System.out.println("Error: Not a valid suit");
        }
        
        if(rank < 14 && rank > 0){
            this.rank = givenRank;
        } else {
            System.out.println("Error: Not a valid rank");
        }
    }
    
    public Card (){}
    
    public void setRank(int rank){
        if(rank < 14 && rank > 0){
            this.rank = rank;
        } else {
            System.out.println("Error: Not a valid rank");
        }
    }
    
    public int getRank(){
        return this.rank;
    }
    
    public void setSuit(String suit){
        if(suit.equals("Hearts")||suit.equals("Spades")||suit.equals("Diamonds")||suit.equals("Clubs")){
            this.suit = suit;
        } else {
            System.out.println("Error: Not a valid suit");
        }
    }
    
    public String getSuit(){
        return this.suit;
    }
}
