public class BankAccount { //represents an account
static int accountNumber; //kontonummer
static int bankCode; //bankleitzahl
static int balance; //kontostand

public BankAccount(int bankCode, int accountNumber){ //creating a constructor
    this.bankCode = bankCode;
    this.accountNumber = accountNumber;
    this.balance = 0;
}

public static boolean withdraw(int amount){
    int payout = balance - amount;
    if(payout < 0){ //if the payout is negative, it will not be executed
        return false;
    }
    else{
        return true;
    }
}

public static void deposit(int amount){
    int deposit = amount + balance;
}

public static boolean transfer(BankAccount account, int amount){
    int transfer = account.balance - amount; //accessing the account's balance and deducting from it
    
    if(transfer < 0){ //if it is negative it will not be executed
        return false;
    }
    else{
        return true;
    }
}
}