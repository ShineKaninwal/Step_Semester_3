import java.util.*;

public class PairWithTargetSumArray {
    // Approach 1: Check every pair - O(n^2) time, O(1) space
    static boolean bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return true;
            }
        }
        return false;
    }

    // Approach 2: HashSet - O(n) average time, O(n) space
    static boolean usingHashSet(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(target - num))
                return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 4, 6};

        System.out.println("Brute Force: " + bruteForce(nums1, 9));
        System.out.println("HashSet: " + usingHashSet(nums1, 9));

        System.out.println("Brute Force: " + bruteForce(nums2, 20));
        System.out.println("HashSet: " + usingHashSet(nums2, 20));
    }
}
