public class MaximizeContainerArea {
    // Brute force: O(n^2) time, O(1) space
    static int bruteForce(int[] heights) {
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int height = Math.min(heights[i], heights[j]);
                int width = j - i;
                maxArea = Math.max(maxArea, height * width);
            }
        }

        return maxArea;
    }

    // Two pointers: O(n) time, O(1) space
    static int maxContainerArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int height = Math.min(heights[left], heights[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, height * width);

            // Move the pointer at the shorter wall.
            if (heights[left] < heights[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println("Brute Force: " + bruteForce(heights));
        System.out.println("Two Pointer: " + maxContainerArea(heights));
    }
}
