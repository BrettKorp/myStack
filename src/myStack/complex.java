package myStack;

//**********************************************************************

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Complex Num Object

class complex implements java.lang.Comparable {
    private double real;    //real number
    private double imag;    //imaginary number

    complex(){
        real = 0;
        imag = 0;
    }
    /*
     * @param r : real number
     * @param i : imaginary number
     */
    complex( double r, double i ){
        this.setcomplex(r, i);
    }

    /*
     * @param sq : a number to take the square root of
     */
    complex( double sq ){

        if(sq < 0){
            imag = Math.sqrt( (sq * -1) );
            real = 0;
        } else{
            real = Math.sqrt( sq );
            imag = 0;
        }
    }

    /*
     * @param word: the real and imaginary numbers to associate with the class
     * as a string
     */
    complex( String word ){
        this.setMyComplex( word );
    }

    /*
     * @param word: the real and imaginary numbers to associate with the class
     * as a string
     * @return this class object
     */
    complex setMyComplex( String word ) throws InputMismatchException{

        if(word.matches("3.5+i")){
            System.out.println("here");
        }
        //general cases
        Pattern generalPattern = Pattern.compile
        ("(?<real>-?\\d*[.]?\\d+)??((?<imag>[+-]?\\d*[.]?\\d+)i)?$");
        Matcher generalMatcher = generalPattern.matcher(word);

         //special cases
        Pattern specialPattern = Pattern.compile( "(?<real>-?\\d*[.]?\\d*)??((?<imag>[+-]?\\d*)i)?$");
        Matcher specialMatcher = specialPattern.matcher(word);

        if(generalMatcher.matches()){
            try{
                String r = generalMatcher.group( "real");
                String i = generalMatcher.group( "imag" );

                real = ( r != (String)null ? Double.parseDouble( r ): 0 );
                imag = ( i != (String)null ? Double.parseDouble( i ): 0 );
            }
            catch(Exception e){}
        }
        else if(specialMatcher.matches()) {
            try{
                String r = specialMatcher.group( "real");
                String i = specialMatcher.group( "imag" );

                real = ( r != (String)null ? Double.parseDouble( r ): 0 );
                if(i.matches("|-|\\+|1")){
                    imag = ( i.matches("-") ? -1: 1);
                }
                else{
                    imag = ( i != (String)null ? Double.parseDouble( i ): 0 );
                } //end else
            } //end try
            catch(Exception e){}
        } // end else if
        else{
            throw new InputMismatchException("Unknown Complex word->" + word);
        }
        return this;
    } //end method

    void clearNums(){
        real = 0;
        imag = 0;
    }

    complex setcomplex( double r, double i ){
        real = r;
        imag = i;
        return this;
    }

     // @return double real : real number attribute
    double getReal(){
        return real;
    }

     // @return double image: imaginary number attribute
    double getImaginary(){
        return imag;
    }

    complex plus( complex c){
        return complex.plus(this, c);
    }
    public static complex plus(complex c1, complex c2){
        double realSum = c1.real + c2.real;
        double imagSum = c1.imag + c2.imag;
        return new complex(realSum, imagSum);
    }


    complex multiply( complex c){
        return complex.multiply(this, c);
    }
    public static complex multiply( complex c1, complex c2){
        double realNum;
        double imagNum;
        double tempNum;

        realNum = c1.real * c2.real;
        imagNum = ((c1.real * c2.imag) + (c1.imag * c2.real));
        tempNum = ((c1.imag * c2.imag) * -1);
        realNum = realNum + tempNum;
        return new complex(realNum, imagNum);
    }


    complex minus( complex c){
        return complex.minus(this, c);
    }
    public static complex minus(complex c1, complex c2){
        double realDiff = c1.real - c2.real;
        double imagDiff = c1.imag - c2.imag;
        return new complex(realDiff, imagDiff);
    }

    @Override
    public boolean equals( Object c ){
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
    @Override
    public String toString(){
        String output = null;   //declare output variable outside of scope

        String realNum  = String.format("%,.2f", real); //format real number
        String imagNum  = String.format("%,.2f", imag); //format imaginary

        //if imaginary is positive, we use + else the negative comes with imagNum
        String operator = ( imag > 0 ? "+" : "");

        //select based on the values of imag and real
        if(imag == 0){
            //no imag number
            output = realNum;
        }
        else if(real == 0){
            //no real number - throw an i in there
            output = imagNum + "i";
        }
        else{
            //default case
            output = realNum + operator + imagNum + "i";
        }

        //string that we built is returned
        return (output);
    }

    //NOTE: this method closes the scanner passed in
    public String readInput(java.util.Scanner in, boolean fOutput) {

        String output = "";   //string variable outside of scope

        //loop over scanner until eof
        while(in.hasNext()){
            try{
                //set my Complex and get the results here
                //concat them into output with a newline character
                complex c = this.setMyComplex(in.next());
                output += c.toString() + "\n";
            }
            catch(Exception e){
                //note: setMyComplex() throws an InputMismatchException
                //i was lazy and decided to catch everything
                //we concat the message we threw inside of setMyComplex()
                //into the output string
                output += e.getMessage() + "\n";
            }
        } //end while eof

        //close the scanner
        in.close();

        //if fOutput was passed in as true, then output string to standard
        //output
        if(fOutput)
            System.out.println(output);

        //output is returned eitherway
        return output;
    }
}