package chapter5.section1;

public class Alphabet {

    private static  String s = null;
    public Alphabet(String s){
        this.s = s;
    }

    /**
     * 获取字母表中索引位置
     * @param index
     * @return
     */
    public char toChar(int index){
        return s.charAt(index);
    }


    /**
     * 获取 c的索引，在0到R-1之间
     * @param c
     * @return
     */
    public int toIndex(char c){
        return s.indexOf(c);
    }

    public boolean contains(char c){
        return toIndex(c)>=0;
    }


    /**
     * 表示一个索引所需的比特数
     * @return
     */
    public int R(){
        return s.length()-1;
    }

    /**
     * 将s转换为R进制的整数
     * @return
     */
    public int lgR(){
        return R();
    }

    /**
     * 将字符串转换为字母表中的索引
     * @param s
     * @return
     */
    public int[] toIndices(String s)
    {
        int[] index = new int[s.length()];
        for (int i = 0; i < index.length; i++) {
            index[i] = toIndex(s.charAt(i));
        }
        return index;
    }

    /**
     * 将R进制的整数转换为基于该字母表的字符串
     * @param indices
     * @return
     */
    public String toChars(int[] indices){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indices.length; i++) {
            sb.append(toChar(indices[i]));
        }

        return sb.toString();
    }
}

