<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Opened</title>
</head>
<body>
	<div align="left">
		<h5 align="center">
			<font color="brown" size="4"> Account has been successfully
				registered with Account No. ${account.accountNo} 
				<br> With default Pin Number: ${account.pinNumber} 
				<br> Balance: ${account.accountBalance}
			</font>
		</h5>
		<p>
			<a href="/banking/">Return To Home Page</a>
	</div>		
</body>
</html>