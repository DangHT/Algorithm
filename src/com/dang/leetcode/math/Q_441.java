package com.dang.leetcode.math;

/**
 * 排列硬币(https://leetcode-cn.com/problems/arranging-coins/)
 * @author dht
 * @date 29/08/2019
 */
public class Q_441 {

    public static void main(String[] args) {
        System.out.println(arrangeCoins_01(5));
    }

    public static int arrangeCoins_01(int n) {
        int i = 1;
        while (n - i >= 0) {
            n -= i;
            i++;
        }
        return i - 1;
    }

    /**
     * 根据规律易得：前 i 行完整的硬币数量为 (i+1)*i/2 ，前i+1行则为 (i+2)*(i+1)/2 。
     * 从而可得： (i+1)*i/2 ≤ n < (i+2)*(i+1)/2
     * 计算可得i的范围为：sqrt(2n + 0.25)-1.5 < n ≤ sqrt(2n + 0.25) - 0.5
     * 由此可见，i范围的上下限的差距小于1，且Java语言采用退一法，从而输出i范围的上限（整型）即可
     *
     * （PS：n为int类型，2n可能超过int的范围，因此需要先将其转化为double类型进行处理）
     *
     * 作者：zuo-zhou-ren
     * 链接：https://leetcode-cn.com/problems/arranging-coins/solution/pai-lie-ying-bi-shu-xue-qiu-jie-by-zuo-zhou-ren/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static int arrangConins_02(int n) {
        return (int)(Math.sqrt(2 * (double)n + 0.25) - 0.5);
    }

}
