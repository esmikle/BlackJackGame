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
public enum Rank {
    ACE("Ace",1),
    TWO("2", 2),
    THREE("3", 3),
    FOUR("4", 4),
    FIVE("5", 5),
    SIX("6", 6),
    SEVEN("7", 7),
    EIGHT("8", 8),
    NINE("9", 9),
    TEN("10", 10),
    JACK("Jack", 10),
    QUEEN("Queen", 10),
    KING("King", 10);
    
    private final String rankText;
    private final int rankValue;
    
    private Rank(String rankText, int rank){
        this.rankText = rankText;
        this.rankValue = rank;
    }
    
    public int getRank() {
        return rankValue;
    }
    
    public String printRank(){
        return rankText;
    }
    
}
