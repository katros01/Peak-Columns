import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    static void insertValues(int[][] matrix, int numberRow, int numberCol){
        for (int x = 0; x< numberRow; x++){
            for(int y = 0; y< numberCol; y++){

                if(!input.hasNextInt()){ // validate inputs
                    System.out.println("the value you entered on index (" + x + "," + y + ") is not a number!"  );
                    input.next();
                }

                matrix[x][y] = input.nextInt();
            }
        }
    }

    static void findPeakColumn(int row, int col, int[][] a){

        for(int i = 0; i< row; i++) {
            int max = 0;
            int maxCol = 0;
            int min = 0;

            for(int j = 0; j< col; j++) {
                if(a[i][j] >= max) {
                    max = a[i][j];
                    maxCol = j;
                }
            }

            for(int x = 0; x< row; x++) {
                if(x == 0){
                    min = a[x][maxCol];
                } else if(a[x][maxCol] <= min) {
                    min = a[x][maxCol];
                }
            }
            System.out.println(max + " " + min);
            if (max == min) {
                for (int j = 0; j< col; j++) {
                    if(maxCol != j && a[i][j] == max){
                        System.out.println("(" + (i + 1) + "," + (j + 1) + ")" + " " + "=" + " " + max);
                    }
                }
                System.out.println("(" + (i + 1) + "," + (maxCol + 1) + ")" + " " + "=" + " " + max);
            }
        }
    }

    public static void main(String[] args) {

        System.out.print("Enter number of rows for Matrix:  ");
        int numberRows = input.nextInt();

        System.out.print("Enter number of columns for Matrix:  ");
        int numberCols = input.nextInt();

        int[][] matrix = new int[numberRows][numberCols];

        System.out.println("Enter values Matrix A: " + numberRows + "," + numberCols);
        insertValues(matrix, numberRows, numberCols);

        System.out.println("\n");
        findPeakColumn(numberRows, numberCols, matrix);  // print peak-columns
    }
}