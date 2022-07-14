package atguigu.exer1;

import java.io.File;

/**
 * @author xjm
 * @create 2022/6/20-22:48
 */
public class ListFileTest {
    public static void main(String[] args){
        //递归
        //打印出指定目录所有文件的名称

        //1，创建目录对象
        File dir = new File("E:\\BaiduNetdiskDownload");
        //2.打印目录的子文件
        printSubFile(dir);
    }

    public static void printSubFile(File dir){
        File[] subfiles = dir.listFiles();

        for (File f : subfiles){
            if(f.isDirectory()){
                printSubFile(f);
            }else {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
