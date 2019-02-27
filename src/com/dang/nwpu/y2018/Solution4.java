package com.dang.nwpu.y2018;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 打开一个英文文本文件, 假设文本文件单词之间全部都用"Space"分开,
 * 文本各段之间用“Enter”分开, 请统计输出文本的段数量, 总单词量,
 * 以及文本段的最长, 最短, 和平均单词数量
 * @author dht925nerd@126.com
 * @date 2019/02/26
 */
public class Solution4 {

    private static void parseText(String filePath){
        if (filePath == null || filePath.length() == 0) return;
        int segment = 0, sumWord = 0, curSegWord = 0, maxSegWord = 0, minSegWord = Integer.MAX_VALUE;
        try {
            InputStream fis = new FileInputStream(filePath);
            int size = fis.available();
            for (int i = 0; i < size; i++){
                switch ((char)fis.read()){
                    case ' ':
                        sumWord++;
                        curSegWord++;
                        break;
                    case '\n':
                        sumWord++;
                        curSegWord++;
                        segment++;
                        if (maxSegWord < curSegWord) maxSegWord = curSegWord;
                        if (minSegWord > curSegWord) minSegWord = curSegWord;
                        curSegWord = 0;
                        break;
                    default:break;
                }
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("总段落数:" + segment);
        System.out.println("总单词数:" + sumWord);
        System.out.println("最大单段单词数:" + maxSegWord);
        System.out.println("最小单段单词数:" + minSegWord);
    }

    public static void main(String[] args) {
        String filePath = "C:\\Program Files\\JetBrains\\JavaProjects\\Algorithm\\src\\com\\dang\\nwpu\\y2018\\Solution4_text.txt";
        parseText(filePath);
    }
}
