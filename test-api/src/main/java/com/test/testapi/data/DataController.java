package com.test.testapi.data;

import java.time.LocalDate;
import java.time.Month;
import java.util.Vector;

import com.test.testapi.dao.CustomerDAO;

public class DataController {
    private static Vector<CustomerDAO> customersData;

    /*
     * Method - generateCustomersGenData
     * 
     * @params
     * len - how many items should be generated
     */
    public static void generateCustomersData(long len) {
        customersData = new Vector<CustomerDAO>();
        for (long i = 1; i < len; i++) {
            customersData.add(new CustomerDAO(i, "Test name " + i, "Test surname " + i,
                    LocalDate.of(1997, Month.OCTOBER, 17),
                    "+3706777777", "test" + i + "@email.com"));
        }
    }

    public static Vector<CustomerDAO> getCustomersData() {
        return customersData;
    }

    public static void setCustomer(CustomerDAO customer) {
        customersData.add(customer);
    }
}
