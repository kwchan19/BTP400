public class ArrayTester {
    public static void main(String[] args){
        Account[] accArray;
        Account[] accArray2;

//accArray2 is the new array that will be the final result

        accArray2 = new Account[7];
        accArray = new Account[7];

        accArray[0] = new Account("Peter Liu", "A12345", 5000);
        accArray[1] = new Account("Peter Liu", "A67890", 6000);
        accArray[2] = new Account("Abraham Lincoln", "Z6789", 7777);
        accArray[3] = new Account("Peter Liu", "A12345", 5000);
        accArray[4] = new Account("Kevin Chan", "E3333", 9000);
        accArray[5] = new Account("Abraham Lincoln", "Z6789", 7777);
        accArray[6] = new Account("Abraham Lincoln", "Z6789", 7777);

        int counts;

        int counter = 0;

//For loop to find duplicates and remove it.
        for(int i = 0; i < accArray.length; i++) {
            boolean flag  = false;
            int count = 0;
            for(int j = 0; j < i; j++) {
                if (accArray[i].equals(accArray[j]) == true) {
                    flag = true;
                    break;   
                }
            }
            if(!flag){
                accArray2[counter++] = accArray[i];
            }

        }

 //Print out the accounts. For loop for counting the duplicates

        System.out.println("Total Number of Accounts: " + accArray.length);

        for(int i = 0; i < counter; i++) {
            counts = 0;
            for(int j = 0; j < accArray.length; j++){
                if(accArray2[i].equals(accArray[j]) == true){
                    counts++;
                }
            }
            System.out.println((i+1) + ": " + accArray2[i] + " " + counts);
        }
    }
}