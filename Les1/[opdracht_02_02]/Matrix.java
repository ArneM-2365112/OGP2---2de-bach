public class Matrix {
    private int[][] matrix;

    // Contructor init lege matrix
    public Matrix() {
        matrix = new int[3][3];
    }

    // Contructor init niet-lege matrix
    public Matrix(int[][] values) {
        if (values.length == 3 && values[0].length == 3) {
            this.matrix = values;
        } else {
            throw new IllegalArgumentException("Matrix moet 3x3 zijn.");
        }
    }

    // Set element in matrix
    public void setElement(int row, int col, int value) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            matrix[row][col] = value;
        } else {
            throw new IndexOutOfBoundsException("Matrix is 3x3 groot");
        }
    }

    // Get element in matrix
    public int getElement(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3) {
            return matrix[row][col];
        } else {
            throw new IndexOutOfBoundsException("Matrix is 3x3 groot");
        }
    }

    // Add 2 matrices together
    public Matrix add(Matrix other) {
        Matrix result = new Matrix();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                result.setElement(row, col, this.getElement(row, col) + other.getElement(row, col));
            }
        }
        return result;
    }

    // Multiply 2 matrices together
    public Matrix multiply(Matrix other) {
        Matrix result = new Matrix();
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                int sum = 0;
                for (int i = 0; i < 3; i++) {
                    sum += this.getElement(row, i) * other.getElement(i, col);
                }
                result.setElement(row, col, sum);
            }
        }
        return result;
    }

    // Print matrix
    public void print() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] values1 = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        int[][] values2 = {
                { 9, 8, 7 },
                { 6, 5, 4 },
                { 3, 2, 1 }
        };

        Matrix matrix1 = new Matrix(values1);
        Matrix matrix2 = new Matrix(values2);

        matrix1.print();

        Matrix matrixSum = matrix1.add(matrix2);
        matrixSum.print();

        Matrix matrixMul = matrix1.multiply(matrix2);
        matrixMul.print();
    }
}
