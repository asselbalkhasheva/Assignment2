import java.util.Scanner;
public class Change {
    private static Change[] people = new Change[10];
    private String name;
    private int coin;
    private static int[] dp = {100, 50, 25, 10, 5};
    private int[] change = {0, 0, 0, 0, 0};

    Change() {
        name = "default";
        coin = 5;
    }

    Change(String n, int c) {
        name = n;
        SetCoin(c);
    }

    public void SetName(String name) {
        this.name = name;
    }

    public void SetCoin(int coin) {
//        int remaining = coin % 5;
//        if(remaining > 2){
//            coin += 5 - remaining;
//        }
//        else {
//            coin -= remaining;
//        }
        this.coin = coin;
    }

    public String GetName() {
        return name;
    }

    public int GetCoin() {
        return coin;
    }

    public static void addPerson(Change person) {
        int count = 0;
        for (int i = 0; i < Change.people.length; i++) {
            if (Change.people[i] != null) {
                count++;
            }
        }

        for (Change element : people) {
            if (element != null && element.GetName().equals(person.GetName())) {
                element.SetCoin(element.GetCoin() + person.GetCoin());
                return;
            }
        }
        Change.people[count] = person;
    }

    public static void optionA() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = sc.nextLine();

        Change person = Change.FindPersonByName(name);
        System.out.println("The coin amount for " + person.GetName() + ": " + person.GetCoin());

        if (person != null) {
            person.printCoins();
        } else {
            System.out.println("Not Found");
        }
    }

    public static Change FindPersonByName(String name) {
        for (Change item : people) {
            if (item.GetName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public void countCoin() {
        int remaining = coin % 5;
        if(remaining > 2){
            coin += 5 - remaining;
        }
        else {
            coin -= remaining;
        }

        int amount = coin;

        for (int i = 0; i < Change.dp.length; i++) {
            while (amount - Change.dp[i] >= 0) {
                amount -= Change.dp[i];
                this.change[i] += 1;
            }
        }


    }

    public void printCoins() {
        for(int i = 0; i < change.length; i++){
            if(change[i] > 0){
                System.out.println(dp[i] + " cents: " + change[i]);
            }
        }
    }

    public static void optionB() {
        Change person = Change.people[0];

        for (Change item : people) {
            if (item != null && item.GetCoin() > person.GetCoin()) {
                person = item;
            }
        }

        System.out.println(person.GetName());
        System.out.println("The coin amount for " + person.GetName() + ": " + person.GetCoin());
        person.printCoins();
    }

    public static void optionC() {
        Change person = Change.people[0];

        for (Change item : people) {
            if (item != null && item.GetCoin() < person.GetCoin()) {
                person = item;
            }
        }

        System.out.println(person.GetName());
        person.printCoins();
    }

    public static void optionD() {
        for (Change item : people) {
            if (item != null) {

                int totalCoins = 0;

                for (int coin : item.change) {
                    totalCoins += coin;
                }
                System.out.println("The person " + item.GetName() + " the number of coins is " + totalCoins);
            }
        }
    }

    public static void optionE() {
        int totalAmount = 0;
        for (Change item : people) {
            if (item != null) {
                totalAmount += item.GetCoin();
            }
        }

        System.out.println("The total amount is " + totalAmount);
    }

    public static void CalculateCoinsForAllPeople() {
        for (Change person : people) {
            if(person != null){
                person.countCoin();
            }
        }
    }
    public static void HardCode(){
        Change person1 = new Change("Jane", 30);
        Change person2 = new Change("John", 50);
        Change person3 = new Change("Fred", 94);
        Change person4 = new Change("Jane", 35);
        Change person5 = new Change("David", 146);
        Change person6 = new Change("Anne", 178);
        Change person7 = new Change("Kate", 329);
        Change person8 = new Change("Tim", 68);
        Change person9 = new Change("John", 140);
        Change person10 = new Change("David", 13);

        Change.addPerson(person1);
        Change.addPerson(person2);
        Change.addPerson(person3);
        Change.addPerson(person4);
        Change.addPerson(person5);
        Change.addPerson(person6);
        Change.addPerson(person7);
        Change.addPerson(person8);
        Change.addPerson(person9);
        Change.addPerson(person10);
    }
}









