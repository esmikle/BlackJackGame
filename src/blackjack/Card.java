/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author elizabethsmikle
 */
public class Card {

    private Suit suit;
    private Rank rank;
    private Image img;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Card(Rank rank, Suit suit, Image img) {
        this.rank = rank;
        this.suit = suit;
        this.img = img;
    }

    public String getSuit() {
        return suit.printSuit();
    }

    public int getRank() {
        return rank.getRank();
    }

    public void setImage(Image givenImage) {
        this.img = givenImage;
    }

    public ImageView getImage() {
        ImageView viewer = new ImageView(img);
        viewer.setPreserveRatio(true);
        viewer.setFitWidth(100);
        return viewer;
    }

    public String printCard() {
        return rank.printRank() + " of " + suit.printSuit();
    }

    public String GetFileName() {
        return rank + "_of_" + suit + ".png";
    }
}
