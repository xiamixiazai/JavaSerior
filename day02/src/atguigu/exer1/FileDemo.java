package atguigu.exer1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author xjm
 * @create 2022/6/20-22:30
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\hello.txt");
        //创建一个与file同目录下的另外一个文件
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("创建成功");
        }
    }
}
