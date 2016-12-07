package com.practice.java.hackerrank;


public class CommonChild {

    /**
     * @param args
     */
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		/*Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();*/
		String s1 = "WEWOUCUIDGCGTRMEZEPXZFEJWISRSBBSYXAYDFEJJDLEBVHHKS";
		String s2 = "FDAGCXGKCTKWNECHMRXZWMLRYUCOCZHJRRJBOAJOQJZZVUYXIC";

		/*String s1 = "HARRYK";
    	String s2 = "SRRKHALLY";*/

		//lcs(s1, s2);
		int count = maxChildLength(s1.toCharArray(), s2.toCharArray());
		System.out.println(count);
	}
    
    private static int maxChildLength(char[] c1, char[] c2){
    	int count =0;
    	int l1 = c1.length;
    	int l2 = c2.length;
    	int[][] m = new int[l1 + 1][l2 + 1];
    	int maxi = 0; 
    	int maxj =0;
    	int max=0;
    	for (int i = 1; i <= l1; i++) {
    		for (int j = 1; j <= l2; j++) {
    			if (c1[i-1] == c2[j-1]) {
    				m[i][j] = 1 + max(m[i-1][j], m[i][j-1]);
    			} else {
    				m[i][j] = max(m[i-1][j], m[i][j-1]);
    			}
    			if (m[i][j] > max) {
    				max = m[i][j];
    				maxi = i;
    				maxj=j;
    			}
    		}
    	}
    	/*for (int i = l1; i > 0; i--) {
    		for (int j = l2; j > 0; j--) {*/
    	int i=maxi;
    	int j=maxj;
    	while(i >= 1 && j >= 1){
    			if (c1[i-1] == c2[j-1]) {
    				count++;
    				i--;j--; 
    			} else if (m[i-1][j]>m[i][j-1]) {
    				i--;
    			} else {
    				j--;
    			}
    		}
    	//}
    	
    	return count;
    }
    
    public static int max(int a, int b) {
    	if(a > b) {
    		return a;
    	} else {
    		return b;
    	}
    }
    
    public static void lcs(String x, String y) {
        int M = x.length();
        int N = y.length();

        // opt[i][j] = length of LCS of x[i..M] and y[j..N]
        int[][] opt = new int[M+1][N+1];

        // compute length of LCS and all subproblems via dynamic programming
        for (int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j))
                    opt[i][j] = opt[i+1][j+1] + 1;
                else 
                    opt[i][j] = Math.max(opt[i+1][j], opt[i][j+1]);
            }
        }

        // recover LCS itself and print it to standard output
        int i = 0, j = 0;
        while(i < M && j < N) {
            if (x.charAt(i) == y.charAt(j)) {
                System.out.print(x.charAt(i));
                i++;
                j++;
            }
            else if (opt[i+1][j] >= opt[i][j+1]) i++;
            else                                 j++;
        }
        System.out.println();

    
    }
}