<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="../init.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="title" /></title>
<script src="/eshop/resources/js/jquery-1.10.0.min.js"></script>
</head>
<body>
	<table>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td>
				<h1 align="center">
					<tiles:getAsString name="title" />
				</h1> 
				<tiles:insertAttribute name="body" />
			</td>
		</tr>
		<tr>
			<td colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>