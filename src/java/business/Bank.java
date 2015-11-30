package business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class Bank {

    private int number;
    private String name;
    private Map<Integer, Customer> customers;
    private Map<String, Account> accounts;

    public Bank(final int number, final String name) {
        this.number = number;
        this.name = name;
        this.customers = new HashMap<>();
        this.accounts = new HashMap<>();
    }

    public Account getAccountByNumber(final String number) {
        return this.accounts.get(number);
    }

    public Customer getCustomerByNumber(final int number) {
        return this.customers.get(number);
    }
    
    public Map<Integer, Customer> getCustomers() {
        return this.customers;
    }

    public Customer addCustomer(final int number, final String firstName, final String lastName) {
        if(!customers.containsKey(number)) {
            Customer customer = new Customer(number, firstName, lastName);
            this.customers.put(number, customer);
            return customer;
        } else {
            return null;
        }
    }

    public Account addAccount(final String number, final String name, final double rate, final Customer customer) {
        if(getCustomerByNumber(customer.getNumber()) == null) {
            throw new IllegalArgumentException("Le client n'est pas enregistré au près de la banque.");
        }
        
        if(!accounts.containsKey(number)) {
            this.accounts.put(number, new Account(number, name, rate, customer));
            return customer.addAccount(number, name, rate);
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

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.number);
        sb.append(";");
        sb.append(this.name);
        
        for(Iterator cust = customers.values().iterator(); cust.hasNext();) {
            sb.append(";");
            sb.append(((Customer)cust.next()).toString());
        }
        
        for(Iterator acc = accounts.values().iterator(); acc.hasNext();) {
            sb.append(";");
            sb.append(((Account)acc.next()).toString());
        }
        
        return sb.toString();
    }
}
