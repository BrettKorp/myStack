package myStack;

import java.util.ArrayList;
import java.util.Scanner;



//**********************************************************************
//abstract genericStack Class
abstract class myStackGeneric <E> extends ArrayList<E> {

    public void push(E n){
        add( n );
    }

    public E pop(){
        return (E)remove( size() - 1 );
    }

    public abstract E addition(E obj1, E obj2);
    public abstract E subtract(E obj1, E obj2);
    public abstract E multiply(E obj1, E obj2);
    public abstract E newElement(String input);
    
    String readInput(Scanner in, boolean silent) throws java.lang.Exception{
        String output = "";

        while(in.hasNext()){
            String input = in.next();
            if(input.matches("p")){
                output += print();
            }
            else if( input.matches( "^[+]$") ){
                addFirstTwo();
            }
            else if( input.matches( "^[*]$") ){
                multiplyFistTwo();
            }
            else if( input.matches( "^[-]$") ){
                subtractFirstTwo();
            }
            else{
                try{
                    //push a new object on to the stack
                    //from the scanner system input as a string
                    push( this.newElement(input) );
                }
                catch( Exception e ){
                    if( input.matches( "[-]") ){
                        subtractFirstTwo();
                    }
                    else{
                        output += e.getMessage() + "\n";
                    }
                } //end catch
            } //end else
        } //end while( in.hasNext() )

        if(!silent)
            System.out.print(output);

        return output;
    }

    public void addFirstTwo() throws IndexOutOfBoundsException {
        if(size() < 2){
            throw new IndexOutOfBoundsException("Exception: Need two operands");
        }

        this.push(this.addition(this.pop(), this.pop()));
    }

    public void subtractFirstTwo() throws IndexOutOfBoundsException {
        if(size() < 2){
            throw new IndexOutOfBoundsException("Exception: Need two operands");
        }

        E num2 = this.pop();
        E num1 = this.pop();
        //System.out.println(num2 - num1);
        this.push ( this.subtract(num1, num2));
    }

    public void multiplyFistTwo() throws IndexOutOfBoundsException{
        if(size() < 2){
            throw new IndexOutOfBoundsException("Exception: Need two operands");
        }
        E num1 = this.pop();
        E num2 = this.pop();

        this.push( this.multiply(num1, num2));
    }

    public String print() {
        String output = "";
        for(int i =0; i< size(); i++){
            if( i == size() - 1){
                output += get(i) + "\n";
            }
            else{
                output += get(i) + ", ";
            }
        }
        //output += "";

        return output;
    }
}

