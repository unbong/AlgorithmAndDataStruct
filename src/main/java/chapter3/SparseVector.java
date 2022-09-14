package chapter3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;

public class SparseVector {
    private int d; // dimension
    private ST<Integer, Double> st;

    public SparseVector(int d){
        this.d = d;
        this.st = new ST<>();
    }

    public void put(int i, double value)
    {
        if(i<0 || i >=d) throw new IllegalArgumentException("i is invalid.");

        if(value == 0.0) st.delete(i);
        else st.put(i, value);
    }


    public double get(int i){
        if(i<0 || i >=d) throw new IllegalArgumentException("i is invalid.");

        if(st.contains(i)) return st.get(i);
        else               return 0.0;

    }

    public int nnz() {
        return st.size();
    }

    public int dimension(){
        return d;
    }

    public double dot(SparseVector that){
        if(this.d != that.d) throw new IllegalArgumentException("vector length disagree.");
        double sum = 0.0;

        if(this.st.size() < that.st.size()){
            for(int i: this.st.keys()){
                if(that.st.contains(i)) sum += this.get(i) * that.get(i);
            }
        }
        else{
            for(int i: that.st.keys()){
                if(this.st.contains(i)) sum += this.get(i) * that.get(i);
            }
        }
        return sum;
    }

    public double dot(double[] that){
        double sum = 0.0;
        for(int i: this.st.keys())
        {
            sum+= that[i] * this.get(i);
        }
        return sum;
    }

    /**
     * Returns the magnitude of this vector.
     * This is also known as the L2 norm or the Euclidean norm.
     *
     * @return the magnitude of this vector
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    }


    /**
     * Returns the Euclidean norm of this vector.
     *
     * @return the Euclidean norm of this vector
     * @deprecated Replaced by {@link #magnitude()}.
     */
    @Deprecated
    public double norm() {
        return Math.sqrt(this.dot(this));
    }

    /**
     * Returns the scalar-vector product of this vector with the specified scalar.
     *
     * @param  alpha the scalar
     * @return the scalar-vector product of this vector with the specified scalar
     */
    public SparseVector scale(double alpha) {
        SparseVector c = new SparseVector(d);
        for (int i : this.st.keys()) c.put(i, alpha * this.get(i));
        return c;
    }

    /**
     * Returns the sum of this vector and the specified vector.
     *
     * @param  that the vector to add to this vector
     * @return the sum of this vector and that vector
     * @throws IllegalArgumentException if the dimensions of the two vectors are not equal
     */
    public SparseVector plus(SparseVector that) {
        if (this.d != that.d) throw new IllegalArgumentException("Vector lengths disagree");
        SparseVector c = new SparseVector(d);
        for (int i : this.st.keys()) c.put(i, this.get(i));                // c = this
        for (int i : that.st.keys()) c.put(i, that.get(i) + c.get(i));     // c = c + that
        return c;
    }

    /**
     * Returns a string representation of this vector.
     * @return a string representation of this vector, which consists of the
     *         the vector entries, separates by commas, enclosed in parentheses
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i : st.keys()) {
            s.append("(" + i + ", " + st.get(i) + ") ");
        }
        return s.toString();
    }

//    public SparseVector sum(SparseVector that){
//        SparseVector sum = new SparseVector(this.d);
//
//        for(int i: this.st.keys())
//        {
//            double ts = st.get(i) + that.get(i);
//
//        }
//    }

}
