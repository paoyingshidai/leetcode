package com.michael.leetcode.group1;

import com.sun.jmx.snmp.tasks.ThreadService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Rotate {


    /**
     * 时间复杂度 O(n2)
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            int j = nums.length-1;

            while (j > 0) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[0] = temp;
        }
    }


    /**
     * 官方
     * 环替换
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    /**
     * 官方：
     *
     * 先整体反转，在找到断点，反转前段，后反转后段
     * @param nums
     * @param k
     */
    public void rotate5(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    // 这里的反转的小技能
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;           // 前后同时向中间靠拢
            end--;
        }
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/rotate-array/solution/xuan-zhuan-shu-zu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


    /**
     * 折半反转，以中间为界限，nums[i] <-> nums[nums.len - 1 - i]
     * 必须在原数组上进行操作
     * @param nums
     */
    public void rotate3(int[] nums) {

        int mid = nums.length / 2;

        for (int i = 0; i < mid; i++) {
            int temp = nums[i];
            int index = nums.length - 1 - i;
            nums[i] = nums[index];
            nums[index] = temp;
        }
    }

    /**
     * 反转数组
     * 空间复杂度不符合要求
     */
    public int[] rotate2(int[] nums) {

        int[] res = new int[nums.length];

        for (int i = nums.length-1; i >= 0; i--) {
            int index = res.length - 1 - i;
            res[index] = nums[i];
        }
        return res;
    }


    public static int a = 1;
    public static int b;
    public static int c;

    static {
        System.out.println(a);
        a = 2;
        b = 2;
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        service.submit(() -> {
            System.out.println("hello");
        });

        service.shutdown();



//        Rotate rotate = new Rotate();
//        int[] data = new int[]{1, 2, 3, 4, 5, 6};
////        int[] result = rotate.rotate2(data);
////        rotate.rotate3(data);
//        rotate.rotate(data, 3);
//        for (int i : data) {
//            System.out.println(i);
//        }

    }

}
