import java.util.Scanner;

class EBBill {
    int consumerNo;
    String name;
    int previousReading;
    int currentReading;
    String type;
    int units;
    double amount;

    void calculateBill() {
        units = currentReading - previousReading;

        if (type.equalsIgnoreCase("domestic")) {
            if (units <= 100)
                amount = 0;
            else if (units <= 200)
                amount = (units - 100) * 2;
            else if (units <= 500)
                amount = 100 * 2 + (units - 200) * 4;
            else
                amount = 100 * 2 + 300 * 4 + (units - 500) * 6;
        } else if (type.equalsIgnoreCase("commercial")) {
            if (units <= 100)
                amount = units * 2;
            else if (units <= 200)
                amount = 100 * 2 + (units - 100) * 4;
            else if (units <= 500)
                amount = 100 * 2 + 100 * 4 + (units - 200) * 6;
            else
                amount = 100 * 2 + 100 * 4 + 300 * 6
                         + (units - 500) * 7;
        }
    }

    void display() {
        System.out.println("Consumer Number: " + consumerNo);
        System.out.println("Consumer Name: " + name);
        System.out.println("Units Consumed: " + units);
        System.out.println("Total Amount: Rs. " + amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        EBBill eb = new EBBill();

        System.out.print("Enter Consumer Number: ");
        eb.consumerNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Consumer Name: ");
        eb.name = sc.nextLine();

        System.out.print("Enter Previous Reading: ");
        eb.previousReading = sc.nextInt();

        System.out.print("Enter Current Reading: ");
        eb.currentReading = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter Connection Type: ");
        eb.type = sc.nextLine();

        eb.calculateBill();
        eb.display();

        sc.close();
    }
}
