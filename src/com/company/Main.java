package com.company;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
public static ArrayList<Integer> numbers = new ArrayList<>();
public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        setArray();
        int remain = total()%10;
        int check = 10 - remain;
        System.out.println("the check digit is: "+check);
    }
    public static void setArray(){
        boolean valid = false;
        while (!valid){
            try{
                System.out.println("enter a 13-digit barcode");
                String code = input.next();
                for(int i = 0; i < 13; i++){
                    int num = code.charAt(i) - '0';
                    numbers.add(num);
                }
                valid = true;
            }
            catch (Exception e){
                System.out.println("Error "+e);
            }
        }
    }
    public static Integer total(){
        int total1 = 0;
        int total2 = 0;
        boolean odd = true;
        for(int i = 0; i < 13; i++){
            if(odd){
                total1 += numbers.get(i);
                odd = false;
            }
            else{
                total2 += numbers.get(i);
                odd = true;
            }
        }
        int total = (total1*3)+total2;
        return total;
    }
}

