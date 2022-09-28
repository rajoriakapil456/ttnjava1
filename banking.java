import java.util.*;
class InsufficientAmountException extends Exception 
{
  public InsufficientAmountException(String message)
  {
     super(message);
  }
}
class Bank
{
   private String accn, name,bn;
   private double bal;
   Scanner sc = new Scanner(System.in);
   
   public void getDetails()
   {
          System.out.print("Select your bank(SBI/BOI/ICICI): ");
          bn=sc.nextLine();
          System.out.print("Set your account no. : ");
          accn=sc.nextLine();
          System.out.print("Your name : ");
          name=sc.nextLine();
          System.out.print("Initial balance: ");
          bal = sc.nextDouble();
          sc.nextLine();
          System.out.print("\n");
   }
   public void show()
   {
       System.out.printf("%5s %10s %10s %8s", bn, accn, name, bal);
       System.out.println();
   }
   public void deposit()
   {
        double amt;
        System.out.print("Enter the amout you want to deposit: ");
        amt = sc.nextDouble();
        bal+=amt;
        System.out.println("Amount Deposited Successfully!");
   }
   public void withdraw() throws InsufficientAmountException
   {
       double amt;
       System.out.print("Enter the amout you want to withdraw: ");
       amt = sc.nextDouble();
       if(bal>=amt)
       {
          bal-=amt;
          System.out.println("Amount Deducted Successfully!");
       }
       else
       { 
            throw new InsufficientAmountException("Insufficient Balance...please try again!!!");
       }
   }
   boolean search(String s)
   {
       if(s.equals(accn))
       {
           return (true);
       }
       return (false);
   }
}

class test
{
  public static void main(String[] args)
  {
      Scanner sc = new Scanner(System.in);
      int op;
      System.out.print("Enter the number of customers: ");
      int n = sc.nextInt();
      sc.nextLine();
      Bank b[]=new Bank[n];
      for(int i=0;i<b.length;i++)
      {
          b[i]=new Bank();
          System.out.println("\nEnter customer "+(i+1)+" details...");
          b[i].getDetails();
      }
      do
      {
         System.out.println("\n****Menu****");
         System.out.println("1. Display all");
         System.out.println("2. Deposit");
         System.out.println("3. Withdrawl");
         System.out.println("4. Exit\n");
         op=sc.nextInt();
         sc.nextLine();
         switch(op)
         {
            case 1:
            System.out.printf("%5s %10s %10s %8s", "Bank", "Account no.", "Name", "Balance"); 
            System.out.println();
            for(int j=0;j<b.length;j++)
            {
            b[j].show();
            }
            break;
            case 2:
            System.out.print("Enter your account no. ");
            String a=sc.nextLine();
            boolean f=false;
            for(int i=0;i<b.length;i++)
            {
                f=b[i].search(a);
                if(f)
                {
                   b[i].deposit();
                   break;
                }
            }
            if(!f)
            {
            System.out.println("Enter a valid account number...");
            }
            break;
            case 3:
            System.out.print("Enter your account no. ");
            String a2=sc.nextLine();
            boolean f2=false;
            for(int i=0;i<b.length;i++)
            {
                f2=b[i].search(a2);
                if(f2)
                {
                   try{
                   b[i].withdraw();}
                   catch(InsufficientAmountException e)
                   {
                      System.out.println(e);
                   }
                   break;
                }
            }
            if(!f2)
            {
            System.out.println("Enter a valid account number...");
            }
            break;
            case 4:
            System.exit(0);
            break;
            default:
            System.out.println("Enter a valid number.....");
            break;
         }
      }
      while(true);
  }
}
