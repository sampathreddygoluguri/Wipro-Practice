/*
Target Sum
Rohan is given a task two return indices of pair whose sum will be equal to the given target.
Only one such pair is required.

Input Format

size of the array
array elements
target

Output Format
index pair whose sum is equal to the target

Input 
4
2 7 11 15
9

Output
(0 , 1)

Explanation
Because nums[0] + nums[1] = 2 + 7 = 9  */

import java.util.*;

class TargetSum{
    static int[] twoSum(int n, int[] nums, int target) {
       //write your answer here
       Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(nums[i], i);
        }
        return new int[]{-1, -1}; // if no pair found
    }
    
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = in.nextInt();
        int target = in.nextInt();
        int[] ans = twoSum(n,arr,target);
        System.out.println("("+ans[0]+" , "+ans[1]+")");
    }

}
