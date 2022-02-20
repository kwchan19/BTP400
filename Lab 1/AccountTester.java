public class AccountTester {
    public static void main(String[] args){
        Account acc1, acc2, acc3, acc4;

       /* acc1 = new Account();

        System.out.println(acc1);

        acc2 = new  Account(null, null, -1);

        System.out.println(acc2);

        acc3 = new Account("Kevin Chan","TD12345",1000);

        System.out.println(acc3);
        
        */


        acc1 = new Account("Kevin Chan","TD12345",1000);

        acc2 = new Account("Kevin Chan","TD12345",1000);

        acc3 = new Account("Kevin Lam", "TD12345", 1000);

        acc4 = null;

        System.out.println("When two objects are equal:");
        System.out.println(acc1.equals(acc2) + "\n");
        
    
        System.out.println("False when two Account objects are not equal:");
        System.out.println(acc1.equals(acc3)+ "\n");
        
        System.out.println("false when the null reference is passed as the actual parameter:");
        System.out.println(acc1.equals(acc4)+ "\n");
        

    }
}