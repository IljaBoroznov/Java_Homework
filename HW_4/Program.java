package Homework.HW_4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Deque;

public class Program {
    public static void main(String[] args) { 
        Scanner iScanner = new Scanner(System.in); 
        System.out.println("Ведите координату точки начала");
        int a = iScanner.nextInt();  
        System.out.println("Ведите координату точки начала");
        int b = iScanner.nextInt();
        int [][] matr = fillMatrix();
        System.out.printf("Ведите количество стен ");
        int count = iScanner.nextInt();
        int i = 0;
        while (i < count){
            System.out.printf("Ведите координату Х стены ");
            int x = iScanner.nextInt();
            System.out.printf("Ведите координату Y стены ");
            int y = iScanner.nextInt();
            matr[x][y] = -1;
            i++;
        }
        
        System.out.printf("Ведите координату Х выхода 1 ");
        int x1 = iScanner.nextInt();
        System.out.printf("Ведите координату Y выхода 1 ");
        int y1 = iScanner.nextInt();
        int [] outs1 = {x1, y1};

        System.out.printf("Ведите координату Х выхода 2 ");
        int x2 = iScanner.nextInt();
        System.out.printf("Ведите координату Y выхода 2 ");
        int y2 = iScanner.nextInt();
        int [] outs2 = {x2, y2}; 

        iScanner.close();
        
        printMatrix(matr);
        int [][] newMatr = Li(matr, a, b);
        printMatrix(newMatr);
        
        int select = outputSelection(newMatr[outs1[0]][outs1[1]], newMatr[outs2[0]][outs2[1]]);
        printOutput(select, newMatr[outs1[0]][outs1[1]], newMatr[outs2[0]][outs2[1]]);
        int [] exitCoord = exitCoordinat(select, outs1, outs2);
        int [][] result = getRoute(newMatr, exitCoord[0], exitCoord[1], newMatr[exitCoord[0]][exitCoord[1]]);
        System.out.printf("Координаты маршрута выведены в формате [X, Y] ");
        System.out.println(Arrays.deepToString(result));
        
    }

    public static int[] exitCoordinat(int select, int[] a, int[] b){
        if (select == 1){
            return a;
        }
        else{ 
            return b;   
        }
    }
    public static void printOutput(int select, int a, int b){
        if (select == 1){
            System.out.printf("Кратчайший путь до выхода № 1 = ");
            System.out.println(a - 1);
            System.out.printf("Путь до выхода № 2 = ");
            System.out.println(b - 1);
        }
        else{
            System.out.printf("Кратчайший путь до выхода № 2 = ");
            System.out.println(b - 1);
            System.out.printf("Путь до выхода № 1 = ");
            System.out.println(a - 1);
        }
    }
    public static int outputSelection(int a, int b){
        if (a < b){
            return 1;
        }
        else{
            return 2;
        }
    } 
    public static int[][] fillMatrix(){
        int[][] a = new int [8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a[i][j] = 0;
            }  
        }
        return a;
    } 
    public static void printMatrix(int matr[][]){
        for (int i = 0; i < 8; i++){
            System.out.print("[");
            for (int j = 0; j < 8; j++){
                System.out.print(matr[i][j]);
                if (j < 7)
                System.out.print(", ");
            }
            System.out.print("]\n");
        }
        System.out.println();
    }   
    public static int [][] Li(int matr[][], int a, int b){
        int i = a;  int j = b;
        Queue<Integer> q = new LinkedList<Integer>();
        matr[i][j] = 1;
        while (true){
            int k;
            if ((i - 1)  >= 0 && matr[i - 1][j] == 0 &&  j >= 0){
                matr[i - 1][j] = matr[i][j] + 1;
                k = (i - 1) * 10 + j;
                q.add(k);
                }   
            if (j + 1 < 8 && matr[i][j + 1] == 0 && i >= 0 && j >= 0 ){
                matr[i][j + 1] = matr[i][j] + 1;
                k =  i * 10 + j + 1;
                q.add(k);
                }
            if (i + 1 < 8 && matr[i + 1][j] == 0 && i >= 0 && j >= 0 ){
                matr[i + 1][j] = matr[i][j] + 1;
                k = (i + 1) * 10 + j;
                q.add(k);
                }
            if (j - 1 >= 0 && matr[i][j - 1] == 0 && i >= 0){
                matr[i][j - 1] = matr[i][j] + 1;
                k =  i * 10 + (j-1);
                q.add(k);
                }
            int n = q.element();
            i = n / 10; j = n % 10;        
            q.remove();
            if (q.size() == 0){
                break;
            }
        }            
    return matr;
    }
    public static int [][] getRoute(int matr[][], int a, int b, int c){
        int i = a; int j = b;
        Deque<Integer> deque = new ArrayDeque<>();

        for(int count = 1; count < c - 1; count++){
            int k;
            switch(count){
                case(1):
                if ((i - 1)  >= 0 && matr[i - 1][j] == matr[i][j] - 1 &&  j >= 0){
                    k = (i - 1) * 10 + j;
                    deque.add(k);
                    i = i-1;
                    count = 0;
                    }
                    break;
                case(2):
                if (j + 1 < 8 && matr[i][j + 1] == matr[i][j] - 1 && i >= 0 && j >= 0 ){
                    k =  i * 10 + j + 1;
                    deque.add(k);
                    j=j+1;
                    count = 0;
                    }
                    break;
                case(3):
                if (i + 1 < 8 && matr[i + 1][j] == matr[i][j] - 1 && i >= 0 && j >= 0 ){
                    k = (i + 1) * 10 + j;
                    deque.add(k);
                    i=i+1;
                    count = 0;
                    }
                    break;
                case(4):
                if (j - 1 >= 0 && matr[i][j - 1] == matr[i][j] - 1 && i >= 0){
                    k =  i * 10 + (j - 1);
                    deque.add(k);
                    j=j-1;
                    count = 0;
                    }
                    break;
                default:
                    break;
            }
        }
        int[][] coor = new int[deque.size()][2];
        int size = deque.size();
        for(int z = 0; z < size; z++){
            int n = deque.getLast();
            coor[z][0] = n / 10;
            coor[z][1] = n % 10;
            deque.removeLast();
        }            
    return coor;
    }
}
