import java.util.*;

class InvalidMarksException extends Exception{
  InvalidMarksException(String message){
    super(message);
  }
}

public class StudentResult{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    try{
      System.out.println("Enter number of subjects: ");
      int subs = sc.nextInt();
      int total = 0;
      for(int i=1;i<=subs;i++){
        System.out.println("Enter marks of subject "+i+": ");
        int marks = sc.nextInt();
        if(marks<0 || marks>100){
          throw new InvalidMarksException("Invalid marks enetered.");
        }
        total += marks;
      }
      double perc = (double) total/subs;
      char grade;
      if(perc >= 90) grade = 'A';
      else if(perc >= 80) grade = 'B';
      else if(perc >= 70) grade = 'C';
      else if(perc >= 60) grade = 'D';
      else grade = 'F';
      System.out.println("\n----- RESULT -----");
      System.out.println("Total = " + total);
      System.out.println("Percentage = " + perc + "%");
      System.out.println("Grade = " + grade);
    }
    catch(InvalidMarksException e){
      System.out.println("Error: " + e.getMessage());
    }
  }
}