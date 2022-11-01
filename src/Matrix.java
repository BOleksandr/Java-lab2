import java.util.Arrays;

public class Matrix {
    int rows, columns;
    double[][] matrix;


    public Matrix(){
        matrix = new double[0][0];
    }

    public Matrix(int n, int m){
        this.rows = n;
        this.columns = m;
        matrix = new double[rows][columns];
    }



    public Matrix(double[][] matCopy){
        rows = matCopy.length;
        columns = matCopy[0].length;
        this.matrix = new double[rows][columns];
        for (int i = 0; i < rows;i++)
            System.arraycopy(matCopy[i], 0, this.matrix[i], 0, columns);
    }

    public static Matrix filling(int rows, int columns) {
        Matrix matrix1 = new Matrix(rows, columns);
        for (int i = 0; i < rows;i++)
            for (int j = 0; j < columns; j++)
                matrix1.matrix[i][j] = Math.round(Math.random() * 100);
        return matrix1;
    }

    public void getElement(int n, int m){
        System.out.println("Eлемент [" + n + "][" + m + "] = " + matrix[n-1][m-1]);
    }

    public void getRow(int n){
        System.out.print("Рядок " + n + ": ");
        for (int i = 0; i < this.matrix[0].length;i++){
            System.out.print(this.matrix[n-1][i] + " ");
        }
        System.out.println();
    }

    public void getColumn(int m){
        System.out.println("Стовпець "+ m +":");
        for (double[] doubles : this.matrix) {
            System.out.println(doubles[m - 1]);
        }
    }

    public int[] getSize(){
        if(matrix.length == 0)
            return new int[]{0,0};
        return new int[]{matrix.length, matrix[0].length};
    }

    public  int hashCode(){
        return Arrays.hashCode(this.matrix);
    }

    public boolean equals(Matrix matrix1){
        if(matrix1.rows != this.rows || matrix1.columns != this.columns) return false;
        for (int i = 0;i < rows;i++){
            for (int j = 0;j < columns;j++){
                if(matrix1.matrix[i][j] != this.matrix[i][j])
                    return false;
            }

        }

        return true;
    }


    public Matrix transpose() {
        Matrix matrix1 = new Matrix(columns, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < columns; j++)
                matrix1.matrix[j][i] = this.matrix[i][j];
        return matrix1;
    }


    public static void single(Matrix matrix1) {
        int[]size = matrix1.getSize();
        if(size[0] == size[1]){
            if(size[0]!= 0){
                Matrix matrix2 = new Matrix(size[0], size[1]);
                for (int i = 0;i < size[0];i++)
                    for (int j = 0;j< size[1];j++)
                        if(i==j)
                            matrix2.matrix[i][j] = 1.0;
                matrix2.print();
            }else{
                System.out.println("Матриця розмірності 0х0");
            }
        }else {
            System.out.println("Матриця не є квадратною, не можливо створити одиничну матрицю");
        }

    }

    public void print(){
        for(int i = 0;i < rows;i++){
            for (int j = 0;j < columns;j++){
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
