/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myStack;

import java.util.ArrayList;     //import arrayList for stack data structure
import java.util.Scanner;       //import Scanner for user input

//*****************************************************************
//myStackInteger
//this program will make use of a generic stack implemented as
//integer to mimic a post-fix adding machine.
//user input is error-handled
public class myStackInteger extends myStackGeneric<Integer>{

    @Override
    public Integer addition(Integer obj1, Integer obj2) {
       return obj1 + obj2;
    }

    @Override
    public Integer subtract(Integer obj1, Integer obj2) {
        return obj2 - obj1;
    }

    @Override
    public Integer multiply(Integer obj1, Integer obj2) {
       return obj1 * obj2;
    }

    @Override
    public Integer newElement(String input) {
       return new Integer(input);
    }

    @Override
    public Integer zero() {
        return new Integer(0);
    }
}
