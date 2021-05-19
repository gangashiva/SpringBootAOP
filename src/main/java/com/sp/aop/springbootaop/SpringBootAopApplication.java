package com.sp.aop.springbootaop;

import com.sp.aop.springbootaop.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootAopApplication implements CommandLineRunner {

  @Autowired
  CustomerServiceImpl customerServiceimpl;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootAopApplication.class, args);
  }

  /**
   * Callback used to run the bean.
   *
   * @param args incoming main method arguments
   * @throws Exception on error
   */
  @Override
  public void run(String... args) throws Exception {
    customerServiceimpl.addCustomer();
    //customerServiceimpl.addCustReturnedValue();
    //customerServiceimpl.addCustomerThrowException();
    //customerServiceimpl.addCustomerAround("SNCR");
  }
}
