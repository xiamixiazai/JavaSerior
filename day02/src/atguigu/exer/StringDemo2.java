package atguigu.exer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 获取两个字符串中的最大相同字符串
 * @author xjm
 * @create 2022/6/16-22:51
 */
public class StringDemo2 {
    //如果存在多个长度相同的最大相同字符串，则结果应返回String[]
    public String[] getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            StringBuffer sBuffer = new StringBuffer();
            String maxStr = (str1.length() >= str2.length())?str1 : str2;
            String minStr = (str1.length() < str2.length())?str1 : str2;
            int length = minStr.length();
            for(int i=0;i<length;i++){
                for(int x=0,y=length-i;y<=length;x++,y++){
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        sBuffer.append(subStr + ",");
                    }
                }

                if(sBuffer.length() != 0){
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$","").split(",");
            return split;
        }

        return null;
    }

    @Test
    public void testGetMaxSameString(){
        String str1 = "addsejkljlkjoijlkmce";
        String str2 = "jkijlkjoijaddsejk";
        String[] maxSameStrings = getMaxSameString(str1, str2);
        System.out.println(Arrays.toString(maxSameStrings));
    }
}
