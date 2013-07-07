<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.list" />
</h1>
<a href="<c:url value='/vehiclemodel/add'/>"><s:message code="vehicle.model.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="vehicle.make" /></th>
		<th><s:message code="vehicle.type" /></th>
		<th><s:message code="vehicle.model.name" /></th>
		<th><s:message code="vehicle.model.year" /></th>
	</tr>
	<c:forEach items="${vehicleModels}" var="vehicleModel">
		<tr>
			<td>${vehicleModel.vehicleMake.name}</td>
			<td>${vehicleModel.vehicleType.name}</td>
			<td>${vehicleModel.name}</td>
			<td>${vehicleModel.modelYear}</td>
			<td><a href="<c:url value='/vehiclemodel/${vehicleModel.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/vehiclemodel/${vehicleModel.id}'/>"><s:message code="view" /></a></td>
			<td><sf:form action="/eshop/vehiclemodel/${vehicleModel.id}" method="DELETE">
					<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form></td>
		</tr>
	</c:forEach>
</table>
