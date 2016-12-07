package com.practice.java.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ChallengeSharePrice {

	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int d = s.nextInt();
		int[] sharePrices = new int[n];
		int[] profits = new int[d];
		int maxPrice=0,minPrice=-9999;
		for (int i = 0; i < n; i++) {
			sharePrices[i] = s.nextInt();
			if(maxPrice < sharePrices[i]) {
				maxPrice = sharePrices[i];
			}
			if (minPrice == -9999 || minPrice > sharePrices[i]){
				minPrice = sharePrices[i];
			}
		}
		for (int i = 0; i < d; i++) {
			profits[i] = s.nextInt();
		}
		Map<Integer, Integer> profitMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> sellDayMap = new HashMap<Integer, Integer>();
		for (int j=0; j < n-1; j++) {
			for (int k = j + 1; k < n; k++) {
				int diff = k-j;
				int profit = sharePrices[k] - sharePrices[j];
				if (profitMap.get(profit) == null || profitMap.get(profit) > diff ) {
					profitMap.put(profit, diff);
					sellDayMap.put(profit, k);
				}
			}
		}
	
		for (int i = 0; i < d; i++) {
			//only if profit can be made
			if (profits[i] < (maxPrice - minPrice)) {
				int diff = profitMap.get(profits[i]);
				int start = (sellDayMap.get(profits[i]) - diff) + 1;
				int end = sellDayMap.get(profits[i]) + 1;
				System.out.println(start + " " + end);
			} else {
				System.out.println("-1");
			}
		}
	
    }
}
