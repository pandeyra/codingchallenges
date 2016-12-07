package com.programs.geeksforgeeks;

import java.util.Scanner;
//This program is solution to http://www.practice.geeksforgeeks.org/problem-page.php?pid=474
class MatrixPath {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i=0; i<t; i++) {
		    //rows
		    int rows = s.nextInt();
		    //columns
		    int cols = s.nextInt();
		    System.out.println(countPath(rows, cols, 0, 0));
		}
		s.close();
	}
	
	private static int countPath(int rows, int cols , int i, int j) {
	    if ( i == rows - 1 && j == cols - 1 ) {
	        //it means last element hence no path.
	        return 0;
	    } 
	    if (i == rows -1 ) {
	        //means only 1 row exixt so single path.
	        return 1 ;
	    }
	    if (j == cols - 1 ) {
	        //means only column exists hence single path
	        return 1 ;
	    }
	    
	    return ( countPath(rows, cols, i, j + 1) + countPath(rows, cols, i + 1, j) );
	}
}
