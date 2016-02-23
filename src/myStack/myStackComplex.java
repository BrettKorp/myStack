package myStack;


//**********************************************************************
//myStackComplex
//this object extends from the abstract class generic stack
class myStackComplex extends myStackGeneric<complex>{

    protected complex zero(){
        return new complex(0, 0);
    }

    @Override
    public complex addition(complex obj1, complex obj2) {
        return obj1.plus(obj2);
    }

    @Override
    public complex subtract(complex obj1, complex obj2) {
        return obj1.minus(obj2);
    }

    @Override
    public complex multiply(complex obj1, complex obj2) {
        return obj1.multiply(obj2);
    }

    @Override
    public complex newElement(String input) {
        return new complex(input);
    }
}

