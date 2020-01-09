package com.my;

/**
 * @author shang
 * @title: GuessNumber
 * @projectName study
 * @description: TODO
 * @date 2020/1/9-14:02
 */
public class GuessNumber {
    public static int guessNumber(int n) {
        int left = 1 ,right = n;
        while (left < right){
            int mid = left+(right-left)/2;
            switch (guess(mid)){
                case 0 : return mid;
                case -1 : right = mid-1;
                        break;
                case 1 : left = mid+1;
                        break;
                default:break;
            }
        }
        return left;
    }

    static int guess(int num){
        int a  = 6;
        if(num == a){
            return 0;
        }else if(num>a){
            return -1;
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
