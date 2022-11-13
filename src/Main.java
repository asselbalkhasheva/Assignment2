import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char answer = 'Y';

        Change.HardCode();
        System.out.println("Recommendation: Please enter at least 10 records to test the program");

//        while (answer != 'N') {
//            GetInput();
//            System.out.println("Do you have more person to enter? Y/N");
//            answer = sc.next().charAt(0);
//        }
        Change.CalculateCoinsForAllPeople();
        int option = 0;
        while(option >= 0 && option < 7) {
            option = Menu();

            switch (option) {
                case 1 -> Change.optionA();
                case 2 -> Change.optionB();
                case 3 -> Change.optionC();
                case 4 -> Change.optionD();
                case 5 -> Change.optionE();
                case 6 -> option = -1;
            }
        }
    }

    public static int Menu(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu: ");
        System.out.println("1. Enter a name and display change to be given for each denomination");
        System.out.println("2. Find the name with the largest amount and display change to be given for each denomination");
        System.out.println("3. Find the name with the smallest amount and display change to be given for each denomination");
        System.out.println("4. Calculate and display the total number of coins for each denomination");
        System.out.println("5. Calculate and display the total amount (i.e. NOT the total number of coins) for the sum of all denominations");
        System.out.println("6. Exit");

        System.out.println("Choose one of the options: ");
        return sc.nextInt();
    }

    public static void GetInput() {
        Change person = new Change();

        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the name of the person: ");
        person.SetName(sc.nextLine());

        System.out.println("Please enter the coin value for this person: ");
        person.SetCoin(sc.nextInt());

        Change.addPerson(person);
    }


}