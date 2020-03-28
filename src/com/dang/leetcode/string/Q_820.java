package com.dang.leetcode.string;

import java.util.Arrays;

/**
 * 单词的压缩编码(https://leetcode-cn.com/problems/short-encoding-of-words/)
 * @author DangHT
 * @date 28/03/2020
 */
public class Q_820 {

    /**
     * 我的初始解法
     */
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) return 0;
        boolean[] combined = new boolean[words.length];
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            if (!combined[i]) {
                int len = words[i].length();
                for (int j = i + 1; j < words.length; j++) {
                    int longer = len > words[j].length() ? i : j;
                    int shorter = longer == i ? j : i;
                    if (words[longer].endsWith(words[shorter])) {
                        combined[shorter] = true;
                        if (i == shorter) break;
                    }
                }
                if (!combined[i]) res += len + 1;
            }
        }
        return res;
    }

    /**
     * 字典序(TireTree)解法
     */
    public int minimumLengthEncodingTire(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 先对单词列表根据单词长度由长到短排序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        // 单词插入trie，返回该单词增加的编码长度
        for (String word: words) {
            len += trie.insert(word);
        }
        return len;
    }

    // 定义tire
    class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public int insert(String word) {
            TrieNode cur = root;
            boolean isNew = false;
            // 倒着插入单词
            for (int i = word.length() - 1; i >= 0; i--) {
                int c = word.charAt(i) - 'a';
                if (cur.children[c] == null) {
                    isNew = true; // 是新单词
                    cur.children[c] = new TrieNode();
                }
                cur = cur.children[c];
            }
            // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
            return isNew? word.length() + 1: 0;
        }
    }

    class TrieNode {
        char val;
        TrieNode[] children = new TrieNode[26];

        public TrieNode() {}
    }

}
