package chapter5.section5;

import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

/**
 * 游程压缩
 */
public class RunLength {


    public static void expand(){
        boolean b = false;


        while(!BinaryStdIn.isEmpty() )
        {
            char count = BinaryStdIn.readChar(); // 读取8位数据
            for (int i = 0; i < count; i++) {
                BinaryStdOut.write(b);
            }
            b = !b;
        }
        BinaryStdOut.close();
    }

    public static void compress(){
        char count  = 0;
        boolean b , old = false;
        while( !BinaryStdIn.isEmpty())
        {
            b = BinaryStdIn.readBoolean();
            if(b == old){
                if(count == 255){
                    BinaryStdOut.write(count);
                    count = 0;
                    BinaryStdOut.write(count);
                }
            }else{
                BinaryStdOut.write(count);
                count = 0;
                old = !old;
            }
            count++;
        }

        BinaryStdOut.write(count);
        BinaryStdOut.close();

    }

    public static void main(String[] args) {
        if (args[0].equals("-")) {
            compress();
        } else if (args[0].equals("+")) {
            expand();
        }
    }

}
