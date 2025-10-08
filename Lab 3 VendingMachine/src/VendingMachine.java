import java.util.*;

public class VendingMachine {

    private Map<String, Double> beverages;
    private Map<Integer, Double> cards;
    private Map<Integer, Column> columns;

    public VendingMachine() {
        beverages = new HashMap<>();
        cards = new HashMap<>();
        columns = new TreeMap<>();
    }

    public void addBeverage(String name, double price) {
        beverages.put(name,price);
    }

    public double getPrice(String beverageName) {
        if (beverages.containsKey(beverageName)) {
            return beverages.get(beverageName);
        }
        return -1.0;
    }

    public void rechargeCard(int cardId, double credit) {
        if (cards.containsKey(cardId)) {
            cards.put(cardId,credit + cards.get(cardId));
        } else {
            cards.put(cardId,credit);
        }
    }

    public double getCredit(int cardId) {
        if (cards.containsKey(cardId)) {
            return cards.get(cardId);
        }
        return -1.0;
    }

    public void refillColumn(int column, String beverageName, int cans) {
        Column c = new Column(column, beverageName, cans);
        columns.put(column, c);
    }

    public int availableCans(String beverageName) {
        int total = 0;

        for (Column c: columns.values()) {
            if(c.getBeverageName().equals(beverageName)) {
                total += c.getCans();
            }
        }
        return total;
    }

    public void sell(String beverageName, int cardId) {
        if (
                !cards.containsKey(cardId) ||
                availableCans(beverageName) == 0 ||
                getCredit(cardId) < getPrice(beverageName)
        ) {
            return;
        }

        cards.put(cardId, cards.get(cardId) - getPrice(beverageName));

        for (Column c: columns.values()) {
            if (c.getBeverageName().equals(beverageName) && c.getCans() > 0) {
                c.Decrease();
                return;
            }
        }

    }
}
