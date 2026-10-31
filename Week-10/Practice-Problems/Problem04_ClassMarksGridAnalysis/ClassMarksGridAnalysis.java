import java.util.*;
public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<int[]> rows = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            int left = line.indexOf('['), right = line.indexOf(']');
            if (left < 0 || right < left) continue;
            String name = line.substring(0, left).trim();
            String[] nums = line.substring(left + 1, right).split(",");
            if (nums.length != 3) continue;
            int[] marks = new int[3];
            for (int j = 0; j < 3; j++) marks[j] = Integer.parseInt(nums[j].trim());
            names.add(name);
            rows.add(marks);
        }
        if (rows.isEmpty()) return;
        int[][] grid = rows.toArray(new int[0][]);
        int[] subjectTotals = new int[3];
        int best = Integer.MIN_VALUE;
        String topper = "";
        StringJoiner totals = new StringJoiner(", ", "Totals ", "");
        for (int i = 0; i < grid.length; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) { total += grid[i][j]; subjectTotals[j] += grid[i][j]; }
            totals.add(names.get(i) + " " + total);
            if (total > best) { best = total; topper = names.get(i); }
        }
        System.out.println(totals);
        System.out.printf(Locale.US, "averages %.2f, %.2f, %.2f%n", subjectTotals[0] / (double) grid.length,
            subjectTotals[1] / (double) grid.length, subjectTotals[2] / (double) grid.length);
        System.out.println("topper " + topper + " (" + best + ")");
    }
}
