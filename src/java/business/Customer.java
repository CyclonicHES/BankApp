package business;

import java.util.*;

public class Customer {

    private Map<String, Account> accounts;
    private int number;
    private String firstName;
    private String lastName;

    public Customer(final Integer number, final String firstName, final String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new HashMap<>();
    }

    public Account getAccountByNumber(final String number) {
        return this.accounts.get(number);
    }
    
    public List<Account> getAccounts() {
        return new ArrayList<>(this.accounts.values());
    }

    public Account addAccount(final String number, final String name, final double rate) {
        if(!accounts.containsKey(number)) {
            Account account = new Account(number, name, rate, this);
            this.accounts.put(number, account);
            
            return account;
        } else {
            return null;
        }
    }
    
    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.number);
        sb.append(";");
        sb.append(this.firstName);
        sb.append(";");
        sb.append(this.lastName);
        sb.append(";");
        sb.append(this.accounts.toString());
        return sb.toString();
    }
    
}
