package com.practice.java;

import java.util.Arrays;

//Given elements in an array. Find the pair of elements whose sum is equal to k
public class PairsWithSumK {

	public static void main(String[] args) {
		int[] arr = {3,4,2,6,4,5,1,7,0,8};
		int k = 80;
		Arrays.sort(arr);
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (arr[i] + arr[j] == k) {
				System.out.println(arr[i] + ", " + arr[j]);
				i++; j--;
			} else if ( arr[i] + arr[j] > k) {
				j--;
			} else {
				i++;
			}
		}
	}

}
