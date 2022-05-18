import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] firstPlayerCards = sc.nextLine().trim().split(" ");
        String[] secondPlayerCards = sc.nextLine().trim().split(" ");

        Queue<Card> playerOneDeck = new LinkedList<>();
        Queue<Card> playerTwoDeck = new LinkedList<>();

        System.out.println();
        fillDeck(firstPlayerCards, playerOneDeck);
        fillDeck(secondPlayerCards, playerTwoDeck);
        WarAndPeace.startWarAndPeace(playerOneDeck,playerTwoDeck);
    }
    private static void fillDeck(String[] playerCards, Queue<Card> deck) {
        for (String playerCard : playerCards) {
            Card currentCard = switchCards(playerCard);
            deck.add(currentCard);
        }
    }
    private static Card switchCards(String playerCard) {
        CardRank cardRank = null;
        CardSuit cardSuit = null;
        switch (playerCard.charAt(0)){
            case '2':
                cardRank = CardRank.Two;
                break;
            case '3':
                cardRank = CardRank.Three;
                break;
            case '4':
                cardRank = CardRank.Four;
                break;
            case '5':
                cardRank = CardRank.Five;
                break;
            case '6':
                cardRank = CardRank.Six;
                break;
            case '7':
                cardRank = CardRank.Seven;
                break;
            case '8':
                cardRank = CardRank.Eight;
                break;
            case '9':
                cardRank = CardRank.Nine;
                break;
            case 'T':
                cardRank = CardRank.Ten;
                break;
            case 'J':
                cardRank = CardRank.Jack;
                break;
            case 'Q':
                cardRank = CardRank.Queen;
                break;
            case 'K':
                cardRank = CardRank.King;
                break;
            case 'A':
                cardRank = CardRank.Ace;
                break;
        }
        switch (playerCard.charAt(1)){
            case 'c':
                cardSuit = CardSuit.Clubs;
                break;
            case 'd':
                cardSuit = CardSuit.Diamonds;
                break;
            case 'h':
                cardSuit = CardSuit.Hearts;
                break;
            case 's':
                cardSuit = CardSuit.Spades;
                break;
        }
        return new Card(cardSuit,cardRank);
    }
}