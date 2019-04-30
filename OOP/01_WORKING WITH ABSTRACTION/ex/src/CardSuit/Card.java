package CardSuit;

public class Card {
    private String rank;
    private String  suitPower;
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suitPower = suit;
    }

    @Override
    public String toString() {
        int cardPower = cardRank.valueOf(this.rank).value + cardsType.valueOf(this.suitPower).suit;
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suitPower, cardPower);
    }
}
