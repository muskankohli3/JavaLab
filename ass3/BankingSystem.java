import java.util.*;

class InsufficientBalanceException extends Exception{
  public InsufficientBalanceException(String message){
    super(message);
  }
}
class InvalidAmountException extends Exception{
  public InvalidAmountException(String message){
    super(message);
  }
}
class AccountNotFoundException extends Exception{
  public AccountNotFoundException(String message){
    super(message);
  }
}

class BankAccount{
  int accNum;
  String name;
  double balance;
  
  public BankAccount(int accNum,String name,double balance){
    this.accNum = accNum;
    this.name = name;
    this.balance = balance;
  }

  void deposit(double amount) throws InvalidAmountException{
    if(amount<=0) throw new InvalidAmountException("Invalid amount");
    balance+=amount;
    System.out.println("Deposit succesfull. Current balance = "+balance);
  }

  void withdraw(double amount) throws InvalidAmountException,InsufficientBalanceException{
    if(amount<=0) throw new InvalidAmountException("Invalid amount");
    if(amount>balance) throw new InsufficientBalanceException("Insufficient balance");
    balance-=amount;
    System.out.println("Withdrawl succesfull. Current balance = "+balance);
  }
}

public class BankingSystem{
  static BankAccount findAcc(BankAccount acc, int accountN) throws AccountNotFoundException{
    if(acc.accNum != accountN){
      throw new AccountNotFoundException("Account not found");
    }
    return acc;
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    BankAccount acc = new BankAccount(10001,"Muskan",10000);
    try{
      System.out.println("Enter account number: ");
      int accountN = sc.nextInt();
      BankAccount foundAcc = findAcc(acc,accountN);
      System.out.println("Enter deposit amount: ");
      double dep = sc.nextDouble();
      foundAcc.deposit(dep);
      System.out.println("Enter withdrawl amount: ");
      double with = sc.nextDouble();
      foundAcc.withdraw(with);
    }
    catch(AccountNotFoundException e){
      System.out.println("Error: "+e.getMessage());
    }
    catch(InvalidAmountException e){
      System.out.println("Error: "+e.getMessage());
    }
    catch(InsufficientBalanceException e){
      System.out.println("Error: "+e.getMessage());
    }
  }
}