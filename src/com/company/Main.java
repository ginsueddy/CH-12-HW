package com.company;

/*  num1: Recursion are methods that repeat itself. However, it does not repeat itself like in a for loop
    it calls the same method within the method in order to loop repeat itself.

    num2: Base cases are the first case that a method can have. They prevent the method from infinitely calling itself.
    The recursive case is the case where the method calls itself in order to go a layer down.

    num3: the output would look like:
        a. 1
        b. 1, 2
        c. 1, 3
        d. 1, 2, 4
        e. 1, 2, 4, 8, 16
        f. 1, 3, 7, 15, 30
        e. 1, 3, 6, 12, 25, 50, 100

    num4: the output would look like:
        a. 113
        b. 140, 70
        c. 168, 84, 42
        d. 120, 60, 30
        e. 160, 80, 40, 20, 10

    num5: the output would look like:
        a. *
        b. [*]
        c. ([*])
        d. ([([*])])
        e. [([([*])])])]

    num6: the output would look like:
        a. 4
        b. 8, 4, 8
        c. 16, 8, 16
        d. 12, 8, 4, 8, 12
        e. 12, 9, 6, 3, 6, 9,12

    num8: A call stack is the place where the information of your methods that have been called are stored.
    Happens with recursion

    num9: The method would not reverse the order of the lines

    num10: An infinite recursion would happen since the method would keep getting called over and over.

    num11: There is no base case therefore, the method will be recursively called infinitely.

    num12: One of the methods are more efficient because it requires less recursive calls than the other.

    num13: The output would look like:
        a. 6
        b. 4
        c. 7
        d. 0
        e. 1

    num14: The output would look like
        a. 57
        b. 1029
        c. -74
        d. 2438
        e. 132483

    num15: The output would look like:
        a. 7
        b. 6
        c. 4
        d. 10
        e. 5

    num17: The if statement needs to be n < 10 not n > 10

    num18: Throw a new parameter error or create a private helper method for the other parameter
 */

public class Main {

    public static void main(String[] args) {
        missionariesAndCannibals(3,3,1);
        System.out.println();
        System.out.println("*****");
        System.out.println();
        selfCheckNum19();
    }

    public static void selfCheckNum7() {
        String str = "hello";
        doubleReverse(str);
        System.out.println();
    }

    public static void selfCheckNum16(){
        System.out.println(factorial(5));
    }

    public static int factorial(int n){
        if(n == 1){
            return n;
        }
        return n * factorial(n-1);
    }

    public static void selfCheckNum19(){
        System.out.println(fibonacci(10));
    }
    public static int fibonacci(int n){
        if(n <= 2){
            return 1;
        }
        else {
            return fibonacci(n, 3,1,1);
        }
    }

    private static int fibonacci(int n, int i, int previous, int current){
        if(n == i){
            return previous + current;
        }
        else{
            return fibonacci(n, i + 1, current,previous + current);
        }
    }

    public static void doubleReverse(String s){
        if(s.length() > 0){
            System.out.print(s.charAt(s.length() - 1));
            System.out.print(s.charAt(s.length() - 1));
            doubleReverse(s.substring(0, s.length() -1));
        }
    }

    public static void num2(){
        writeNums(5);
        System.out.println();
    }

    public static void writeNums (int n){
        if(n > 0){
            writeNums(n - 1);
            System.out.print(n + ", ");
        }
    }

    public static void num6 (){
        writeSquares(8);
    }

    public static void writeSquares (int n){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        else if(n == 1){
            System.out.println(1);
        }
        else{
            if((n * n) % 2 == 0){
                writeSquares(n-1);
                System.out.println(n * n);
            }
            else{
                System.out.println(n * n);
                writeSquares(n-1);
            }
        }
    }

    public static void num8 (){
        System.out.println(multiplyEvens(4));
    }

    public static int multiplyEvens(int n){
        if(n <= 0){
            throw new IllegalArgumentException();
        }
        else {
            if(n == 1){
                return n * 2;
            }
            return n * 2 * multiplyEvens(n - 1);
        }
    }

    public static void num9(){
        System.out.println(sumTo(2));
    }

    public static double sumTo(int n){
        if(n < 0){
            throw new IllegalArgumentException();
        }
        else if(n == 0){
            return 0.0;
        }
        else{
            if(n == 1){
                return 1;
            }
            else {
                return (1 / (double) n) + (1/ sumTo(n -1));
            }
        }
    }

    public static void num10(){
        System.out.println(digitMatch(1072503891, 62530841));
    }

    public static int digitMatch(int n1, int n2){
        if(n1 < 0 || n2 < 0){
            throw new IllegalArgumentException();
        }
        else if(n1 < 10 || n2 < 10){
            if(n1 % 10 == n2 % 10){
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(n1 % 10 != n2 % 10){
            return digitMatch(n1/10, n2/10);
        }
        else {
            return 1 + digitMatch(n1/10, n2/10);
        }

    }

    public static void missionariesAndCannibals(int missionaries, int cannibals, int boat){
        if(missionaries == 0 && cannibals == 0 && boat == 0){
            mZeroCZero();
            boatLeft();
        }
        else if(boat == 1){
            if(missionaries == 3 && cannibals == 3){
                mThreeCThree();
            }
            else if(missionaries == 3 && cannibals == 2){
                mThreeCTwo();
            }
            else if(missionaries == 3 && cannibals == 1){
                mThreeCOne();
            }
            else if(missionaries == 2 && cannibals == 2){
                mTwoCTwo();
            }
            else if(missionaries == 0 && cannibals == 3){
                mZeroCThree();
            }
            else if(missionaries == 0 && cannibals == 2){
                mZeroCTwo();
            }
            boatRight();
            System.out.println();

            if(missionaries -2 >= cannibals || missionaries - 2 == 0){
                missionariesAndCannibals(missionaries - 2, cannibals, 0);
            }
            else {
                missionariesAndCannibals(missionaries, cannibals - 2, 0);
            }
        }
        else if(boat == 0){
            if(missionaries == 3 && cannibals == 1){
                mThreeCOne();
            }
            else if(missionaries == 3 && cannibals == 0){
                mThreeCZero();
            }
            else if(missionaries == 1 && cannibals == 1){
                mOneCOne();
            }
            else if(missionaries == 0 && cannibals == 2){
                mZeroCTwo();
            }
            else if(missionaries == 0 && cannibals == 1){
                mZeroCOne();
            }
            boatLeft();
            System.out.println();

            if(missionaries >= cannibals + 1 || missionaries == 0){
                missionariesAndCannibals(missionaries, cannibals + 1, 1);
            }
            else if(missionaries <= cannibals + 1 && missionaries != 1){
                missionariesAndCannibals(missionaries + 1, cannibals, 1);
            }
            else {
                missionariesAndCannibals(missionaries + 1, cannibals + 1, 1);
            }
        }
    }
    public static void boatRight(){
        System.out.println("-----------________________| B |-----------");
    }
    public static void boatLeft(){
        System.out.println("-----------| B |________________-----------");
    }
    public static void mThreeCThree(){
        System.out.println("                                M M M C C C");
    }
    public static void mThreeCOne(){
        System.out.println("        C C                     M M M     C");
    }
    public static void mThreeCTwo(){
        System.out.println("          C                     M M M   C C");
    }
    public static void mThreeCZero(){
        System.out.println("      C C C                     M M M      ");
    }
    public static void mOneCOne(){
        System.out.println("  M M   C C                     M         C");
    }
    public static void mTwoCTwo(){
        System.out.println("    M     C                     M M     C C");
    }
    public static void mZeroCTwo(){
        System.out.println("M M M     C                             C C");
    }
    public static void mZeroCThree(){
        System.out.println("M M M                                 C C C");
    }
    public static void mZeroCOne(){
        System.out.println("M M M   C C                               C");
    }
    public static void mZeroCZero (){
        System.out.println("M M M C C C                                ");
    }
}
