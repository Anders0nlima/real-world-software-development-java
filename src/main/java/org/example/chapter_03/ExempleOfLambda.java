package org.example.chapter_03;

interface MathematicalOperation{
    int calculate(int a, int b);
}

public class ExempleOfLambda {
    //-------------------------------------------------------------------
    //normal using
    public static void main(String[] args) {
        MathematicalOperation sum = new MathematicalOperation() {
            @Override
            public int calculate(int a, int b) {
                return a + b;
            }
        };

        System.out.println(sum.calculate(4, 6));
    //--------------------------------------------------------------------
    //using lambda
        MathematicalOperation sumLambda = (a, b) -> a + b;
        System.out.println(sumLambda.calculate(4, 6));
    }
}
