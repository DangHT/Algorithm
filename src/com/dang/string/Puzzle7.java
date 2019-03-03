package com.dang.string;

/**
 * 给定一个字符串str, 将其中所有空格字符替换成"%20", 假设str后面有足够的空间
 * @author dht925nerd@126.com
 * @date 2019/03/03
 */
public class Puzzle7 {

    private static String solution(String str){
        if (str == null) return null;
        char[] strChars = str.toCharArray();
        int i = 0, j = 0, count = 0;
        for (char c : strChars){
            if (c == ' '){
                count += 3;
            } else {
                count++;
            }
        }
        char[] resultChars = new char[count];
        while (i < strChars.length){
            if (strChars[i] == ' '){
                resultChars[j++] = '%';
                resultChars[j++] = '2';
                resultChars[j++] = '0';
            } else {
                resultChars[j++] = strChars[i];
            }
            i++;
        }
        return String.valueOf(resultChars);
    }

    public static void main(String[] args) {
        String str = "A B  C   D    E";
        System.out.println(solution(str));
    }

}
