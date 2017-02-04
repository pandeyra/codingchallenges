package com.practice.java;

import java.util.Arrays;

public class PairWithDiffK {

	public static void main(String[] args) {
		int[] arr = {3,4,2,6,4,5,7,0,8};
		int k = 2;
		Arrays.sort(arr);
		System.out.println(arr[0] + "," + arr[1] + ", " + arr[2]);
		int i = 0, j = 0;
		while ( j < arr.length) {
			if (arr[j] - arr[i] == k) {
				System.out.println(arr[i] + ", " + arr[j]);
				i++; j--;
			} else if ( arr[j] - arr[i] < k) {
				j++;
			} else {
				i++;
			}
		}
	}

}
