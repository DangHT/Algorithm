package com.dang.leetcode.array;

import java.util.Arrays;

/**
 * 供暖器(https://leetcode-cn.com/problems/heaters/)
 * @author dht
 * @date 08/09/2019
 */
public class Q_475 {

    public static void main(String[] args) {
        int[] houses = {282475249,622650073,984943658,144108930,470211272,101027544,457850878,458777923};
        int[] heaters = {823564440,115438165,784484492,74243042,114807987,137522503,441282327,16531729,823378840,143542612};
        System.out.println(findRadius(houses, heaters));
    }

    public static int findRadius(int[] houses, int[] heaters) {
        if (houses == null || heaters == null) return 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int maxDistance = 0;
        for (int house : houses) {
            int i = 0;
            while (i < heaters.length && heaters[i] < house) i++;
            if (i == 0) {
                maxDistance = Math.max(maxDistance, heaters[0] - house);
            } else if (i == heaters.length) {
                maxDistance = Math.max(maxDistance, house - heaters[heaters.length - 1]);
            } else {
                int min = Math.min(house - heaters[i - 1], heaters[i] - house);
                maxDistance = Math.max(maxDistance, min);
            }
        }
        return maxDistance;
    }



}
