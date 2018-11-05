package com.cg.payroll.client;

import java.sql.SQLException;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;
import com.cg.payroll.services.PayrollServices;

public class MainClass {

	public static void main(String[] args) {
		PropertyConfigurator.configure(".\\resources\\log4j.properties");
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("projectbeans.xml");
			PayrollServices payrollServices = (PayrollServices) context.getBean("payrollServices");
			int associateId = payrollServices.acceptAssociateDetails("Sahil", "Singh",
					"hkps@gmail.com", "JavaFullStack", "A.Con", "ASDF123",
					8000, 60000, 2000, 1000, 123456789, "Axis", "AXIS000002");
			System.out.println(payrollServices.getAssociateDetails(associateId));
			System.out.println("With Net Salary for associateId = "+associateId+" is "+payrollServices.calculateNetSalary(associateId));
			System.out.println(payrollServices.getAssociateDetails(associateId));
		} catch (PayrollServicesDownException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (AssociateDetailsNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
