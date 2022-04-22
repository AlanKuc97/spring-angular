package com.test.testapi.service;

import java.time.LocalDate;
import java.util.Vector;

import com.test.testapi.dao.CustomerDAO;
import com.test.testapi.data.DataController;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private boolean checkUKViolation(String email) {
        Vector<CustomerDAO> db = DataController.getCustomersData();
        for (int i = 0; i < db.size(); i++) {
            System.out.println(db.get(i).getEmail());
            if (db.get(i).getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public Vector<CustomerDAO> getCustomers() {
        return DataController.getCustomersData();
    }

    public void addCustomer(CustomerDAO customer) throws Exception {
        Vector<CustomerDAO> db = DataController.getCustomersData();
        if (checkUKViolation(customer.getEmail()) || customer.getEmail() == null) {
            throw new Exception("Unique key violated");
        }
        if (!customer.getBirthDate().isBefore(LocalDate.now())) {
            throw new Exception("Can't register yet unborn customers");
        }
        customer.setId(db.lastElement().getId() + 1); // Imitate db sequence
        DataController.setCustomer(customer);
    }
}
