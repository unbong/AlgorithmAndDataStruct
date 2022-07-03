package chapter1.section3.exersize;

import chapter1.section3.Queue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileList_1_3_43 {

    private String originPath = "";
    Queue<String> queue = new Queue<>();

    public void getChildPaths(String originPath)
    {
        this.originPath = originPath;
        File file = new File(originPath);
        getChildPaths(file, 0);

        for (String path: queue
             ) {
            System.out.println(path);
        }
    }

    public void getChildPaths(File file, int tabs)
    {
        File[] files = file.listFiles();
        for (File file1 : files) {
            String path= "";
            for (int i = 0; i < tabs; i++) {
                path = path+ "\t";
            }
            if(file1.isFile())
            {

                path = path + file1.getName();
                queue.enqueue( path);
            }

            if(file1.isDirectory())
            {

                queue.enqueue( path + file1.getName());
                getChildPaths(file1, tabs+1);
            }
        }
    }

    public static void main(String[] args) {

        FileList_1_3_43 ss = new FileList_1_3_43();
        ss.getChildPaths("D:\\personal\\junk\\s3-bucket-listing-gh-pages");

    }


}
