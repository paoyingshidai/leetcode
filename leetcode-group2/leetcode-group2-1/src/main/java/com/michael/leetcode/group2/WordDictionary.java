package com.michael.leetcode.group2;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 */
public class WordDictionary {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        // 指针
        Node curNode = root;
        for (int i = 0; i < word.length(); i++) {
            // 获取 char
            char curChar = word.charAt(i);

            // 如果没有就新建节点
            if (!curNode.containKey(curChar)) {
                curNode.set(curChar, new Node());
            }
            // 指针下移
            curNode = curNode.get(curChar);
        }
        curNode.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word, root, 0);
    }

    private boolean match(String word, Node node, int start) {
        if (start == word.length()) {
            return node.isEnd;
        }
        char alpha = word.charAt(start);
        if (alpha == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.datas[i] != null && match(word, node.datas[i], start + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.containKey(alpha)) {
                return false;

            }
            return match(word, node.get(alpha), start + 1);
        }
    }

    class Node {

        // 可以用 Map 取代
        private Node[] datas;
        private boolean isEnd;

        public Node() {
            datas = new Node[26];
            isEnd = false;
        }

        public Node get(char key) {
            return datas[key - 'a'];
        }

        public void set(char key, Node value) {
            datas[key - 'a'] = value;
        }

        public boolean containKey(char key) {
            return datas[key - 'a'] != null;
        }
    }

//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/solution/yu-dao-tong-pei-fu-shi-di-gui-chu-li-python-dai-ma/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
