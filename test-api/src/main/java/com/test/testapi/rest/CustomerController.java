package com.test.testapi.rest;

import java.util.Vector;

import com.test.testapi.dao.CustomerDAO;
import com.test.testapi.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/rest/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/get-customers-browse", method = RequestMethod.GET)
    public Vector<CustomerDAO> getCustomersBrowse() {
        Vector<CustomerDAO> res = customerService.getCustomers();
        return res;
    }

    @RequestMapping(value = "/post-customer", method = RequestMethod.POST)
    public CustomerDAO setCustomer(@RequestBody CustomerDAO customer) throws Exception {
        customerService.addCustomer(customer);
        return customer;
    }
}
