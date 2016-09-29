import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * An interface for matrices.
 *
 * @author <a href="mailto:knapp@american.edu">Adam Knapp</a>
 * @version 1.0
 */
public class Matrix {

    private final int rows, cols;
    private final double[][] m;

    /**
     * Constructs a new Matrix object from <code>a</code>. <code>a</code> is copied, so
     * that further changes to this array will not affect the matrix
     *
     * @param a the underlying array for the matrix
     */
    public Matrix(double[][] a) {
        rows = a.length;
        cols = a[0].length;
        m = new double[rows][cols];
        // using the array-copy built-in is faster for single index arrays
        for (int i = 0; i < rows; i++)
            System.arraycopy(a[i], 0, m[i], 0, cols);
    }

    /**
     * Constructs a new Matrix object, filled with zeros
     *
     * @param rows number of rows
     * @param cols number of columns
     */
    private Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        m = new double[rows][cols];
    }

    /**
     * reads in and constructs a new <code>Matrix</code> from an InputStream. The input should be formatted as
     * 2 ints giving # rows and # columns, then the (double) values of the matrix row by row. For example:<br>
     * <code>2 3</code><br>
     * <code>1.0 2.0 3.0</code><br>
     * <code>4.0 5.0 6.0</code><br>
     *
     * @param in an <code>InputStream</code> such as <code>System.in</code> from which to read the matrix
     * @return the <code>Matrix</code> read from the <code>InputStream</code>
     */
    public static Matrix readMatrix(InputStream in) {
        Scanner scanner = new Scanner(in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        Matrix mat = new Matrix(rows, cols);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                mat.setEntry(i, j, scanner.nextDouble());
            }
        }

        return mat;
    }

    /**
     * Unit tests
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        double[][] mAr = {{0.0, 1.0}, {1.0, 0.0}};
        Matrix m = new Matrix(mAr);

        System.out.println(m.mult(m));

        double[][] jAr = {{0.0, -1.0}, {1.0, 0.0}};
        Matrix j = new Matrix(jAr);

        System.out.println(j.mult(j));
    }

    /**
     * Accessor for matrix entries
     *
     * @param row row of desired entry
     * @param col column of desired entry
     * @return value in desired entry
     */
    public double getEntry(int row, int col) {
        return m[row][col];
    }

    /**
     * Setter for matrix entries
     *
     * @param row row of entry to set
     * @param col column of entry to set
     */
    public void setEntry(int row, int col, double value) {
        m[row][col] = value;
    }

    /**
     * @return number of rows in matrix
     */
    public int rows() {
        return rows;
    }

    /**
     * @return number of columns in matrix
     */
    public int cols() {
        return cols;
    }

    /**
     * perform matrix addition, if well-defined
     *
     * @param other another matrix
     * @return result of addition
     */
    public Matrix add(Matrix other) {
        if (other == null
                || this.rows() != other.rows()
                || this.cols() != other.cols())
            throw new IllegalArgumentException();

        // initialize an all-zero matrix
        Matrix result = new Matrix(this.rows(), this.cols());

        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.setEntry(i, j,
                        this.getEntry(i, j) + other.getEntry(i, j));

        return result;
    }

    /**
     * perform scalar multiplication
     *
     * @param scalar scalar value
     * @return <code>scalar*this</code>
     */
    public Matrix mult(double scalar) {
        Matrix result = new Matrix(this.rows(), this.cols());
        for (int i = 0; i < this.rows(); i++)
            for (int j = 0; j < this.cols(); j++)
                result.setEntry(i, j, scalar * this.getEntry(i, j));
        return result;
    }

    /**
     * perform matrix-matrix multiplication
     *
     * @param other another matrix
     * @return <code>this*other</code>
     */
    public Matrix mult(Matrix other) {
        if (other == null || this.cols() != other.rows())
            throw new IllegalArgumentException();

        Matrix result = new Matrix(this.rows(), other.cols());
        for (int i = 0; i < this.rows(); i++)
            for (int j = 0; j < other.cols(); j++)
                for (int k = 0; k < this.cols(); k++)
                    result.setEntry(i, j,
                            result.getEntry(i, j) +
                                    this.getEntry(i, k) * other.getEntry(k, j));

        return result;
    }

    /**
     * perform matrix-vector multiplication
     *
     * @param vec a vector
     * @return <code>this*vec</code>
     */
    public Vector mult(Vector vec) {
        if (vec == null || this.cols() != vec.dimension())
            throw new IllegalArgumentException();

        Vector result = new Vector(this.rows());
        for (int i = 0; i < this.rows(); i++) {
            for (int j = 0; j < this.cols(); j++) {
                result.setEntry(i,
                        result.getEntry(i) + this.getEntry(i, j) * vec.getEntry(j));
            }
        }
        return result;
    }

    /**
     * @return <code>String</code> representation of the <code>Matrix</code>
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(Arrays.toString(m[0]));
        sb.append(",\n");
        for (int i = 1; i < this.rows() - 1; i++) {
            sb.append(" ");
            sb.append(Arrays.toString(m[i]));
            sb.append(",\n");
        }
        sb.append(Arrays.toString(m[this.rows() - 1]));
        sb.append("]");
        return sb.toString();
    }

}
