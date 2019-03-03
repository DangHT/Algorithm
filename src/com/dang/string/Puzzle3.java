package com.dang.string;

/**
 * 如果一个字符串str, 把字符串str前面任意的部分挪到后面去形成的字符串叫做str的旋转词
 * 例如str = "1234", str的旋转词有:
 * "1234", "2341", "3412", "4123"
 * 给定两个字符串a和b, 请判断a和b是否互为旋转词
 * 例如:
 * a = "cdab", b = "abcd"    返回:true
 * a = "1ab2", b = "ab12"    返回:false
 * a = "2ab1", b = "ab12"    返回:true
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Puzzle3 {

    /**
     * 最优解的时间复杂度为O(N)
     * 1. 判断str1与str2长度是否相等
     * 2. 如果长度相等, 生成str1+str1的大字符串
     * 3. 使用KMP算法判断大字符串中是否含有str2
     * @param a a
     * @param b b
     * @return answer
     */
    private static boolean solution(String a, String b){
        if (a == null && b == null) return true;
        if (a != null && b != null){
            if (a.length() == b.length()){
                return KMP.hasSub(b, a + a);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(solution("cdab", "abcd"));
        System.out.println(solution("1ab2", "ab12"));
        System.out.println(solution("2ab1", "ab12"));
    }
}
