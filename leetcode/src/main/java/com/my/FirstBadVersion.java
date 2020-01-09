package com.my;

/**
 * @author shang
 * @title: FirstBadVersion
 * @projectName study
 * @description: TODO
 * @date 2020/1/9-16:02
 */
public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int left =1 ,right = n ;
        while (left<right){
            int mid = left+(right-left)/2;
            if(isBadVersion(mid)&&!isBadVersion(mid-1)){
                return mid;
            }else if(isBadVersion(mid)){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version){
        return version>3?true:false;
    }
}
