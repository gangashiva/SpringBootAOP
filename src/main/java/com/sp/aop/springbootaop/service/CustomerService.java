package com.sp.aop.springbootaop.service;

public interface CustomerService {

  public void addCustomer();

  public String addCustReturnedValue();

  public void addCustomerThrowException() throws  Exception;

  public void addCustomerAround(String name );



}
