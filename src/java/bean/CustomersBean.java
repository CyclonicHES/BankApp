package bean;

import business.Customer;
import services.Services;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@Named("CustomersBean")
@RequestScoped
public class CustomersBean implements Serializable {
    
    private DataModel<Customer> customers;
    
    @Inject
    private Services services;
    
    public DataModel<Customer> getCustomers() {
        customers = new ListDataModel<>();
        customers.setWrappedData(services.getCustomersList());
        return customers;
    }
}
