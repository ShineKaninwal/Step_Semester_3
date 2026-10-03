import java.util.*;

public class MostPopularCanteenOrder {
    static void mostPopular(String[] orders) {
        HashMap<String, Integer> count = new HashMap<>();

        // Count every item using a hash map.
        for (String item : orders) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        String popular = orders[0];
        int max = count.get(popular);

        // Original order ensures correct tie-breaking.
        for (String item : orders) {
            if (count.get(item) > max) {
                max = count.get(item);
                popular = item;
            }
        }

        System.out.println("(\"" + popular + "\", " + max + ")");
    }

    public static void main(String[] args) {
        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        mostPopular(orders);
    }
}
