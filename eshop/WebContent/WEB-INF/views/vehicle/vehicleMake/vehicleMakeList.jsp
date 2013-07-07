<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.make.list" />
</h1>
<a href="<c:url value='/vehiclemake/add'/>"><s:message code="vehicle.make.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="vehicle.make.name" /></th>
	</tr>
	<c:forEach items="${vehicleMakes}" var="vehicleMake">
		<tr>
			<td>${vehicleMake.name}</td>
			<td><a href="<c:url value='/vehiclemake/${vehicleMake.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/vehiclemake/${vehicleMake.id}'/>"><s:message code="view" /></a></td>
			<td>
			<sf:form action="/eshop/vehiclemake/${vehicleMake.id}" method="DELETE">
				<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
			</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
