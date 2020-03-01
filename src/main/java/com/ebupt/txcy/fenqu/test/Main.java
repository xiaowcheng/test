package com.ebupt.txcy.fenqu.test;

import scala.Int;

import java.io.*;
import java.util.*;
class test{
    public void getTest(int num) throws IllegalArgumentException{
        if(num == 1){
            throw  new IllegalArgumentException("1");
        }else if(num ==2){
            throw new IllegalArgumentException("2");
        }
    }
   

}
public class Main
{
    public static boolean getNum(String s){
        try {
//            System.out.println(s);
            String[] i = s.split(" ");
            for(int x=0;x<s.length() - 2;x++){
                if(i[x] .equals( i[x+1])){
                return false;
                }
            }
            return true;
        }catch (Exception e){
            return false;
        }
  }
    public static void main(String args[])
    {
//        Scanner cin = new Scanner(System.in);
//        String a,b,c ;
//        while(cin.hasNextLine())
//        {
//            a = cin.nextLine();
//            int y = Integer.parseInt(a);
//            for(int x =0;x<y ;x++){
//                b = cin.nextLine();
//                int z = Integer.parseInt(b);
//                c = "";
//
//                for (int j = 0;j<z;j++){
//                    c = c+ " "+ cin.nextLine();
//                }
//
//                    System.out.println("Yes");
//            }
//        }
        try {
            test t = new test();
            t.getTest(1);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
