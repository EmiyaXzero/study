package com.my;

/**
 * IP 地址无效化
 * @author shang
 */
public class DefangIPaddr {
    /**
     * 好像不够快
     * @param address
     * @return
     */
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    /**
     * for循环比replace快
     * @param address
     * @return
     */
    public String defangIPaddr2(String address) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0 ;i<address.length();i++){
            if(address.charAt(i) == '.'){
                sb.append("[.]");
            }else {
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}
