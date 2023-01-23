package Homework.HW_1;

//Написать программу вычисления n-ого треугольного числа.

import java.util.Scanner;
public class program_1 {
    public static void main(String[] args) {
        int number = getNumber();
        System.out.println(getTriangNumber(number));    
    }


    public static int getNumber(){
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Ведите искомое треугольное число: ");
        int number = iScanner.nextInt();
        iScanner.close();
        return number;
    }
    
    public static int getTriangNumber(int num){
        int t = (num*(num + 1)) / 2;
        return t;    
    }
       
}