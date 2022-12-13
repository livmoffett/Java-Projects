// Olivia Moffett
// 2.01.2022
// CSE 142 Section AF
// TA: Andrew Zhang
// Budgeter
// Will take user unput of income and spending and show the 
//difference in saved versus spent

import java.util.*;

public class Budgeter {
   public static final int DAYS_IN_MONTH = 31;
   
   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      
      startLines();
      double budgetIncome = budgetItem(console, "income");
      int days = daysMonth(console);
      double budgetExpenses = budgetItem(console, "expense");
      accountBalance(budgetIncome, budgetExpenses, days);
      finalStatement(budgetIncome, budgetExpenses);
   }
   // Introduction to the budgeting system
   public static void startLines(){
      System.out.println("This program asks for your monthly income and");
      System.out.println("expenses, then tells you your net monthly income.");
      System.out.println();
   }
   // Will read user input of income and expense totals
   public static double budgetItem(Scanner console, String budget) {
      System.out.print("How many categories of " + budget + "? ");
      int numAccounts = console.nextInt();
      
      double accountTotal = 0;
      for(int i = 1; i <= numAccounts; i++) {
         System.out.print("    Next " + budget + " amount?");
         System.out.print(" $");
         double amount = console.nextDouble();
         accountTotal += amount;
      }
   
      System.out.println();
        
      return accountTotal;  
   }
   //Takes user input to calculate expenses 
   public static int daysMonth(Scanner console) {
      System.out.print("Enter 1) monthly or 2) daily expenses? ");
      int days = console.nextInt();
      
      return days;
   }
    //Calculates total in income and expense accounts
   public static void accountBalance(double budgetIncome, double budgetExpenses, int days) {
    
      System.out.printf("Total income = $" + budgetIncome +  "($%.2f/day)", budgetIncome/DAYS_IN_MONTH);
      
      System.out.println();
      
      if(days == 1) {
         System.out.printf("Total expenses = $" + budgetExpenses + " ($%f/day)", budgetExpenses/DAYS_IN_MONTH);
      }
      else if(days == 2) {
         System.out.printf("Total expenses = $"+ budgetExpenses*DAYS_IN_MONTH + " ($%f/day)", budgetExpenses);
      }
            
      System.out.println();
      System.out.println();
       
   }
   //Will show what you earned compared to what you spent and print a 
   //line stating whether you are a spender or saver and
   //prints a custom message as well
   public static double finalStatement(double budgetIncome, double budgetExpenses) {
    
      double netIncome = budgetIncome - budgetExpenses;
      if(netIncome > 250){
         System.out.println("You earned $" + netIncome + " more than you spent this month.");
         System.out.println("You're a big saver.");
         System.out.println("With this kind of saving you can buy a whole house for your dog");
         System.out.println("Or your cat, whatever your prefrence.");
      }
      else if(netIncome > 0 && netIncome <= 250) {
         System.out.println("You earned $" + netIncome + " more than you spent this month.");
         System.out.println("You're a saver.");
         System.out.println("If you start saving a bit more maybe you could eventually buy a pet");
         
      }
      
      else if(netIncome <= 0 && netIncome >= -250) {
         System.out.println("You spent $" + -netIncome + " more than you earned this month.");
         System.out.println("You're a spender.");
         System.out.println("Don't you want to start saving up those pay checks");
         System.out.println(" to buy as many puppies and kittens as you want?");
         System.out.println("You got this!");
      }
         
      return netIncome;
         
   }
    
}