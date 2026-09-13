public class CommonExceptions{
  public static void main(String[] args){

    try{
      int a = 100;
      int b = 0;
      int c = a/b;
      System.out.println("Sum = "+c);
    }
    catch(ArithmeticException e){
      System.out.println("ArithmeticException");
    }

    try{
      String d = null;
      System.out.println("String length = "+d.length());
    }
    catch(NullPointerException e){
      System.out.println("NullPointerException");
    }

    try{
      int[] f = {1,2,3};
      System.out.println("At index 5 = "+f[5]);
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("ArrayIndexOutOfBoundsException");
    }

    try{
      String g = "hello";
      int h = Integer.parseInt(g);
      System.out.println("Ans = "+h);
    }
    catch(NumberFormatException e){
      System.out.println("NumberFormatException");
    }
  }
}