public class Main {

    public static void main(String[] args) {

        Bank b1 = new Bank("Masr", "Haron", "01202190865");

        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int accountNumber = 0;
        System.out.println("------------Welcome to The bank System------------\n");
        while (true) {
            System.out.println("What would you like to do?\n" +
                    "1- Create an account. \n" +
                    "2- Inform about your account.");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("1- Personal Client\n"
                            + "2- Commercial Client");
                    int choiceType = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("1- Regular Account\n"
                            + "2- Special Account");

                    int choiceType2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Please enter these data sequentially: name, national id, address, phone:\n");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    String nationalID;
                    if (choiceType == 1) {
                        System.out.print("National ID: ");
                        nationalID = scanner.nextLine();

                    } else {
                        System.out.print("Commercial ID: ");
                        nationalID = scanner.nextLine();
                    }
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Phone: ");
                    String phone = scanner.nextLine();
                    accountNumber++;
                    Client client = null;
                    if (choiceType == 1 && choiceType2 == 1) {
                        Account account = new Account(accountNumber, 0);
                        client = new Client(name, nationalID, address, phone, account);

                    } else if (choiceType == 1 && choiceType2 == 2) {
                        SpecialAccount specialAccount = new SpecialAccount(accountNumber, 0);
                        client = new Client(name, nationalID, address, phone, specialAccount);

                    } else if (choiceType == 2 && choiceType2 == 1) {
                        Account account = new Account(accountNumber, 0);
                        client = new CommercialClient(name, nationalID, address, phone, account);

                    } else if (choiceType == 2 && choiceType2 == 2) {
                        SpecialAccount specialAccount = new SpecialAccount(accountNumber, 0);
                        client = new CommercialClient(name, nationalID, address, phone, specialAccount);
                    }
                    b1.addClient(client);
                    System.out.println("Your account has been added!!\n");
                    break;
                case 2:
                    System.out.println("Please enter your account number.");
                    int searchAccountNumber = scanner.nextInt();
                    if (b1.searchClients(searchAccountNumber) != null) {
                        Client tempClient = b1.searchClients(searchAccountNumber);
                        int option;
                        do {
                            System.out.println(tempClient);
                            System.out.println("1- Deposit\n"
                                    + "2- Withdraw\n"
                                    + "3- Exit\n");

                            option = scanner.nextInt();
                            while (!(option == 1 || option == 2 || option == 3)) {
                                option = scanner.nextInt();
                                if (!(option == 1 || option == 2 || option == 3))
                                    System.out.println("Wrong input ... try again.");
                            }
                            switch (option) {
                                /*****DEPOSIT*****/
                                case 1:
                                    System.out.print("Please enter the quantity you want to add: ");
                                    double deposit = scanner.nextDouble();
                                    scanner.nextLine();
                                    tempClient.getAccount().deposit(deposit);
                                    break;

                                /*****WITHDRAW*****/
                                case 2:
                                    System.out.print("Please enter the quantity you want to withdraw: ");
                                    double withdraw = scanner.nextDouble();
                                    scanner.nextLine();
                                    tempClient.getAccount().withdraw(withdraw);
                                    break;

                                /******EXIT*****/
                                case 3:
                                    break;
                            }
                        } while (option != 3);
                    }
                    break;
            }
            System.out.println("1- Back to menu.\n"
                    + "2- Exit.\n");
            int option = scanner.nextInt();
            scanner.nextLine();
            if (option == 2)
                break;
        }
        System.out.println("Thanks for using our system");
    }
}

