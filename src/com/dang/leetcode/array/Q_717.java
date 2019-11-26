package com.dang.leetcode.array;

/**
 * 1比特与2比特字符(https://leetcode-cn.com/problems/1-bit-and-2-bit-characters/)
 * @author dht
 * @date 26/11/2019
 */
public class Q_717 {

    public boolean isOneBitCharacter(int[] bits) {
        boolean res = false;
        int i = 0;
        while (i < bits.length) {
            if (bits[i] == 1) i += 2;
            else {
                if (i == bits.length - 1 && bits[i] == 0)
                    return true;
                i++;
            }
        }
        return false;
    }

}
