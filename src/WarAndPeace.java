import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
public final class WarAndPeace {
    public static void startWarAndPeace(Queue<Card> playerOneDeck, Queue<Card> playerTwoDeck){
        int roundCounter = 0;
        while (playerOneDeck.size() != 0 && playerTwoDeck.size() != 0){
            roundCounter++;
            Card playerOneCurrentCard = playerOneDeck.remove();
            Card playerTwoCurrentCard = playerTwoDeck.remove();
            if(playerOneCurrentCard.compareTo(playerTwoCurrentCard) > 0){
                playerOneDeck.add(playerOneCurrentCard);
                playerOneDeck.add(playerTwoCurrentCard);
            }
            else if(playerOneCurrentCard.compareTo(playerTwoCurrentCard) < 0){
                playerTwoDeck.add(playerTwoCurrentCard);
                playerTwoDeck.add(playerOneCurrentCard);
            }else{
                war(playerOneCurrentCard,playerTwoCurrentCard,playerOneDeck,playerTwoDeck, roundCounter);
            }
        }
        String winner = playerOneDeck.size() == 0? "2":"1";
        System.out.println("Player " + winner + " wins on round " + roundCounter + "." );
    }
    private static void war(Card playerOneCurrentCard,Card playerTwoCurrentCard, Queue<Card> playerOneDeck, Queue<Card> playerTwoDeck, int roundCounter){
        int sumP1 = 0;
        int sumP2 = 0;
        List<Card> p1subDeck = new ArrayList<>();
        List<Card> p2subDeck = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            Card p1 = playerOneDeck.remove();
            p1subDeck.add(p1);
            Card p2 = playerTwoDeck.remove();
            p2subDeck.add(p2);
            sumP1 += p1.getRank().getValue();
            sumP2 += p2.getRank().getValue();
        }
        if(sumP1 > sumP2){
            playerOneDeck.add(playerOneCurrentCard);
            playerOneDeck.add(playerTwoCurrentCard);
            fillSubDecks(p1subDeck,p2subDeck,playerOneDeck);
        }else if(sumP1 < sumP2){
            playerTwoDeck.add(playerTwoCurrentCard);
            playerTwoDeck.add(playerOneCurrentCard);
            fillSubDecks(p2subDeck,p1subDeck,playerTwoDeck);
        }else{
            System.out.println("Game is draw on round "+ roundCounter + ".");
            System.exit(0);
        }
    }
    private static void fillSubDecks(List<Card> subDeck1, List<Card> subDeck2, Queue<Card> playerDeck){
        playerDeck.addAll(subDeck1);
        playerDeck.addAll(subDeck2);
    }
}
