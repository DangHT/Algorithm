package com.dang.leetcode.hash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 设计哈希集合(https://leetcode-cn.com/problems/design-hashset/)
 * @author dht
 * @date 23/11/2019
 */
public class Q_705 {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));
        hashSet.add(2);
        System.out.println(hashSet.contains(2));
        hashSet.remove(2);
        System.out.println(hashSet.contains(2));
    }

}

class MyHashSet {

    private int hashCode;

    private List<List<Integer>> map;

    /** Initialize your data structure here. */
    public MyHashSet() {
        this.hashCode = 101;
        this.map = new ArrayList<>(hashCode);
        for (int i = 0; i < hashCode; i++) {
            map.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        int index = key % hashCode;
        List<Integer> list = map.get(index);
        for (int k : list) {
            if (k == key) return;
        }
        list.add(key);
    }

    public void remove(int key) {
        int index = key % hashCode;
        List<Integer> list = map.get(index);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == key) {
                list.remove(i);
                return;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int index = key % hashCode;
        List<Integer> list = map.get(index);
        for (int k : list) {
            if (k == key) return true;
        }
        return false;
    }
}