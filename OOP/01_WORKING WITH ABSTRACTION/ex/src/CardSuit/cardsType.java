package CardSuit;

public enum cardsType {
    CLUBS(0),  DIAMONDS(13), HEARTS(26), SPADES(39);
    int suit;

    cardsType(int suit) {
        this.suit = suit;
    }
}
