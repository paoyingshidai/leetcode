package com.michael.leetcode.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author Michael
 */
public class LevelOrder {

    public int[] levelOrder(TreeNode root) {

        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<TreeNode>(){{ add(root); }};
        ArrayList<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            ans.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;

//        作者：jyd
//        链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/solution/mian-shi-ti-32-i-cong-shang-dao-xia-da-yin-er-ch-4/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }


    public List<List<Integer>> levelOrderII(TreeNode root) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        doLevelOrderII(map, root, 0);

        return map.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
    }

    public void doLevelOrderII(Map<Integer, List<Integer>> result, TreeNode root, int depth) {

        if (root == null) {
            return;
        }

        List<Integer> integers = result.get(depth);
        if (integers == null) {
            integers = new ArrayList<>();
            result.put(depth, integers);
        }

        integers.add(root.val);

        doLevelOrderII(result, root.left, depth + 1);
        doLevelOrderII(result, root.right, depth + 1);
    }


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
