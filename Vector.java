import java.util.Arrays;

/**
 * A class to encapsulate a vector
 */
public class Vector {

    private final int dim;
    private final double[] v;

    /**
     * Constructs a new <code>Vector</code> object from <code>a</code>. <code>a</code> is copied, so
     * that further changes to this array will not affect the vector
     *
     * @param a the underlying array for the vector
     */
    public Vector(double[] a) {
        dim = a.length;
        v = new double[dim];
        System.arraycopy(a, 0, v, 0, a.length);
    }

    /**
     * Constructs a zero vector
     *
     * @param dim dimension
     */
    public Vector(int dim) {
        this.dim = dim;
        v = new double[dim];
    }

    /**
     * Unit tests
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        double[] vAr = {1.0, 1.0};
        Vector v = new Vector(vAr);

        double[] wAr = {-1.0, 1.0};
        Vector w = new Vector(wAr);

        System.out.println(v.add(w));
    }

    @Override
    public String toString() {
        return Arrays.toString(v);
    }

    /**
     * Accessor for vector entries
     *
     * @param index index to access
     * @return value of vector in index <code>index</code>
     */
    public double getEntry(int index) {
        return this.v[index];
    }

    /**
     * Setter for vector entries
     *
     * @param i   index to set
     * @param val value to set
     */
    public void setEntry(int i, double val) {
        this.v[i] = val;
    }

    /**
     * @return dimension of vector
     */
    public int dimension() {
        return dim;
    }

    /**
     * Vector addition
     *
     * @param other a <code>Vector</code> to add to this one
     * @return result of addition
     */
    public Vector add(Vector other) {
        if (this.dimension() != other.dimension())
            throw new IllegalArgumentException();

        Vector result = new Vector(dim);
        for (int i = 0; i < dim; i++)
            result.v[i] = this.v[i] + other.v[i];
        return result;
    }

    /**
     * scalar multiplication
     *
     * @param scalar scalar quentity
     * @return result of scalar multiplication
     */
    public Vector mult(double scalar) {
        Vector result = new Vector(dim);
        for (int i = 0; i < dim; i++)
            result.v[i] = scalar * this.v[i];
        return result;
    }

    /**
     * right multiplication by a matrix
     *
     * @param mat a <code>Matrix</code> with compatible dimension
     * @return result of <code>this*mat</code>
     */
    public Vector mult(Matrix mat) {
        if (mat == null
                || mat.rows() != this.dimension())
            throw new IllegalArgumentException();

        Vector result = new Vector(mat.cols());

        for (int i = 0; i < mat.cols(); i++) {
            double accumulator = 0;
            for (int j = 0; j < this.dimension(); j++) {
                accumulator += this.getEntry(j) * mat.getEntry(j, i);
            }
            result.setEntry(i, accumulator);
        }

        return result;
    }

    /**
     * @return length of <code>this</code>
     */
    public double len() {
        return Math.sqrt(this.lenSq());
    }

    /**
     * @return squared length of <code>this</code>
     */
    public double lenSq() {
        return this.dot(this);
    }

    /**
     * computes the dot product
     *
     * @param other another <code>Vector</code> of the same dimension
     * @return dot product of <code>this</code> and <code>other</code>
     */
    public double dot(Vector other) {
        if (this.dimension() != other.dimension())
            throw new IllegalArgumentException();

        double result = 0;
        for (int i = 0; i < this.dimension(); i++) {
            result += this.v[i] * other.v[i];
        }
        return result;
    }

}
