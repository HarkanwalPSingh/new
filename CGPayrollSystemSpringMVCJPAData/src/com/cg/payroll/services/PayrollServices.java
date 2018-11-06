package com.cg.payroll.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.cg.payroll.beans.Associate;
import com.cg.payroll.exceptions.AssociateDetailsNotFoundException;
import com.cg.payroll.exceptions.PayrollServicesDownException;

public interface PayrollServices {
	Associate acceptAssociateDetails(Associate associate) throws PayrollServicesDownException, SQLException;
	
	int calculateNetSalary(int associateId)
			throws AssociateDetailsNotFoundException,
			PayrollServicesDownException, SQLException;

	Associate getAssociateDetails(int associateId)
			throws AssociateDetailsNotFoundException,
			PayrollServicesDownException, SQLException;

	ArrayList<Associate> getAllAssociateDetails()
			throws PayrollServicesDownException;
}
