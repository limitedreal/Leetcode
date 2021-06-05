package main.jd.exam1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stringBuilder = new StringBuilder(sc.nextLine());
        for (int i = 0; i < stringBuilder.length(); i++) {
            char now = stringBuilder.charAt(i);
            if (now >= '0' && now <= '9') {
                //如果是数字
                continue;
            } else {//如果是字母
                if (i + 1 == stringBuilder.length()) {//如果这是最后一个字母
                    stringBuilder.insert(i+1, 1);
                } else if (!(stringBuilder.charAt(i+1)>='0'&&stringBuilder.charAt(i+1)<='9')){
                    //如果后面不是数字
                    stringBuilder.insert(i+1,1);
                }
            }
        }
        int count = 0;
        String str = stringBuilder.toString();
        int length = 0;
        for (int i =0;i< str.length();i+=length){
            //下面要找到这个字母后面的数字到底多长
            int j = i+1;
            while (j<str.length()){
                char now = str.charAt(j);
                if(now >= '0' && now <= '9'){
                    j++;
                }else{
                    break;
                }
            }
            length = j-i;
            String substring = str.substring(i+1, j);
            switch (str.charAt(i)){
                case 'C':{
                    count+=12*Integer.parseInt(substring);
                    break;
                }
                case 'H':{
                    count+=1*Integer.parseInt(substring);
                    break;
                }
                case 'O':{
                    count+=16*Integer.parseInt(substring);
                    break;
                }
                case 'N':{
                    count+=14*Integer.parseInt(substring);
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
