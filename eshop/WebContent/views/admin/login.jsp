<%@include file="/views/init.jsp"%>
<html>
<head>
<title><s:message code="login" /></title>
</head>
<body>

	<h1 align="center">
		<s:message code="login" />
	</h1>
	<form action="j_spring_security_check" method="POST">
		<label><s:message code="login.username" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: </label> <input type="text" name="j_username"> <br />
		<br /> <label><s:message code="login.password" /> : </label> <input type="password" name="j_password"> <br /> <br /> <input
			type="submit" value="<s:message code="login"/>">
	</form>

</body>
</html>