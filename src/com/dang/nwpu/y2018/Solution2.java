package com.dang.nwpu.y2018;

import java.util.Arrays;

/**
 * 编写程序, 从键盘输入任意一组正整数,
 * 检查其中是否存在任意三个数符合因数关系, 即满足a*b=c
 * @author dht925nerd@126.com
 * @date 2019/02/26
 */
public class Solution2 {

    private static boolean check(int[] array){
        if (array == null || array.length < 3) return false;
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++){
            for (int j = i + 1; j < array.length; j++){
                for (int k = j + 1; k < array.length; k++){
                    if (array[k] == array[i] * array[j]){
                        System.out.println("存在" + array[i] + "*" + array[j] + "=" + array[k]);
                        return true;
                    }
                    if (array[k] > array[i] * array[j]) break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {6, 4, 3, 7, 1, 2};
        System.out.println(check(array));
    }
}
