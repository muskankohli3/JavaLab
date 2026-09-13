import java.util.*;

public class Calculator{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    try{
      System.out.println("Enter number 1: ");
      int a = sc.nextInt();
      System.out.println("Enter number 2: ");
      int b = sc.nextInt();
      System.out.println("Enter opertation: ");
      String op = sc.next();
      switch(op){
        case "+":
          int sum = a+b;
          System.out.println("Sum = "+sum);
          break;
        case "-":
          int dif = a-b;
          System.out.println("Difference = "+dif);
          break;
        case "*":
          int mul = a*b;
          System.out.println("Multiplication = "+mul);
          break;
        case "/":
          if(b==0) throw new ArithmeticException();
          double div = (double)a/b;
          System.out.println("Division = "+div);
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
    catch(InputMismatchException e){
      System.out.println("Invalid numeric input");
    }
    catch(ArithmeticException e){
      System.out.println("Divide by 0");
    }
    catch(IllegalArgumentException e){
      System.out.println("Invalid operator");
    }
  }
}