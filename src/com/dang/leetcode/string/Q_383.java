package com.dang.leetcode.string;

import java.util.Arrays;

/**
 * 赎金信(https://leetcode-cn.com/problems/ransom-note/)
 * @author dht
 * @date 22/08/2019
 */
public class Q_383 {

    public static void main(String[] args) {
        String ransomNote = "fihjjjjei";
        String magazine = "hjibagacbhadfaefdjaeaebgi";

        System.out.println(canConstruct_01(ransomNote, magazine));
    }

    /**
     * 6ms
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct_01(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        int[] words = new int[26];
        int count = ran.length;

        for (char c : ran) {
            words[c - 'a']++;
        }

        for (char c : mag) {
            if (words[c - 'a'] > 0) {
                words[c - 'a']--;
                count--;
            }
        }

        return count == 0;
    }

    /**
     * 25ms
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct_02(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();

        Arrays.sort(ran);
        Arrays.sort(mag);

        int i = 0, j = 0;
        while (i < ran.length && j < mag.length) {
            if (ran[i] == mag[j]) {
                i++;
                j++;
            } else if (ran[i] > mag[j]) {
                j++;
            } else {
                return false;
            }
        }
        return i >= ran.length;
    }

    /**
     * 1ms
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct_03(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        char[] noteChar = ransomNote.toCharArray();
        int[] nums = new int[256];
        for(int i=0;i<noteChar.length;i++){
            int index = magazine.indexOf(noteChar[i],nums[noteChar[i]]);
            if(index<0){
                return false;
            }
            nums[noteChar[i]]=index+1;
        }
        return true;
    }

}
