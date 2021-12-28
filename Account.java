import java.util.Scanner;

public class Account {

    //klassen variabler
    int balance;
    int previousTransaction;
    String name;
    int ID;

    //classens konstruktør
    Account(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    //funktionen som sætter penge ind på kontoen
    void deposit (int amount) {
        if (amount !=0) {
            balance = balance+amount;
            previousTransaction = amount;
        }
    }

    //funktionen som tager penge fra kontoen
    void withdraw(int amount) {
        if (amount !=0) {
            balance = balance-amount;
            previousTransaction=amount;
        }
    }

    //funktionen som viser tidligere transaktioner
    void getPreviousTransaction() {
        if (previousTransaction >0) {
            System.out.println("Der blev sat : " + previousTransaction + " ind på kontoen.");
        } else if (previousTransaction <0) {
            System.out.println("Der blev hævet: " + Math.abs(previousTransaction) + " på kontoen.");
        } else {
            System.out.println("Der blev ikke foretaget nogen transaktion.");
        }
    }

    //funktionen som udregner renter efter x antal år
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance *interestRate*years) + balance;
        System.out.println("Renten er p.t. på " + (100*interestRate));
        System.out.println("Efter " + years + " år, vil der være " + newBalance + " på kontoen.");
    }


    void showMenu() {
        char option = '\0';
        Scanner input = new Scanner(System.in);
        System.out.println("Hej" + name + "! Dit ID-nummer er " + ID + " ! Hvad kunne du tænke dig at gøre?" +
                "\n" +
                "\nA. Se hvad du har på kontoen" +
                "\nB. Sæt penge ind på kontoen" +
                "\nC. Hæv penge fra kontoen" +
                "\nD. Se tidligere transaktion." +
                "\nE. Udregn renter" +
                "\nF. Afslut programmet");

        do {
            System.out.println("\nSkriv dit input: ");
            char option1 = input.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                //case A giver mulighed for at se hvad der er på kontoen
                case 'A':
                    System.out.println("===============================" +
                            "\nDer er " + balance + " kr på kontoen." +
                            "\n===============================" +
                            "\n");
                    break;
                //case B giver mulighed for at sætte penge ind på kontoen
                case 'B':
                    System.out.println("Hvor meget vil du sætte ind på kontoen?");
                    int amount = input.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                //case C giver mulihed for at hæve penge
                case 'C':
                    System.out.println("Skriv det beløb du ønsker at hæve");
                    int amount2 = input.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                //case D giver mulighed for at se sidste transaktion
                case 'D':
                    System.out.println("===============================");
                    getPreviousTransaction();
                    System.out.println("===============================\n");
                    break;
                //case E udregner renten efter x antal år.
                case 'E':
                    System.out.println("Hvor mange års rente til du udregne?");
                    int years = input.nextInt();
                    calculateInterest(years);
                    break;
                //case F afslutter programmet
                case 'F':
                    System.out.println("===============================");
                    break;
                //default fortæller bruger, at det indtastede er forkert.
                default:
                    System.out.println("Det kan du ikke gøre nu, vælg noget fra menuen.");
                    break;
                    }
        } while (option!='F');
        System.out.println("Tak fordi du brugte vores bank!");

    }
}
