package Homework.HW_2;
import java.io.*;
import java.lang.Math;

import java.nio.file.Files;
import java.nio.file.Paths;

import java.io.IOException;


public class Program {
    public static void main(String[] args) {
        ReadReturnString();
        String a = Multi(ReadReturnString());
        WriteResult(a);
    }   

    public static String ReadReturnString() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("input.txt"))) { 
            String fileName = "input.txt";
            String content = Files.lines(Paths.get(fileName)).reduce("", String::concat);
            //System.out.println(content);
            return content;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return "exeption"; 
    }

    public static String Multi(String content) {
        double a = Double.valueOf(String.valueOf(
            content.substring(content.lastIndexOf("a " ) + 1,
            content.lastIndexOf("b") )));
        double b = Double.valueOf(String.valueOf(content.substring(content.lastIndexOf("b ") + 1)));
        if (a == 0 && b == 0)
        return "Не определено";
        else{
        double result = Math.pow(a, b);
        String value = String.valueOf(result);
        return value;
        }
    }

    public static void WriteResult(String result) {
        try(FileWriter writer = new FileWriter("output.txt", false))
        {
            writer.write(result);
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 

    }
}


