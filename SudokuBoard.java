import java.util.ArrayList;

/**
 * Encodes a completely or partially filled out Sudoku board
 *
 * @author <a href="mailto:knapp@american.edu">Adam Knapp</a>
 * @version 1.0
 */
public class SudokuBoard {

    /**
     * Reads a Sudoku board from StdIn
     *
     * @return a <code>SudokuBoard</code>
     */
    public static SudokuBoard getFromStdIn() {
        // TODO: complete this
        return null;
    }

    /**
     * @return a list of digits at row <code>row</code> and column
     * <code>col</code> which do not violate any of the board's known
     * constraints. If the entry has been set to a definite value, the
     * returned list will be empty. 
     */
    public ArrayList<Integer> getPossibilitiesAt(int row, int col) {
        // TODO: complete this
        return null;
    }

    /**
     * Describe <code>getBoardWithValue</code> method here.
     *
     * @param row row of entry
     * @param col column of entry
     * @param val value to set
     * @return a new <code>SudokuBoard</code> which has the digit
     * <code>val</code> in row <code>row</code> and column <code>col</code>
     * @throws IllegalArgumentException if <code>row</code> or <code>col</code>
     *                                  are not valid rows or columns or if
     *                                  <code>val</code> is not an allowed value
     *                                  in row <code>row</code> and column
     *                                  <code>col</code>
     */
    public SudokuBoard getBoardWithValue(int row, int col, int val) {
        // TODO: complete this
        return null;
    }

    /**
     * @return <code>true</code> if this board is a completely filled out, valid
     * solution, <code>false</code> otherwise
     */
    public boolean isSolution() {
        // TODO: complete this
        return false;
    }

    /**
     * @return <code>true</code> if there is at least one entry for which there
     * is no possible allowed digit, <code>false</code> otherwise
     */
    public boolean isKnownIncoherent() {
        // TODO: complete this
        return false;
    }

}
