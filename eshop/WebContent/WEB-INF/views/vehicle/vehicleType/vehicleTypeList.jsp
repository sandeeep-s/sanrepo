<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.type.list" />
</h1>
<a href="<c:url value='/vehicletype/add'/>"><s:message code="vehicle.type.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="vehicle.type.name" /></th>
	</tr>
	<c:forEach items="${vehicleTypes}" var="vehicleType">
		<tr>
			<td>${vehicleType.name}</td>
			<td><a href="<c:url value='/vehicletype/${vehicleType.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/vehicletype/${vehicleType.id}'/>"><s:message code="view" /></a></td>
			<td>
			<sf:form action="/eshop/vehicletype/${vehicleType.id}" method="DELETE">
				<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
			</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
