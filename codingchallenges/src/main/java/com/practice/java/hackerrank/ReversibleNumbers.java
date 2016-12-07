package com.practice.java.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReversibleNumbers {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        long[] N = new long[T];
        for (int i =0; i < T; i++) {
            N[i] = sc.nextLong();
        }
        for (int t =0; t<T; t++) {
        int count = 0;
        Map<Long, Boolean> map = new HashMap<Long, Boolean>();
        for (long i = 1; i < N[t]; i++) {
            long rev = getReverse(i);
            if (isAllOdd(i + rev) && map.get(rev) == null) {
                count++;
                map.put(rev, true);
            }
        }
        System.out.println(count); 
        } 
    }
	 
    private static long getReverse(long n){
       long rev = 0;
       if (n%10 == 0)
               return rev;
       while (n > 0) {
           long remainder = n%10l;
           n = n/10;
           rev = 10 * rev + remainder;
        }
        return rev;
    }
    
    private static boolean isAllOdd(long n) {
       boolean isOdd = true;
       while (isOdd && n > 0) {
           long remainder = n%10l;
           if ((remainder & 1) != 0) {
              n = n/10l; 
           } else {
              isOdd = false; 
           }  
        }
        return isOdd;
    }
}
