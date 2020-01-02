package com.my;

/**
 * 两数相除
 * 其数值范围是 [−2^31,  2^31 − 1]
 * @author shanghang
 */
public class Divide {
    /**
     * 执行用时 :
     * 1474 ms
     * , 在所有 java 提交中击败了
     * 5.01%
     * 的用户
     * 内存消耗 :
     * 33.6 MB
     * , 在所有 java 提交中击败了
     * 76.86%
     * 的用户
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == divisor) {
            return 1;
        }
        if (dividend == -divisor) {
            return -1;
        }
        if (divisor == 1) {
            if (dividend > Integer.MAX_VALUE - 1 || dividend < Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return dividend;
            }
        }
        if (divisor == -1) {
            //[−2^31,  2^31 − 1]
            if (dividend > Integer.MAX_VALUE || -dividend < Integer.MIN_VALUE + 1) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }
        int result = 0;
        if (dividend > 0) {
            if (divisor > 0) {
                while (dividend - divisor >= 0) {
                    dividend -= divisor;
                    result++;
                }
            } else {
                while (dividend + divisor >= 0) {
                    dividend += divisor;
                    result--;
                }
            }
        } else {
            if (divisor > 0) {
                while (dividend + divisor <= 0) {
                    dividend += divisor;
                    result--;
                }
            } else {
                while (dividend - divisor <= 0) {
                    dividend -= divisor;
                    result++;
                }
            }
        }

        if (result > Integer.MAX_VALUE - 1 || result < Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(divide2(-2147483648,
                1));
        System.out.println(System.currentTimeMillis() - start);
    }

    /**
     * 二分法 其数值范围是 [−2^31,  2^31 − 1],都弄成负数好处理
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide2(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        //位运算判断是否是负数,一正一负为true
        boolean negative = (dividend^divisor)<0;
        int dividendTemp = 0-Math.abs(dividend);
        int divisorTemp = 0-Math.abs(divisor);
        int count = -1 ,result = 0;
        while (dividendTemp <= divisorTemp){
            dividendTemp -= divisorTemp;
            result += count;
            if(Math.abs(dividendTemp) < Math.abs(divisor) || dividendTemp == 0){
                break;
            }

            if(Math.abs(dividendTemp)-Math.abs(divisorTemp) < Math.abs(divisorTemp)){
                //当dividendTemp当前值都比divisorTemp大的时候，divisorTemp要恢复到最小的时候
                divisorTemp =0-Math.abs(divisor);
                count=-1;
                continue;
            }
            //divisorTemp 翻倍
            divisorTemp +=divisorTemp;
            count += count;
        }
        if(!negative) {
            if (result <= Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
            result = 0-result;
        }
        return result;
    }
}
