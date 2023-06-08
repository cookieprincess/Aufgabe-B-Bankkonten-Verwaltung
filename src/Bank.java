//student: uwxkz
import java.util.Arrays;
public class Bank{
    static int bankCode; //bankleitzahl
    static BankAccount[] accounts = new BankAccount[8];
    
    public Bank(int bankCode){ //creating a constructor
    this.bankCode = bankCode;
    }
    
    public static int createAccount(){
        BankAccount[] newAccountsArray = new BankAccount[accounts.length];
        for(int i=0; i<accounts.length; i++){
            if(accounts[i] == null){
                accounts[i] = new BankAccount(bankCode, i); //add an account when there is space (i.e null) available in array
                return bankCode;
            }
            else if(i==accounts.length - 1 && accounts[i]!= null){//else if we reach the end of the arr and there is no space
                newAccountsArray = Arrays.copyOf(accounts, accounts.length * 2); //we transfer all the content onto a new arr        
            }
        }
        
        for(int i=0; i<newAccountsArray.length; i++){
            if(newAccountsArray[i]==null){//once we find space in the new array, we add our input
                newAccountsArray[i] = new BankAccount(bankCode, i);
                return bankCode;
            }
        }
        return bankCode;
    }

    public static boolean removeAccount(int accountNumber){
        if(accounts.length - 1 < accountNumber){ //since the accounts are in sequence and the accountnumber corresponds to i
            return false; //if the highest i is less than the accountnumber then the account is not in the array
        }
        else{
            BankAccount[] newAccountsArray = new BankAccount[accounts.length];
            for(int i=0; i<accounts.length; i++){
                if(i==accountNumber){
                    i = i + 1; //skip over the accountnumber as we're copying the content of the old array
                }
                else{
                    newAccountsArray[i] = accounts[i];
                    return true;
                }
            }
            if(newAccountsArray[newAccountsArray.length/4]==null && newAccountsArray.length/2 >= 8){
                //if quarter of the array is null (i.e. unoccupied) and if we were to half the length
                //of the array and where the length is still greater than or equal to 9
                BankAccount[] newAccountsArray2 = new BankAccount[newAccountsArray.length/2];
                //then we create a new array that is half of our old one
                for(int j=0; j<newAccountsArray.length; j++){
                    newAccountsArray2[j] = newAccountsArray[j]; //and we copy the content of the old array
                }
                
            }
        }
    return true;    
    }
    
    public static boolean containsAccount(int accountNumber){
    if(accounts.length >= accountNumber){//if the length of the array is greater than accountnumber then it is here
        return true;
    }
    else{
        return false;
    }
    }
    
    public static boolean internalTransfer(int fromAccountNumber, int toAccount, int amount){
    int transfer = accounts[fromAccountNumber].balance - amount;
    
    if(accounts.length >= fromAccountNumber && accounts.length >= toAccount && transfer > 0){
        accounts[fromAccountNumber].transfer(accounts[fromAccountNumber], amount); //accessing the transfer method 
        accounts[toAccount].deposit(amount); //accessing the deposit method
        return true;
    }
    else{
        return false;
    }
    }
    
    public static int length(){
    return accounts.length;    
    }
    
    public static int size(){
    int count=0;
    for(int i=0; i<accounts.length; i++){
        if(accounts[i]!=null){ //if the content of the array is not null (i.e. occupied) then we increment on count
            count++;
        }
        else{
            
        }
    }
    return count;
    }
    
    public static BankAccount getAccount(int index){
    for(int i=0; i<accounts.length; i++){
        if(i == index){//if we detect our index
            return accounts[i];
        }
        else{
            return null;
        }
    }
    return accounts[index];
    }


}
