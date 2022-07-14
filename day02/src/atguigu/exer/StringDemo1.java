package atguigu.exer;

import org.junit.Test;

/**
 * @author xjm
 * @create 2022/6/16-22:21
 */
public class StringDemo1 {
    //获取一个字符串在另一个字符串出现的次数

    /**
     * 获取subStr在mainStr中出现次数
     * @param mainStr
     * @param subStr
     * @return
     */
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength){
            //方式1
//            while ((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }

            //方式2
            while ((index = mainStr.indexOf(subStr,index)) !=-1){
                count++;
                index +=subLength;
            }


            return count;
        }else {
            return 0;
        }
    }

    @Test
    public void testGetCount(){
        String mainStr = "abdedesaaedabdeesab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }
}
