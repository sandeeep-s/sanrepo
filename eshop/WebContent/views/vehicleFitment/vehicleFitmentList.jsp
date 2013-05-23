<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="vehicle.fitment.list" />
</h1>
<a href="<c:url value='/vehiclefitment/add'/>"><s:message code="vehicle.fitment.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="vehicle.model.name" /></th>
		<th><s:message code="vehicle.fitment.name" /></th>
	</tr>
	<c:forEach items="${requestScope.vehicleFitments}" var="vehicleFitment">
		<tr>
			<td>${vehicleFitment.vehicleModel.name}</td>
			<td>${vehicleFitment.name}</td>
			<td><a href="<c:url value='/vehiclefitment/${vehicleFitment.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/vehiclefitment/${vehicleFitment.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/vehiclefitment/${vehicleFitment.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
