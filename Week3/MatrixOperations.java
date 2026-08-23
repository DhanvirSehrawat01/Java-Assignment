import java.util.Scanner;
public class MatrixOperations 
{
 static int[] rowSums(int[][]matrix){
    int[] sums=new int[matrix.length];
    for(int i=0; i<matrix.length; i++)
    {
        for (int j=0;j<matrix[i].length;j++)
        {
              sums[i] += matrix[i][j];
        }
    }
    return sums;
 } 
 static int[] columnSums(int[][] matrix)
  {
        if (matrix.length == 0) 
        {
            return new int[0];
        }
        int columns = matrix[0].length;
        int[] sums = new int[columns];
        for (int j = 0; j < columns; j++) 
            {
            int sum= 0;
            for (int i = 0; i < matrix.length; i++) 
            {
                sum = sum + matrix[i][j];
            }
            sums[j] = sum;
        }
        return sums;
    }
    static int[][] add(int[][] first, int[][] second)
     {
        if (first.length != second.length)
         {
            return null;
        }
        if (first.length > 0 &&
            first[0].length != second[0].length)
         {
            return null;
        }
        int rows = first.length;
        int columns = 0;
        if (rows > 0)
         {
            columns = first[0].length;
        }
        int[][] result = new int[rows][columns];
        for (int i = 0; i < rows; i++)
         {
            for (int j = 0; j < columns; j++)
             {
                result[i][j] = first[i][j] + second[i][j];
            }
        }
        return result;
    }
    static int[][] transpose(int[][] matrix) 
    {
        if (matrix.length == 0)
         {
            return new int[0][0];
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] result = new int[columns][rows];
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < columns; j++) 
            {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }
    static int[][] multiply(int[][] first, int[][] second) 
    {
        if (first.length == 0 || second.length == 0) {
            return null;
        }
        int firstColumns = first[0].length;
        int secondRows = second.length;
        if (firstColumns != secondRows) 
        {
            return null;
        }
        int firstRows = first.length;
        int secondColumns = second[0].length;
        int[][] result = new int[firstRows][secondColumns];
        for (int i = 0; i < firstRows; i++) 
        {
            for (int j = 0; j < secondColumns; j++)
             {

                int sum = 0;

                for (int k = 0; k < firstColumns; k++) {
                    sum = sum + first[i][k] * second[k][j];
                }

                result[i][j] = sum;
            }
        }

        return result;
    }
    static void printMatrix(int[][] matrix)
     {
        if (matrix == null) 
        {
            System.out.println("Invalid matrix operation.");
            return;
        }
        for (int i = 0; i < matrix.length; i++) 
        {

            for (int j = 0; j < matrix[i].length; j++) 
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter rows of first matrix: ");
        int rows1 = input.nextInt();
        System.out.print("Enter columns of first matrix: ");
        int columns1 = input.nextInt();
        int[][] first = new int[rows1][columns1];
        System.out.println("Enter first matrix:");
        for (int i = 0; i < rows1; i++) 
        {
            for (int j = 0; j < columns1; j++) 
            {
                first[i][j] = input.nextInt();
            }
        }
        System.out.print("Enter rows of second matrix: ");
        int rows2 = input.nextInt();
        System.out.print("Enter columns of second matrix: ");
        int columns2 = input.nextInt();
        int[][] second = new int[rows2][columns2];
        System.out.println("Enter second matrix:");
        for (int i = 0; i < rows2; i++) 
        {
            for (int j = 0; j < columns2; j++)
             {
                second[i][j] = input.nextInt();
            }
        }
        System.out.println("\nRow sums of first matrix:");
        int[] rows = rowSums(first);
        for (int i = 0; i < rows.length; i++) 
        {
            System.out.print(rows[i] + " ");
        }
        System.out.println("\n\nColumn sums of first matrix:");
        int[] columns = columnSums(first);
        for (int i = 0; i < columns.length; i++)
         {
            System.out.print(columns[i] + " ");
        }
        System.out.println("\n\nAddition:");
        int[][] addition = add(first, second);
        printMatrix(addition);
        System.out.println("\nTranspose of first matrix:");
        int[][] transposed = transpose(first);
        printMatrix(transposed);
        System.out.println("\nMultiplication:");
        int[][] multiplication = multiply(first, second);
        printMatrix(multiplication);
        input.close();
    }
}


