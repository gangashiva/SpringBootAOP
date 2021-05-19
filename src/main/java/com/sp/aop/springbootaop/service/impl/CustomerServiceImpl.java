package com.sp.aop.springbootaop.service.impl;

import com.sp.aop.springbootaop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerServiceImpl customerServiceimpl;

  @Override
  public void addCustomer() {

    System.out.println("addCustomer() is running.!");
    customerServiceimpl.addCustReturnedValue();
  }

  @Override
  public String addCustReturnedValue() {
    System.out.println("addCustReturnedValue() is running..!");
    return "Synchronoss";
  }

  @Override
  public void addCustomerThrowException() throws Exception {
    System.out.println("addCustomerThrowException() is running...!");
    throw  new Exception("Generic error");
  }

  @Override
  public void addCustomerAround(String name) {
    System.out.println("addCustomerAround() is running, args: "+ name);
  }
}
