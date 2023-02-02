package Homework.HW_3;
import java.util.Scanner;
public class Program {
    public static void main(String[] args) { 
        int[] value = GetValue();
        GetCount(value);
        PrintCount(value, GetCount(value));       

}

public static int[] GetValue(){
    Scanner iScanner = new Scanner(System.in);
    int[] arr = new int[2];    
    System.out.printf("Ведите размер поля M x N: ");
    arr[0] = iScanner.nextInt();
    arr[1] = iScanner.nextInt();
    iScanner.close();
    return arr;   
}
public static int GetCount(int[] arr){
    int m = arr[0];
    int n = arr[1];
    int[][] a = new int[m][n];
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            a[i][j] = 1;
        }  
    }
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            a[i][j] = a[i-1][j] + a[i][j-1];    
        } 
    }   
int count = a[m - 1][n - 1];
return count;
}
public static void PrintCount(int[] arr, int count){
    System.out.print("Количество возможных путей из точки М = 0 N = 0 в точку ");
    System.out.print("М = ");
    System.out.print(arr[0]);
    System.out.print(" N = ");
    System.out.print(arr[1]);
    System.out.print(" составляет ");
    System.out.println(count);
}
}