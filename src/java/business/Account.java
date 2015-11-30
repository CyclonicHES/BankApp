package business;


public class Account {

    private Customer customer;
    private String number;
    private String name;
    private double balance = 0;
    private double rate = 0.001;
    
    public Account(final String number, final String name, final double rate, final Customer customer) {
        this.number = number;
        this.name = name;
        this.rate = rate;
        this.customer = customer;
    }

    public void credit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Impossible de créditer un montant négatif ou null !");
        }
        
        this.balance += amount;
    }

    public void debit(final double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Impossible de débiter un montant négatif ou null !");
        }
        
        if (this.balance < amount) {
            throw new IllegalStateException("Solde insuffisant ! Débit refusé.");
        }
        
        this.balance -= amount;
    }

    public static void transfer(final double amount, final Account source, final Account target) {
        source.debit(amount);
        target.credit(amount);
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(final String number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(final double balance) {
        this.balance = balance;
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(final double rate) {
        this.rate = rate;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        sb.append(this.customer.getFirstName());
        sb.append(" ");
        sb.append(this.customer.getLastName());
        sb.append(";");
        sb.append(this.number);
        sb.append(";");
        sb.append(this.name);
        sb.append(";");
        sb.append(this.balance);
        sb.append(";");
        sb.append(this.rate);
        
        return sb.toString();
    }

}
