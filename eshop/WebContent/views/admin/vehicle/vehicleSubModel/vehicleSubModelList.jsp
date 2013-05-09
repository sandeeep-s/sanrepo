<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.submodel.list" />
</h1>
<a href="<c:url value='/vehiclesubmodel/add'/>"><s:message code="vehicle.submodel.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="vehicle.model.name" /></th>
		<th><s:message code="vehicle.submodel.name" /></th>
	</tr>
	<c:forEach items="${requestScope.vehicleSubModels}" var="vehicleSubModel">
		<tr>
			<td>${vehicleSubModel.vehicleModel.name}</td>
			<td>${vehicleSubModel.name}</td>
			<td><a href="<c:url value='/vehiclesubmodel/${vehicleSubModel.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/vehiclesubmodel/${vehicleSubModel.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/vehiclesubmodel/${vehicleSubModel.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
