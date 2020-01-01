package com.michael.leetcode.group2;

public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // 插入
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            if (!node.containsKey(currentChar)) {
                node.put(currentChar, new TrieNode());
            }
            node = node.get(currentChar);
        }
        node.setEnd();
    }

    // 这个单词是否存在于这个树
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }


    // 是否存在这个前缀
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }

    private TrieNode searchPrefix(String word) {
        // 指针
        TrieNode node = root;
        // 循环字符串
        for (int i = 0; i < word.length(); i++) {
            char curLetter = word.charAt(i);
            // 当前节点中是否存在这个字符
            if (node.containsKey(curLetter)) {
                // 如果有的话，指针下移
                node = node.get(curLetter);
            } else {
                return null;
            }
        }
        return node;
    }


    public static void main(String[] args) {

        System.out.println('f' - 'a');

    }




    class TrieNode {

        // R links to node children
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            // 这个处理是为了获取 index
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

//    作者：LeetCode
//    链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree/solution/shi-xian-trie-qian-zhui-shu-by-leetcode/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
