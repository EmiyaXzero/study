package com.my;

/**
 * @author shang
 * @title: GetMaxRepetitions
 * @projectName study
 * @description: 统计重复个数
 * @date 2020/4/19-14:10
 */
public class GetMaxRepetitions {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if(s1.length()*n1 < s2.length()*n2){
            return 0;
        }
        if(s1.length()*n1 == s2.length()*n2){
            if(s1.equals(s2)){
                return 1;
            }else if(s1.length() == s2.length()) {
                return 0;
            }else {
                char a = s1.charAt(0);
                String tempS1 = s1;
                String tempS2 = s2;
                for (int i = 0; i < tempS1.length(); i++) {
                    if(tempS1.charAt(i) !=a){
                        return 0;
                    }
                }
                for (int i = 0; i < tempS2.length(); i++) {
                    if(tempS2.charAt(i) !=a){
                        return 0;
                    }
                }
            }
        }
        //s1*n1大于s2*n2
        //首先考虑s1 aaa s2 aa这种情况
        char a = s1.charAt(0);
        boolean isSingle = true;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) !=a){
                isSingle = false;
                break;
            }
        }
        if(isSingle){
            for (int i = 0; i < s2.length(); i++) {
                if(s2.charAt(i) !=a){
                    isSingle = false;
                    break;
                }
            }
        }
        int resutType1 = (n1 * s1.length()) / (n2 * s2.length());
        if(isSingle){
            return resutType1;
        }else{
            if(s1.length()>s2.length()){
                //s1能到s2
                if(s1.contains(s2)){
                    String[] ss1 = s1.split(s2);
                    if(ss1.length*s2.length() == s1.length()){
                        return resutType1;
                    }else{
                        return n1/n2;
                    }
                }else{
                    //看看存不存在s1 2 s2
                    boolean flag = false;
                    for (int i = 0 ,tempJ = 0;i<s2.length();i++){
                        for (;tempJ<s1.length();tempJ++){
                            if(s1.charAt(tempJ) == s2.charAt(i)){
                                flag = true;
                                break;
                            }
                            flag = false;
                        }
                    }
                    if(!flag){
                        //表示s1不能到s2
                        return 0;
                    }else {
                        return n1/n2;
                    }
                }
            }else {
                //s2比s1打只能存在s1 ab  s2 abab这种
                if(s2.contains(s1)){
                    String[] ss1 = s2.split(s1);
                    if(ss1.length*s1.length() == s2.length()){
                        return resutType1;
                    }else{
                        return 0;
                    }
                }else {
                    return 0;
                }
            }
        }
    }

    /**
     * 暴力法
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int getMaxRepetitions2(String s1, int n1, String s2, int n2) {
        int n = s1.length();
        int m = s2.length();
        //count总数，p表示当前在s2的位置
        int count = 0 ,p = 0;
        for (int i = 0 ;i<n1;i++){
            for (int j = 0 ; j<n;j++){
                if(s1.charAt(j) == s2.charAt(p)){
                    p++;
                    if(p==m){
                        //达到一次s2就count++ p位置归零
                        count++;
                        p=0;
                    }
                }
            }
        }
        //因为S2是由n2个s2组成，所以最后的结果需要/n2
        return count/n2;
    }

    /**
     * 循环节
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public int getMaxRepetitions3(String s1, int n1, String s2, int n2) {
        int n = s1.length();
        int m = s2.length();
        if(n==0 || m==0 || n*n1 < m*n2){
            return 0;
        }
        char[] ss1 = s1.toCharArray();
        char[] ss2 = s2.toCharArray();
        // 记录在遍历每个s1时匹配出的s2的个数，可能是包含了前面一个s1循环节的部分
        int[] countRecorder = new int[n1 + 1];
        // 记录在每个s1中想要匹配的s2中字符的索引
        int[] indexRecorder = new int[n1 + 1];
        //count总数，p表示当前在s2的位置
        int count = 0 ,p = 0;
        for (int i = 0;i<n1;i++){
            for (int j = 0 ; j<n;j++){
                if(ss1[j] == ss2[p]){
                    p++;
                    if(p==m){
                        //达到一次s2就count++ p位置归零
                        count++;
                        p=0;
                    }
                }
            }
            //遍历完一次s1之后,记录i次时候遍历完s2的次数，以及对应s2的index p
            countRecorder[i] = count;
            indexRecorder[i] = p;

            //判断是否出现循环节,因为出现循环节的时候记录的s2的index是一致的
            for (int j = 0; j < i && indexRecorder[j] == p; j++) {
                //出现循环节之前的记录的s2的个数
                int preCount = countRecorder[j];
                //(i-j)*n 表示循环节在s1中的长度，剩余的长度为(n1)*n - (j+1)*n 注因为j是从0开始因此需要j+1才能表示当前遍历过s1的长度
                //获取循环节个数
                int aroundSize = (n1-j-1)/(i-j);
                //获取一个循环节中s2出现的个数
                int singleCount = countRecorder[i]-countRecorder[j];
                int aroundAllSize = singleCount*aroundSize;
                //最后一部分不在循环节中的出现的次数即在出现循环节j偏移(n1-j-1)%(i-j)位之后-j当前值的结果
                int lastSize = countRecorder[j+(n1-j-1)%(i-j)]-countRecorder[j];
                //因为只是记录s1中有s2的循环节，需要考虑n2的感受
                return (preCount+aroundAllSize+lastSize)/n2;
            }
        }
        //不存在循环节直接暴力求解
        return count/n2;
    }

    public static void main(String[] args) {
        GetMaxRepetitions getMaxRepetitions =new  GetMaxRepetitions();
        getMaxRepetitions.getMaxRepetitions("aaa",3,"aa",1);
    }
}
