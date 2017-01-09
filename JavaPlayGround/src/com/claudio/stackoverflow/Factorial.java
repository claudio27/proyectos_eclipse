package com.claudio.stackoverflow;

import java.math.BigInteger;

public class Factorial {

	
	public static void main(String[] args) {
		
        try{
            
        System.out.println(factorial(3000));
        System.out.println(factorial(new BigInteger("5030")));
        
        }catch(StackOverflowError e){
           System.err.println( e);
           System.err.println( e.getLocalizedMessage());
           System.err.println( e.getMessage());

           System.err.println("---");                      
        }
		
	}
	
    public static int factorial(int n){
        
        if(n == 0)
            return 1;
        else
            return n * factorial(n -1);
    }
    
    public static BigInteger factorial(BigInteger n){
        BigInteger base = new BigInteger("1");
        
        if(n.compareTo(BigInteger.ZERO) ==  0)
            return base;
        else
            return n.multiply(factorial(n.subtract(new BigInteger("1"))));
    }
}
