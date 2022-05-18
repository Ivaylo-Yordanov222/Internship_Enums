import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Card> deck = new ArrayList<>();

        for(int i = 0; i < CardSuit.values().length; i++){
           for (int j = 0; j < CardRank.values().length; j++){
               Card currentCard = new Card(CardSuit.values()[i],CardRank.values()[j]);
               deck.add(currentCard);
           }
        }
        deck.forEach(System.out::println);
    }
}