<%@include file="/views/init.jsp"%>

<h1 align="center">
	<s:message code="home" />
</h1>
<table>
	<tr>
		<td><a href="<c:url value='/vehiclemake'/>"><s:message code="vehicle.make" /></a></td>
	</tr>
	<tr>
		<td><a href="<c:url value='/vehicle'/>"><s:message code="vehicle" /></a></td>
	</tr>
</table>
