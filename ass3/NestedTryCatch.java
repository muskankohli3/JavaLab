public class NestedTryCatch{
  public static void main(String[] args){
    try{
      System.out.println("Outer try block start");
      try{
        System.out.println("Inner try block start");
        int a = 10;
        int b = 0;
        int c = a/b;
        System.out.println("Ans = "+c);
      }
      catch(ArithmeticException e){
        System.out.println("Inner catch: Arithmetic Exception");
      }
      int[] d = {1,2,3,4,5};
      System.out.println("At index 5 = "+d[5]);
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("Outer catch: Array out of bounds Exception");
    }
  }
}