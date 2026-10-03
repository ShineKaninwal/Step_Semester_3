import java.util.*;

public class PairWithTargetSum {
    // Approach 1: Brute force - O(n^2) time, O(1) space
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
    static boolean hashSetApproach(int[] nums, int target) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;

            if (set.contains(complement))
                return true;

            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int[] nums2 = {3, 4, 6};

        System.out.println(bruteForce(nums1, 9));
        System.out.println(hashSetApproach(nums1, 9));
        System.out.println(bruteForce(nums2, 20));
        System.out.println(hashSetApproach(nums2, 20));
    }
}
