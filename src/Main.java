public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(CardSuit value : CardSuit.values()){
            sb.append(value).append(", ");
        }
        System.out.println(sb.substring(0,sb.length()-2));
        sb.setLength(0);
        for(CardRank value : CardRank.values()){
            sb.append(value).append(", ");
        }
        System.out.println(sb.substring(0,sb.length()-2));
    }
}