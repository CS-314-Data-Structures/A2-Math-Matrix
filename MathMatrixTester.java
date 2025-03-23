import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: jm98623
 *  email address: jerryming2002@gmail.com
 *  Grader name:
 *  Number of slip days I am using: 1
 */



/* CS314 Students. Put your experiment results and
 * answers to questions here.
 * experiment 1
 * //1000x1000 matrix: time to run 1000 tests was 2.2936284 seconds
   //2000x2000 matrix: time to run 1000 tests was 11.71065089 seconds
   //4000x4000 matrix: time to run 1000 tests was 38.0261449 seconds
 * experiment 2
 * //300x300 array: time to run 100 tests was 2.6629623 seconds
   //600x600 array: time to run 100 tests was 22.2955532 seconds
   //1200x1200 array: time to run 100 tests was 212.3329051 seconds
 * Question 1: I would expect the add method to take around 150 seconds if the dimensions were doubled again. 
 * Question 2: The add method is order O(N^2) because it contains a for loop within a for loop, both order O(N). This matches my timing results. 
 * Question 3: I would except the multiply method to take around 2000 seconds if the dimensions were doubled again. 
 * Question 4: The multiply method is order O(N^3), but the timing data is a bit off. This is within reason of the timing results. 
 * Question 5: The largest matrix I can create is 45586^2, or 2078083396 ints, or 8312333584 bytes, or 8312.333584 MB. 
 * I used around 25.97% of my RAM before crashing. 
 */

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
        int[][] data1 = { {1, 2, 3},
                {2, 3, 4}};
        int[][] data2 = { {2, 1, 1},
                {2, 3, 1}};
        int[][] e1;


            // and add your 22 tests here.
            MathMatrix testM1 = new MathMatrix(3, 2, -1);
            int[][] array1 = {{1, 2, 3}, {4, 5, 6},};
            MathMatrix testM2 = new MathMatrix(array1);
            MathMatrix testM3 = new MathMatrix(3, 2, 1);
            System.out.println("test 1: testM1 should have 3 rows. Actual: "+testM1.getNumRows());
            System.out.println("test 2: testM2 should have 2 rows. Actual: "+testM2.getNumRows());
            System.out.println("test 3: testM1 should have 2 columns. Actual: "+testM1.getNumColumns());
            System.out.println("test 4: testM2 should have 3 columns. Actual: "+testM2.getNumColumns());
            System.out.println("test 5: [0][0] of testM1 should have a value of -1. Actual: "+testM1.getVal(0, 0));
            System.out.println("test 6: [1][1] of testM2 should have a value of 5. Actual: "+testM2.getVal(0, 0));
            System.out.println("test 7: Adding testM1 to testM3 should result in \n| 0 0|\n| 0 0|\n| 0 0|  \nActual: \n"+ testM1.add(testM3));
            System.out.println("test 8: Subtracting testM1 from testM3 should result in \n| 2 2|\n| 2 2|\n| 2 2|  \nActual: \n"+ testM3.subtract(testM1));
            int[][] array2 = {{1, 2}, {3, 4}, {5, 6}};
            testM3 = new MathMatrix(array2);
            System.out.println("test 9: Adding testM1 to testM3 should result in \n| 0 1|\n| 2 3|\n| 4 5|  \nActual: \n"+ testM1.add(testM3));
            System.out.println("test 10: Subtracting testM1 from testM3 should result in \n| 2 3|\n| 4 5|\n| 6 7|  \nActual: \n"+ testM3.subtract(testM1));
            System.out.println("test 11: Multiplying testM1 to testM2 should result in \n| -5 -7 -9|\n| -5 -7 -9|\n| -5 -7 -9|  \nActual: \n"+ testM1.multiply(testM2));
            testM1 = new MathMatrix(3, 2, 2);
            System.out.println("test 12: Multiplying testM1 to testM2 should result in \n| 10 14 18|\n| 10 14 18|\n| 10 14 18|  \nActual: \n"+ testM1.multiply(testM2));
            System.out.println("test 13: Scaling testM1 by 2 should result in \n| 4 4|\n| 4 4| \n| 4 4| \nActual: \n"+ testM1.getScaledMatrix(2));
            System.out.println("test 14: Scaling testM2 by 10 should result in \n| 10 20 30|\n| 40 50 60| \nActual: \n"+ testM2.getScaledMatrix(10));
            System.out.println("test 15: Transposing testM1 should result in \n| 2 2 2|\n| 2 2 2| \nActual: \n"+ testM1.getTranspose());
            System.out.println("test 16: Transposing testM2 should result in \n| 1 4|\n| 2 5| \n| 3 6|\n Actual: \n"+ testM2.getTranspose());
            System.out.println("test 17: testM1.equals testM2 should be false Actual:"+ testM1.equals(testM2));
            testM3 = new MathMatrix(3, 2, 2);
            System.out.println("test 18: testM1.equals testM3 should be true Actual:"+ testM1.equals(testM3));
            System.out.println("test 19: testM1.toString should result in\n| 2 2|\n| 2 2|\n| 2 2|  \n Actual: \n"+testM1.toString());
            System.out.println("test 20: testM2.toString should result in\n| 1 2 3|\n| 4 5 6|\n Actual: \n"+testM2.toString());
            int[][] upRec = {{1, 2, 3}, {0, 4, 5}, {0, 0, 6}};
            testM1 = new MathMatrix(upRec);
            System.out.println("test 22: testM1.isUpperTriangular() should be true. Actual: "+testM1.isUpperTriangular());
            testM2 = new MathMatrix(5, 5, 2);
            System.out.println("test 22: testM2.isUpperTriangular() should be false. Actual: "+testM2.isUpperTriangular());
            //experiment code
            /*int[][] experimentArray = new int[4000][4000];
            for (int i = 0; i < experimentArray.length; i++) 
            {
               for (int j = 0; j < experimentArray.length; j++) 
               {
                 experimentArray[i][j] = ((int)Math.random()*1000);
               }
            }
            int[][] experimentArray2 = new int[4000][4000];
            for (int i = 0; i < experimentArray2.length; i++) 
            {
               for (int j = 0; j < experimentArray2.length; j++) 
               {
                 experimentArray2[i][j] = ((int)Math.random()*1000);
               }
            }
            MathMatrix experimentMatrix = new MathMatrix(experimentArray);
            MathMatrix experimentMatrix2 = new MathMatrix(experimentArray2);
            double timeTotal = 0;
            Stopwatch s = new Stopwatch();
            for(int i = 0; i < 1000; i++) {
            	s.start();
                experimentMatrix.add(experimentMatrix2);
                s.stop();
                timeTotal += s.time();
                for (int k = 0; k < experimentArray.length; k++) 
                {
                   for (int j = 0; j < experimentArray.length; j++) 
                   {
                     experimentArray[i][j] = ((int)Math.random()*1000);
                   }
                }
                for (int k = 0; k < experimentArray2.length; k++) 
                {
                   for (int j = 0; j < experimentArray2.length; j++) 
                   {
                     experimentArray2[i][j] = ((int)Math.random()*1000);
                   }
                }
                experimentMatrix = new MathMatrix(experimentArray);
                experimentMatrix2 = new MathMatrix(experimentArray2);
            }
            System.out.println(timeTotal);
            //1000x1000 matrix: time to run 1000 tests was 2.2936284 seconds
            //2000x2000 matrix: time to run 1000 tests was 11.71065089 seconds
            //4000x4000 matrix: time to run 1000 tests was 38.0261449 seconds
            */
            
            //Experiment 2
            /*Stopwatch t = new Stopwatch();
            double timeTotal2 = 0;
            int[][] experimentArray3 = new int[1200][1200];
            for (int i = 0; i < experimentArray3.length; i++) 
            {
               for (int j = 0; j < experimentArray3.length; j++) 
               {
                 experimentArray3[i][j] = ((int)Math.random()*1000);
               }
            }
            int[][] experimentArray4 = new int[1200][1200];
            for (int i = 0; i < experimentArray4.length; i++) 
            {
               for (int j = 0; j < experimentArray4.length; j++) 
               {
                 experimentArray4[i][j] = ((int)Math.random()*1000);
               }
            }
            MathMatrix experimentMatrix3 = new MathMatrix(experimentArray3);
            MathMatrix experimentMatrix4 = new MathMatrix(experimentArray4);
            for(int i = 0; i < 100; i++) {
            	t.start();
                experimentMatrix3.multiply(experimentMatrix4);
                t.stop();
                timeTotal2 += t.time();
                for (int k = 0; k < experimentArray3.length; k++) 
                {
                   for (int j = 0; j < experimentArray3.length; j++) 
                   {
                     experimentArray3[i][j] = ((int)Math.random()*1000);
                   }
                }
                for (int k = 0; k < experimentArray4.length; k++) 
                {
                   for (int j = 0; j < experimentArray4.length; j++) 
                   {
                     experimentArray4[i][j] = ((int)Math.random()*1000);
                   }
                }
                experimentMatrix3 = new MathMatrix(experimentArray3);
                experimentMatrix4 = new MathMatrix(experimentArray4);
            }
            System.out.println(timeTotal2);
            //300x300 array: time to run 100 tests was 2.6629623 seconds
            //600x600 array: time to run 100 tests was 22.2955532 seconds
            //1200x1200 array: time to run 100 tests was 212.3329051 seconds
             
             */
            //MathMatrix MaxSize = new MathMatrix(45_586, 45_586, -1);
    }

    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if (mat == null) {
            throw new IllegalArgumentException("mat may not be null");
        } 
        int result = 0;
        final int ROWS =  mat.getNumRows();
        final int COLS = mat.getNumColumns();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
            }
        }
        return result;
    }

    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    public static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {

        if (randNumGen == null) {
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        } else if(rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
                    "rows: " + rows + ", cols: " + cols);
        }

        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
            }
        }

        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
        System.out.print("Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println(result);
    }

    // pre: m != null, m is at least 1 by 1 in size
    // return a 2d array of ints the same size as m and with 
    // the same elements
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        if  ((m == null) || (m.getNumRows() == 0) 
                || (m.getNumColumns() == 0)) {
            throw new IllegalArgumentException("Violation of precondition: get2DArray");
        }

        int[][] result = new int[m.getNumRows()][m.getNumColumns()];
        for(int r = 0; r < result.length; r++) {
            for(int c = 0; c < result[0].length; c++) {
                result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
        //check precondition
        if((data1 == null) || (data1.length == 0) 
                || (data1[0].length == 0) || !rectangularMatrix(data1)
                ||  (data2 == null) || (data2.length == 0)
                || (data2[0].length == 0) || !rectangularMatrix(data2)) {
            throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");
        }
        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while (result && row < data1.length) {
            int col = 0;
            while (result && col < data1[0].length) {
                result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        }
        return MathMatrix.rectangularMatrix(mat);
    }
}
