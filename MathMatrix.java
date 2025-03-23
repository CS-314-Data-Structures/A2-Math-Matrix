import java.util.Arrays;
//MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
*
*  On my honor, Jerry Ming, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  UTEID: jm98623
*  email address: jerryming2002@gmail.com
*  Unique section number: 52650
*  Number of slip days I am using: 1
*/

/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 */
public class MathMatrix {
    
    // instance variable
	private int[][] matrix;
	
    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
    	//check preconditions
    	if(mat == null || mat.length <= 0 || mat[0].length <= 0) {
    		throw new IllegalArgumentException("Violation of Constructor Precondition");
    	}
    	matrix = new int[mat.length][mat[0].length];
        for(int rowIndx = 0; rowIndx < mat.length; rowIndx++) {
        	for(int colIndx = 0; colIndx < mat[0].length; colIndx++) {
        		matrix[rowIndx][colIndx] = mat[rowIndx][colIndx];
        	}
        }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
    	if(numRows <= 0 || numCols <= 0) {
    		throw new IllegalArgumentException("Violation of Constructor Precondition");
    	}
        matrix = new int[numRows][numCols];
        for(int rowIndx = 0; rowIndx < numRows; rowIndx ++) {
        	for(int colIndx = 0; colIndx < numCols; colIndx ++) {
        		matrix[rowIndx][colIndx] = initialVal;
        	}
        }
    }

    
    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    //precondition: none
    //postcondition: return the number of rows in the matrix
    public int getNumRows() {
        return matrix.length;
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    //precondition: none
    //postcondition: return the number of columns
    public int getNumColumns(){
        return matrix[0].length;
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < getNumRows(), col  0 <= col < getNumColumns()
     * @param  row  0 <= row < getNumRows()
     * @param  col  0 <= col < getNumColumns()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
    	//check preconditions
    	if(row < 0 || row >= getNumRows() || col < 0 || col >= getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition: "+
    					"row must be greater than or equal to zero and less than or equal to the number of rows"+
    					"and col must be greater than or equal to zero and less than or equal to the number of columns.");
    	}
        return matrix[row][col];
    }


    /**
     * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
     * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
     */
    public MathMatrix add(MathMatrix rightHandSide){
    	//precondition: rightHandSide has the same dimensions as matrix
    	//post: rightHandSide is added to matrix
    	if(rightHandSide.getNumRows() != getNumRows() || rightHandSide.getNumColumns() != getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition: input matrix must have the same dimensions");
    	}
    	int[][] addResult = new int[getNumRows()][getNumColumns()];
        for(int rowIndx = 0; rowIndx < getNumRows(); rowIndx ++) {
        	for(int colIndx = 0; colIndx < getNumColumns(); colIndx ++) {
        		addResult[rowIndx][colIndx] = matrix[rowIndx][colIndx] + rightHandSide.getVal(rowIndx, colIndx);
        	}
        }
        MathMatrix addMatrix = new MathMatrix(addResult);
    	return addMatrix;
    }


    /**
     * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * <br>post: This method does not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumRows(), rightHandSide.numCols() = getNumColumns()
     * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
     */
    public MathMatrix subtract(MathMatrix rightHandSide){
    	//precondition: rightHandSide has the same dimensions as matrix
    	//post: rightHandSide is subtracted from matrix
    	if(rightHandSide.getNumRows() != getNumRows() || rightHandSide.getNumColumns() != getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition: input matrix must have the same dimensions");
    	}
    	for(int rowIndx = 0; rowIndx < getNumRows(); rowIndx ++) {
        	for(int colIndx = 0; colIndx < getNumColumns(); colIndx ++) {
        		matrix[rowIndx][colIndx] = matrix[rowIndx][colIndx] - rightHandSide.getVal(rowIndx, colIndx);
        	}
        }
    	return this;
    }


    /**
     * implements matrix multiplication, (this MathMatrix) * rightHandSide.
     * <br>pre: rightHandSide.getNumRows() = getNumColumns()
     * <br>post: This method should not alter the calling object or rightHandSide
     * @param rightHandSide rightHandSide.getNumRows() = getNumColumns()
     * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
     * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
     * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
     */
    public MathMatrix multiply(MathMatrix rightHandSide){
    	//precondition: this matrix must have the same number of rows as rightHandSide has columns
    	if(rightHandSide.getNumRows() != getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition");
    	}
    	int[][] multiplyArray= new int[getNumRows()][rightHandSide.getNumColumns()];
    	for(int rowIndx = 0; rowIndx < getNumRows(); rowIndx ++) {
        	for(int colIndx = 0; colIndx < rightHandSide.getNumColumns(); colIndx++) {
        		multiplyArray[rowIndx][colIndx] = MatrixMultiplication(rightHandSide, rowIndx, colIndx);
        	}
        }
    	MathMatrix multiplyResult = new MathMatrix(multiplyArray);
    	return multiplyResult;
    } 

    //method to return the value of multiplying a given row in matrix by a corresponding column in rightHandSide
    private int MatrixMultiplication(MathMatrix rightHandSide, int whichRow, int whichCol){
    	int multiplyResult = 0;
		for(int rowIndx = 0; rowIndx < matrix[whichRow].length; rowIndx++) {
			multiplyResult += matrix[whichRow][rowIndx] * rightHandSide.getVal(rowIndx, whichCol);
		}
		return multiplyResult;
    }

    /**
     * Create and return a new Matrix that is a copy
     * of this matrix, but with all values multiplied by a scale
     * value.
     * <br>pre: none
     * <br>post: returns a new Matrix with all elements in this matrix 
     * multiplied by factor. 
     * In other words after this method has been called 
     * returned_matrix.getVal(r,c) = original_matrix.getVal(r, c) * factor
     * for all valid r and c.
     * @param factor the value to multiply every cell in this Matrix by.
     * @return a MathMatrix that is a copy of this MathMatrix, but with all
     * values in the result multiplied by factor.
     */
    public MathMatrix getScaledMatrix(int factor) {
    	//precondition: none
    	//post: matrix is multiplied by a factor
    	int[][] scaledArray = new int[getNumRows()][getNumColumns()];
    	for(int rowIndx = 0; rowIndx < getNumRows(); rowIndx ++) {
        	for(int colIndx = 0; colIndx < getNumColumns(); colIndx ++) {
        		scaledArray[rowIndx][colIndx] = matrix[rowIndx][colIndx] * factor;
        	}
        }
    	MathMatrix scaledMatrix = new MathMatrix(scaledArray);
        return scaledMatrix;
    }


    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
    	//precondition: none
    	//post: return a matrix with the rows as columns and the columns as rows
    	int[][]	transposed = new int[getNumColumns()][getNumRows()];
        for(int rowIndx = 0; rowIndx < getNumRows(); rowIndx ++) {
        	for(int colIndx = 0; colIndx < getNumColumns(); colIndx ++) {
        		transposed[colIndx][rowIndx] = matrix[rowIndx][colIndx];
        	}
        }
        MathMatrix transposedMatrix = new MathMatrix(transposed);
    	return transposedMatrix;
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide){
        /* CS314 Students. The following is standard equals
         * method code. We will learn about in the coming weeks.
         */
        boolean result = false;
        // We use getClass instead of instanceof because we only want a MathMatrix to equal 
        // another MathMatrix as opposed to any possible sub classes. We would
        // use instance of if we were implementing am interface and wanted to equal
        // other objects that are insances of that interfacem but not necessarily
        // MathMatrix objects.
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix) rightHandSide;
          //check sizes
        	if(getNumRows()!= otherMatrix.getNumRows() || getNumColumns() != otherMatrix.getNumColumns()) {
        		return false;
        	}
            for(int rowIndx = 0; rowIndx < getNumRows(); rowIndx ++) {
            	for(int colIndx = 0; colIndx < getNumColumns(); colIndx ++) {
            		if (otherMatrix.getVal(rowIndx, colIndx) != matrix[rowIndx][colIndx]) {
            			return result;
            		}
            	}
            }
            result = true;
            // I recommend not changing any other code.
        }
        return result;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a separate line.
     * Spacing based on longest element in this Matrix.
     */
    //precondition: none
    //postcondition: returns the contents of the math matrix as a string literal 
    public String toString() {
    	StringBuilder finalString = new StringBuilder();
    	int[][] lengthMatrix = new int[getNumRows()][getNumColumns()];
    	int maxLength = 0;
    	for(int rowIndx = 0; rowIndx < getNumRows(); rowIndx ++) {
        	for(int colIndx = 0; colIndx < getNumColumns(); colIndx ++) {
        		lengthMatrix[rowIndx][colIndx] = getDigits(matrix[rowIndx][colIndx]);
        		if(maxLength < lengthMatrix[rowIndx][colIndx]) {
        			maxLength = lengthMatrix[rowIndx][colIndx];
        		}
        	}
    	}
    	for(int rowIndx = 0; rowIndx < getNumRows(); rowIndx ++) {
    		finalString.append("|");
        	for(int colIndx = 0; colIndx < getNumColumns(); colIndx ++) {
        		for(int i = 0; i < maxLength - lengthMatrix[rowIndx][colIndx] + 1; i++) {
        			finalString.append(" ");
        		}
        		finalString.append(matrix[rowIndx][colIndx]);
        	}
        	finalString.append("|\n");
        }
        return finalString.toString();
    }

    //method to find the number of digits in a given int value
    private int getDigits(int digit) {
    	int length = 0;
    	if(digit <= 0) {
    		length += 1;
    		digit *= -1;
    	}
    	while(digit != 0) {
    		digit /= 10;
    		length += 1;
    	}
    	return length;
    }

    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. getNumRows() == getNumColumns()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular(){
    	//precondition: matrix must be square
    	//post condition: returns a boolean if all ints below the main diagonal are 0. 
    	if(getNumRows() != getNumColumns()) {
    		throw new IllegalArgumentException("Violation of precondition");
    	}
    	for(int i = 1; i < matrix.length; i++) {
    		for(int j = 0; j < i; j++) {
    			if(matrix[i][j] != 0) {
    				return false;
    			}
    		}
    	}
        return true;
    }

    // method to ensure mat is rectangular. It is public so that
    // tester classes can use it. 
    // pre: mat != null, mat has at least one row
    // return true if all rows in mat have the same
    // number of columns false otherwise.
    public static boolean rectangularMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            throw new IllegalArgumentException("argument mat may not be null and must "
                    + " have at least one row. mat = " + Arrays.toString(mat));
        }
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;
        while (isRectangular && row < mat.length) {
            isRectangular = (mat[row].length == COLUMNS);
            row++;
        }
        return isRectangular;
    }

}