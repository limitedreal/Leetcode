package main.TME.exam2;


public class Main {
    public String maxLexicographical (String num) {
        //其实只要把第一段连续0全部取反即可
        char[] chars = num.toCharArray();
        int start=0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='0'){
                start=i;
                break;
            }
        }
        int end=0;
        for (int i = start; i < chars.length; i++) {
            if(chars[i]!='0'){
                end=i;
                break;
            }
            chars[i]='1';
        }
        return new String(chars);
    }
}
