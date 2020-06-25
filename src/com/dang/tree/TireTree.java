package com.dang.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典树 / 前缀树
 * @author DangHT
 * @date 2020/06/25
 */
public class TireTree {

    static class TireNode {
        char val;
        List<TireNode> subNodes;

        TireNode(char val) {
            this.val = val;
            this.subNodes = new ArrayList<>(26);
        }
    }

    private final TireNode root;

    public TireTree() {
        root = new TireNode('/');
    }

    public void insert(String str) {
        int len = str.length();
        List<TireNode> temp = root.subNodes;
        for (int i = 0; i < len; i++) {
            boolean contain = false;
            for (TireNode sub : temp) {
                if (sub.val == str.charAt(i)) {
                    temp = sub.subNodes;
                    contain = true;
                }
            }
            if (!contain) {
                temp.add(new TireNode(str.charAt(i)));
                temp = temp.get(temp.size() - 1).subNodes;
            }
        }
    }

    public boolean search(String str) {
        int len = str.length();
        List<TireNode> temp = root.subNodes;
        for (int i = 0; i < len; i++) {
            boolean contain = false;
            for (TireNode sub : temp) {
                if (sub.val == str.charAt(i)) {
                    temp = sub.subNodes;
                    contain = true;
                }
            }
            if (!contain) {
                return false;
            }
        }
        return true;
    }
}


