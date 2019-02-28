package com.dang.nwpu.y2017;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 读入一个文本文件, 并指定某个单词(单词长度不多于5个字符),
 * 例如"we", 统计并输出文件中包含指定单词的数量(注意不区分大小写)
 * @author dht925nerd@126.com
 * @date 2019/02/28
 */
public class Solution6 {

    private static int countWord(String filePath, String word){
        if (filePath == null || word == null) return 0;
        int count = 0;
        char temp;
        StringBuilder builder = new StringBuilder();
        try {
            InputStream fis = new FileInputStream(filePath);
            int size = fis.available();
            for (int i = 0; i < size; i++){
                temp = (char) fis.read();
                if (isAlphabet(temp)){
                    builder.append(temp);
                } else {
                    if (word.equals(builder.toString())) count++;
                    builder = new StringBuilder();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    private static boolean isAlphabet(char c) {
        return 'a' <= c && 'z' >= c || 'A' <= c && 'Z' >= c;
    }

    public static void main(String[] args) {
        String filePath = "C:\\Program Files\\JetBrains\\JavaProjects\\Algorithm\\src\\com\\dang\\nwpu\\y2017\\Solution6_text.txt";
        String word = "AAA";
        System.out.println(countWord(filePath, word));
    }

}
