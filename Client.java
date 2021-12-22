/**
 * @author Omar Abdallah
 */

public class Client {

    private String name, nationalID, address, phone;
    private Account account;

    public Client(String name, String nationalID, String address, String phone, Account account) {
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phone = phone;
        this.account = account;
    }

    public Client(Account acc) {

    }

    public void setNationalID(String id) {
        nationalID = id;
    }

    public void setAddress(String add) {
        address = add;
    }

    public void setPhone(String ph) {
        phone = ph;
    }

    public void setAccount(Account acc) {
        account = acc;
    }

    public void setName(String n) {
        name = n;
    }


    public String getName() {
        return name;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Account getAccount() {
        return account;
    }


    @Override
    public String toString() {
        return "\nThis is personal client" + "\nName: " + this.name + '\n' + "National ID: " + this.nationalID + '\n' + "Address: " +
                this.address + '\n' + "Phone: " + this.phone + '\n' + account.toString();
    }

}

/**********CommercialClient Class*********/

class CommercialClient extends Client {
    private String commercialID;

    public CommercialClient(String name, String commercialID, String address, String phone, Account account) {
        super(name, "00000000000000", address, phone, account);
        this.commercialID = commercialID;
    }

    public void setCommercialID(String ID) {
        commercialID = ID;
    }

    public String getCommercialID() {
        return commercialID;
    }

    @Override
    public String toString() {

        return "\nThis is a Commercial Client" + '\n' + "Name: " + getName() + '\n' + "Commercial ID: " + getCommercialID() + '\n' + "Address: " + getAddress() + '\n' + "Phone: " + getPhone()
                + '\n' + getAccount().toString();
    }

}

class ClientTest {
    public static void main(String[] args) {
        Account a1 = new Account(10,2000);
        Client c1 = new Client("Omar","3214524","fesal","32132132",a1);
        System.out.println(c1);

    }
}

