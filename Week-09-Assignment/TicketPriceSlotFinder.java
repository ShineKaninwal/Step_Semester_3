public class TicketPriceSlotFinder {
    static int findSlot(int[] prices, int newPrice) {
        int low = 0;
        int high = prices.length - 1;

        // Binary search finds the existing or insertion position.
        while (low <= high) {
            int mid = (low + high) / 2;

            if (prices[mid] == newPrice) {
                return mid;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // low is the correct insertion position.
        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};

        System.out.println(findSlot(prices, 150));
        System.out.println(findSlot(prices, 210));
        System.out.println(findSlot(prices, 300));
    }
}
