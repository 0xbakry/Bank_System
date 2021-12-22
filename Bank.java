/*
  @author Abdaullah Kadry
 */
import java.util.ArrayList;


public class Bank {
    private String name, address, phone;
    private ArrayList<Account> accounts = new ArrayList<>();
    private ArrayList<Client> clients = new ArrayList<>();

    public Bank(String name, String address, String phone) {
        super();
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
       /*
       @return
        */
        this.phone = phone;
    }

    public void addClient(Client client) {
        clients.add(client);
        accounts.add(client.getAccount());
    }

    public Client searchClients(int id) {
        for (Client c : clients) {
            if (c.getAccount().getAccountNumber() == id)
                return c;
        }

        System.out.println("Client not found.");
        return null;
    }
            
    public void displayClients() {
        for (Client c : clients) {
            System.out.println(c);
        }
    }
}
// Test for bank class
class BankTest{
    public static void main(String [] args){

        Bank b1= new Bank("Masry","helwan","02327564540");
        Account account = new Account(1,3000);
        Client client = new Client("client1","321659874123546","giza","013215623",account);

        b1.addClient(client);
        b1.displayClients();

    }
}







