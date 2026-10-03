public class HotWeatherAlertWindows {
    static int countAlerts(int[] readings, int k, int threshold) {
        int sum = 0;
        int alerts = 0;

        // Calculate the first window.
        for (int i = 0; i < k; i++) {
            sum += readings[i];
        }

        if (sum >= k * threshold) {
            alerts++;
        }

        // Slide the window one position at a time.
        for (int i = k; i < readings.length; i++) {
            sum += readings[i];
            sum -= readings[i - k];

            if (sum >= k * threshold) {
                alerts++;
            }
        }

        return alerts;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};

        System.out.println(
            countAlerts(readings, 3, 4)
        );
    }
}
