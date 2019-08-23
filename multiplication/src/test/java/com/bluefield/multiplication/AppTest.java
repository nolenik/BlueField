package com.bluefield.multiplication;

import static org.junit.Assert.*;

import org.junit.Test;


public class AppTest 
{
    @Test
    public void testAlgorithm1 () {
    	assertEquals("13717421001371742098628257899862825790",
        		App.multiplication("1", "12345678901234567890",
        				"1111111111111111111"));
    }
    
    @Test
    public void testAlgorithm2 () {
    	assertEquals("13717421001371742098628257899862825790",
        		App.multiplication("2", "12345678901234567890",
        				"1111111111111111111"));
    }
    
    @Test
    public void testCustomMultiplication()
    {
    	 
        assertEquals("13717421001371742098628257899862825790",
        		App.customMultiplication("12345678901234567890",
        				"1111111111111111111"));
    }
    
    @Test 
    public void testMultiplicationWithBigInteger() {
    	assertEquals("13717421001371742098628257899862825790",
        		App.multiplicationWithBigInteger("12345678901234567890",
        				"1111111111111111111"));
    }
}
