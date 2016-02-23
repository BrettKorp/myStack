package myStack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bkorp1
 */
public class myStackComplexTest {
    
    /**
     * Test of readInput method, of class myStackComplex.
     */
    @Test
    public void testReadInput() throws Exception {
        
        /* 
        jUnit test  data for MyStackComplex method readInput
        First field is the input string for readInput,
        second field is the correct output for readInput,
        You need to clear the stack after each String test
             Nota Bene, we have implemented a postfix complex calculator
        */
        String[][] testData = {
        { "2+i 3+i 4 + p + p",
          "2.00+1.00i, 7.00+1.00i\n9.00+2.00i\n" },

        { "i i 2 3 p",
          "1.00i, 1.00i, 2.00, 3.00\n" },

        { "2+i 3 * 2 + 2+i - p",
          "6.00+2.00i\n" },

        { "2+i 3+2i - p",
          "-1.00-1.00i\n" },

        { "2+i 2+2i p",
          "2.00+1.00i, 2.00+2.00i\n" },

        { "2 2+3i 2-3i i + + p 2 3.5+i * p",
          "2.00, 4.00+1.00i\n2.00, 4.00+1.00i, 7.00+2.00i\n" },

        { "1+1i 2.5-2.5i 3i 4.56i 4.5+4.5i p + + p",
          "1.00+1.00i, 2.50-2.50i, 3.00i, 4.56i, 4.50+4.50i\n1.00+1.00i, 2.50-2.50i, 4.50+12.06i\n" },

        { "-1.5-2.2i -3i - 2.0 5.66 + * p",
          "-11.49+6.13i\n" },

        { "1.0i -2.0i + p 2.0 3i + * p",
          "-1.00i\n3.00-2.00i\n" },

        { "2.3 4.55 + 2.0 * i + p",
          "13.70+1.00i\n" },

         { "23.0 45.0 2+3i * 45.677+3.12i -23i + + 36.789 45.123+0.2345i p",
          "23.00, 135.68+115.12i, 36.79, 45.12+0.23i\n" }
        };
        
        System.out.println("readInput");
        
        for(int i = 0; i < testData.length; i++){
            Scanner in = new Scanner(testData[i][0]);
            myStackComplex instance = new myStackComplex();
            String expResult = testData[i][1];
            String result = instance.readInput(in, false);
            assertEquals(expResult, result);
        }
    }



    
}
