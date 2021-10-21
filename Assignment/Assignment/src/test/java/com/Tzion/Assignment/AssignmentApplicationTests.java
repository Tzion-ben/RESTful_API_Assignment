package com.Tzion.Assignment;

import com.Tzion.Assignment.ControllersAndServices.CustomerController;
import com.Tzion.Assignment.ControllersAndServices.CustomerService;
import com.Tzion.Assignment.DataModels.Customer;
import com.Tzion.Assignment.DataModels.CustomerDataManagerNotPersistent;
import com.Tzion.Assignment.DataModels.SearchBody;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AssignmentApplicationTests {

	@Autowired
	private CustomerDataManagerNotPersistent testData;
	@Autowired
	private CustomerService customerService;

	//getCustomer by ID test
	@Test
	void getCustomerById() {
		customerService = Mockito.mock(CustomerService.class);
		when(customerService.getCustomerById("488841648")).thenReturn(testData.getCustomerById("488841648"));
		CustomerController customerController = new CustomerController(customerService);
		assertEquals(testData.getCustomerById("488841648") , customerController.getCustomerById("488841648"));
	}

	//search operation test
	@Test
	void searchOperations() {
		customerService = Mockito.mock(CustomerService.class);
		SearchBody bodySearch = new SearchBody("Hana Hanina" , "Afula" , "5 to 54");

		List<Customer> testList = Arrays.asList(testData.getCustomerById("123409876"));
		when(customerService.searchByName("Hana Hanina")).thenReturn(testList);

		CustomerController customerController = new CustomerController(customerService);
		assertEquals(testData.getCustomerById("123409876"), customerController.search(bodySearch).get(0));
	}
}
