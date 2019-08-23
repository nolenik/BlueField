package com.bluefield.multiplication;

import java.math.BigInteger;


public class App 
{
	
	public static String multiplication (String algorithm, String num1, String num2) {
		if (algorithm.equals("1"))
			return customMultiplication(num1,num2);
		if (algorithm.equals("2"))
			return multiplicationWithBigInteger(num1,num2);
		return "Incorrect algorithm";
	} 
	
	
	public static String customMultiplication (String num1, String num2) {
		if (num2.length()>num1.length()) {
			String tmp = num1;
			num1=num2;
			num2=tmp;
		}
		
        int[][] tmpResult = new int[num2.length()][num1.length()+num2.length()];
        int[] result = new int[num1.length()+num2.length()];
        String finalResult="";
		for (int k=num2.length()-1;k>=0;k--) {
			int d1 = Character.getNumericValue(num2.toCharArray()[k]);
			for (int n=num1.length()-1; n>=0;n--) {
				
				int d2=Character.getNumericValue(num1.toCharArray()[n]);
				tmpResult [num2.length()-k-1][n+k+1] = d1*d2;
			}
		}

		 for (int[] t:tmpResult) {
	        	for (int i = 0; i<result.length;i++)
	        		result[i]+=t[i];
	        }
		 for (int i = result.length-1;i>0;i--) {
			 result[i-1]+=result[i]/10;
			 result[i]%=10;
		 }
		 for (int t:result) 
			 finalResult+=t;
		 while (finalResult.charAt(0)=='0')
			 finalResult=finalResult.substring(1);

		return finalResult;
	}
	
	
	public static String multiplicationWithBigInteger(String num1,String num2) {
		BigInteger b1 = new BigInteger(num1);
		BigInteger b2 = new BigInteger(num2);
		return b1.multiply(b2).toString();
	}
    
	
	public static void main (String[] args) {
    	
    	if (args.length!=3) {
    		System.out.print("Incorrect numbers of arguments");
    		return;
    	}
    	
    	if (!args[1].matches("-?\\d+") || !args[2].matches("-?\\d+"))
    		throw new IllegalArgumentException("Incorrect numbers");
    	
    	boolean sign = false;
    	
    	if (args[1].charAt(0)=='-') {
    		args[1]=args[1].substring(1);
    		sign=!sign;
    	}
    	
    	if (args[2].charAt(0)=='-') {
    		args[2]=args[2].substring(1);
    		sign=!sign;
    	}
    	
    	String result="";
    	
    	if (sign)
    		result+="-";
    	result += multiplication(args[0], args[1],args[2]);
        System.out.print(result);
    }
}
