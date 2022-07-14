package atguigu.exer;

import org.junit.Test;

/**
 * @author xjm
 * @create 2022/6/15-22:14
 */
public class StringDemo {
    //字符串反转
    public String reverse(String str,int startIndex,int endIndex){

        //方式一，转化为char[]
        if (str!=null && str.length()!=0) {
            char[] arr = str.toCharArray();
            for (int x = startIndex, y = endIndex; x < y; x++, y--) {
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //使用string的拼接操作
    public String reverse1(String str,int startIndex,int endIndex){

        if(str != null){
            String reverserStr = str.substring(0,startIndex);

            for (int i = endIndex; i >=startIndex; i--) {
                reverserStr += str.charAt(i);

            }
            reverserStr +=str.substring(endIndex+1);

            return reverserStr;
        }

        return null;
    }

    //方式3 使用stringbuilder替换string
    public String reverse2(String str,int startIndex,int endIndex){
       if(str != null){
           StringBuilder builder = new StringBuilder(str.length());

           builder.append(str.substring(0,startIndex));

           for (int i = endIndex; i >=startIndex; i--) {
               builder.append(str.charAt(i));

           }

           builder.append(str.substring(endIndex+1));

           return builder.toString();
       }

       return null;
    }

    @Test
    public void testReverse(){

        String str ="abcdef";
        String reverse = reverse2(str, 2, 5);
        System.out.println(reverse);
    }
}
