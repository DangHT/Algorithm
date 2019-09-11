package com.dang.leetcode.math;

/**
 * 数字的补数(https://leetcode-cn.com/problems/number-complement/)
 * @author dht
 * @date 11/09/2019
 */
public class Q_476 {

    public static void main(String[] args) {
        System.out.println(findComplement_01(1));
        System.out.println(findComplement_02(5));
    }

    /**
     * 将数字转换成字符串进行进制转换
     * @param num
     * @return
     */
    public static int findComplement_01(int num) {
        String bin = intToBinary(num);
        bin = onesComplement(bin);
        return binaryToInt(bin);
    }

    /**
     * 直接利用位运算
     * 取反码即等同于各位与1异或, 因此我们需要找到与所求数等长的各位全为1的数
     * @param num
     * @return
     */
    public static int findComplement_02(int num) {
        int temp = num, c = 0;
        while (temp > 0) {
            temp >>= 1;
            c = (c << 1) + 1;
        }
        return num ^ c;
    }

    private static String intToBinary(int num) {
        StringBuilder builder = new StringBuilder();
        toBinary(num, builder);
        return builder.toString();
    }

    private static void toBinary(int num, StringBuilder builder) {
        if (num == 0) return;
        toBinary(num / 2, builder);
        builder.append(num % 2);
    }

    private static String onesComplement(String bin) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') builder.append('1');
            if (bin.charAt(i) == '1') builder.append('0');
        }
        return builder.toString();
    }

    private static int binaryToInt(String bin) {
        int num = 0;
        for (int i = 0, pow = bin.length() - 1; i < bin.length(); i++, pow--) {
            if (bin.charAt(i) == '1') {
                num += Math.pow(2, pow);
            }
        }
        return num;
    }

}
