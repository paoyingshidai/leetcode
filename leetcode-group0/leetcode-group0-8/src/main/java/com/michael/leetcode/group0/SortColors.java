package com.michael.leetcode.group0;

/**
 * 75
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {

    /*
    荷兰三色旗问题解
  */
    public void sortColors2(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;

        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0个和第curr个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // 交换第k个和第curr个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr++;
        }
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public void sortColors(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
    }


    public void shellSort(int[] nums) {

        for (int increment = nums.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < nums.length; i++) {
                int temp = nums[i];
                int j;
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < nums[j]) {
                        nums[j + increment] = nums[j];
                    } else {
                        break;
                    }
                }
                nums[j + increment] = temp;
            }
        }
    }


    public int partition(int[] nums, int low, int hight) {

        int base = nums[low];

        while (low < hight) {
            while (base <= nums[hight] && hight > low) {
                hight--;
            }
            nums[low] = nums[hight];

            while (base >= nums[low] && hight > low) {
                low++;
            }
            nums[hight] = nums[low];
        }
        nums[hight] = base;
        return hight;
    }


    public void quickSort(int[] nums, int low, int hight) {
        if (low >= hight) return;

        int index = partition(nums, low, hight);

        quickSort(nums, low, index - 1);
        quickSort(nums, index + 1, hight);
    }

    public static void main(String[] args) {
        SortColors sortColors = new SortColors();

        int[] data = new int[]{2, 0, 2, 1, 1, 0};

//        sortColors.sortColors(data);
        sortColors.shellSort(data);

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }


    }

}
