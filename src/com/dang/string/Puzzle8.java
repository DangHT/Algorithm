package com.dang.string;

/**
 * 给定一个字符串str, 判断是不是整体有效的括号字符串
 * 例如:
 * str = "()", 返回true  str = "(()())", 返回true
 * str = "(())", 返回true
 * str = "())", 返回false, str = "()(", 返回false
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Puzzle8 {

    /**
     * 1. 整型变量num, 代表 '(' 出现次数与 ')' 出现次数的差值
     * 2. 遍历过程中如果遇到 '(' 则num++
     * 3. 遍历过程中如果遇到 ')' 则num--
     * 4. 如果遇到num < 0, 则直接返回false
     * 5. 如果一直没有出现情况4, 则一直遍历下去
     * 6. 遍历完成后, 如果num==0, 则返回true, 否则返回false
     * @param str str
     * @return answer
     */
    private static boolean solution(String str){
        if (str == null) return true;
        int num = 0;
        char[] chars = str.toCharArray();
        for (char c : chars){
            if (c == '(') num++;
            if (c == ')') num--;
            if (num < 0) return false;
        }
        return num == 0;
    }

    public static void main(String[] args) {
        String str = "(()())";
        System.out.println(solution(str));
    }

}
