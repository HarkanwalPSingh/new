<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Registration</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body align=center>
	<h1>Welcome to Payroll Services</h1>
	<div align=center>

		<h1>Enter Associate Details</h1>
		<table border=1>
			<form:form action="registerAssociate" method="post"
				modelAttribute="associate">
				<tr>
					<td>First Name:</td>
					<td><form:input path="firstName" size="25" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Last Name:</td>
					<td><form:input path="lastName" size="25" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Department:</td>
					<td><form:input path="department" size="25" /></td>
					<td><form:errors path="department" cssClass="error" /></td>

					</td>
				</tr>
				<tr>
					<td>Designation:</td>
					<td><form:input path="designation" size="25" /></td>
					<td><form:errors path="designation" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Pan Card:</td>
					<td><form:input path="pancard" size="25" /></td>
					<td><form:errors path="pancard" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Email Id:</td>
					<td><form:input path="emailId" size="25" /></td>
					<td><form:errors path="emailId" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Yearly Investment <br>Under 80c:
					</td>
					<td><form:input path="yearlyInvestmentUnder80C" size="25" /></td>
					<td><form:errors path="yearlyInvestmentUnder80C" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Account Number:</td>
					<td><form:input path="bankdetails.accountNumber" size="25" /></td>
					<td><form:errors path="bankdetails.accountNumber" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Bank Name:</td>
					<td><form:input path="bankdetails.bankName" size="25" /></td>
					<td><form:errors path="bankdetails.bankName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Bank Code:</td>
					<td><form:input path="bankdetails.ifscCode" size="25" /></td>
					<td><form:errors path="bankdetails.ifscCode" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Basic Salary:</td>
						<td><form:input path="salary.basicSalary" size="25" /></td>
					<td><form:errors path="salary.basicSalary" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Epf:</td>
						<td><form:input path="salary.epf" size="25" /></td>
					<td><form:errors path="salary.epf" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Company pf:</td>
					<td><form:input path="salary.companyPf" size="25" /></td>
					<td><form:errors path="salary.companyPf" cssClass="error" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="Submit"
						name="submit" value="Submit"></td>
				</tr>
			</form:form>
		</table>

	</div>
</body>
</html>