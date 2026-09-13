import java.util.*;

class InvalidUsernameException extends Exception{
  public InvalidUsernameException(String message){
    super(message);
  }
}
class InvalidPasswordException extends Exception{
  public InvalidPasswordException(String message){
    super(message);
  }
}
class AccountLockedException extends Exception{
  public AccountLockedException(String message){
    super(message);
  }
}

public class LoginSystem{
  static String correctUsername = "admin";
  static String correctPassword = "admin@123";
  static int failedAttempts = 0;
  static final int maxAttempts = 3;

  static void login(String username, String password) throws InvalidUsernameException,InvalidPasswordException,AccountLockedException{
    if(failedAttempts >= maxAttempts){
      throw new AccountLockedException("Account locked");
    }
    if(!username.equals(correctUsername)){
      failedAttempts++;
      throw new InvalidUsernameException("Invalid username");
    }
    if(!password.equals(correctPassword)){
      failedAttempts++;
      if(failedAttempts >= maxAttempts){
        throw new AccountLockedException("Account locked");
      }
      throw new InvalidPasswordException("Invalid password");
    }
    failedAttempts = 0;
    System.out.println("Login successful!");
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while(failedAttempts< maxAttempts){
      try{
        System.out.println("Enter username: ");
        String username = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();
        login(username,password);
        break;
      }
      catch(InvalidUsernameException e){
        System.out.println("Error: " + e.getMessage());
        System.out.println("Attempts remaining: " +(maxAttempts - failedAttempts));
      }
      catch(InvalidPasswordException e){
        System.out.println("Error: " + e.getMessage());
        System.out.println("Attempts remaining: " +(maxAttempts - failedAttempts));
      }
      catch(AccountLockedException e){
        System.out.println("Error: " + e.getMessage());
      }
      finally{
        System.out.println("Login attemp completed");
      }
    }
  }
}