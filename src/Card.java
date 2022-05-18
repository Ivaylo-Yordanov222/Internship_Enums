public class Card implements  Comparable<Card>{
    private final CardSuit color;
    private final CardRank rank;

    public Card(CardSuit color, CardRank rank) {
        this.color = color;
        this.rank = rank;
    }

    @Override
    public String toString(){
        return rank + " of " + color;
    }

    @Override
    public int compareTo(Card t) {
        return rank.compareTo(t.rank);
    }
}
