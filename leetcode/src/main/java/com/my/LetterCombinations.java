package com.my;

import java.util.ArrayList;
import java.util.List;

/**
 * 电话号码的字母组合
 * @author shanghang
 */
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits) || digits.length()<=0){
            return new ArrayList<>();
        }
        List<String> strings = new ArrayList<>();
        if(digits.length() == 1){
            String temp1 ,temp2,temp3,temp4;
            switch (digits.charAt(0)){
                case '2':
                     temp1 = "a" ;
                     temp2 = "b" ;
                     temp3 = "c" ;
                    addString(strings,temp1,temp2,temp3);
                    return strings;
                case '3':
                     temp1 = "d" ;
                     temp2 = "e" ;
                     temp3 = "f" ;
                    addString(strings,temp1,temp2,temp3);
                    return strings;
                case '4':
                     temp1 = "g" ;
                     temp2 = "h" ;
                     temp3 = "i" ;
                    addString(strings,temp1,temp2,temp3);
                    return strings;
                case '5':
                    temp1 ="j";
                    temp2 ="k";
                    temp3 = "l";
                    addString(strings,temp1,temp2,temp3);
                    return strings;
                case '6':
                    temp1 ="m";
                    temp2 ="n";
                    temp3 = "o";
                    addString(strings,temp1,temp2,temp3);
                    return strings;
                case '7':
                    temp1 ="p";
                    temp2 ="q";
                    temp3 = "r";
                    temp4 = "s";
                    addString(strings,temp1,temp2,temp3,temp4);
                    return strings;
                case '8':
                    temp1 ="t";
                    temp2 ="u";
                    temp3 = "v";
                    addString(strings,temp1,temp2,temp3);
                    return strings;
                case '9':
                    temp1 ="w";
                    temp2 ="x";
                    temp3 = "y";
                    temp4 = "z";
                    addString(strings,temp1,temp2,temp3,temp4);
                    return strings;
                default:
                    return new ArrayList<>();
            }
        }else{
            String temp1 ,temp2,temp3,temp4;
            switch (digits.charAt(0)){
                case '2':
                    temp1 = "a" ;
                    temp2 = "b" ;
                    temp3 = "c" ;
                    getAllString(strings,letterCombinations(digits.substring(1)),temp1,temp2,temp3);
                    break;
                case '3':
                    temp1 = "d" ;
                    temp2 = "e" ;
                    temp3 = "f" ;
                    getAllString(strings,letterCombinations(digits.substring(1)),temp1,temp2,temp3);
                    break;
                case '4':
                    temp1 = "g" ;
                    temp2 = "h" ;
                    temp3 = "i" ;
                    getAllString(strings,letterCombinations(digits.substring(1)),temp1,temp2,temp3);
                    break;
                case '5':
                    temp1 ="j";
                    temp2 ="k";
                    temp3 = "l";
                    getAllString(strings,letterCombinations(digits.substring(1)),temp1,temp2,temp3);
                    break;
                case '6':
                    temp1 ="m";
                    temp2 ="n";
                    temp3 = "o";
                    getAllString(strings,letterCombinations(digits.substring(1)),temp1,temp2,temp3);
                    break;
                case '7':
                    temp1 ="p";
                    temp2 ="q";
                    temp3 = "r";
                    temp4 = "s";
                    getAllString(strings,letterCombinations(digits.substring(1)),temp1,temp2,temp3,temp4);
                    break;
                case '8':
                    temp1 ="t";
                    temp2 ="u";
                    temp3 = "v";
                    getAllString(strings,letterCombinations(digits.substring(1)),temp1,temp2,temp3);
                    break;
                case '9':
                    temp1 ="w";
                    temp2 ="x";
                    temp3 = "y";
                    temp4 = "z";
                    getAllString(strings,letterCombinations(digits.substring(1)),temp1,temp2,temp3,temp4);
                    break;
                default:
                    return null;
            }
        }
        return strings;
    }

    public void getAllString(List<String>strings,List<String> endString, String ... args){
        for (String tempStr : args){
            for (String tempStr1 : endString){
                strings.add(tempStr+tempStr1);
            }
        }
    }

    public void addString(List<String> strings,String ... args){
        for (String tempStr : args){
            strings.add(tempStr);
        }
    }

}
