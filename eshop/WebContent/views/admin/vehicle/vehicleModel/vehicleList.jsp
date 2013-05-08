<%@include file="/views/init.jsp"%>
<h1 align="center"><s:message code="vehicle.list" /></h1>
<a href="<c:url value='/vehicle/add'/>"><s:message code="vehicle.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="vehicle.image" /></th>
		<th><s:message code="vehicle.make" /></th>
		<th><s:message code="vehicle.model" /></th>
		<th><s:message code="vehicle.submodel" /></th>
		<th><s:message code="vehicle.year" /></th>
	</tr>
	<c:forEach items="${requestScope.vehicleSet}" var="vehicle">
		<tr>
			<td><img src="${vehicle.imageURL}" title="${vehicle.model}" alt="${vehicle.model}"></img></td>
			<td>${vehicle.make.name}</td>
			<td>${vehicle.model}</td>
			<td>${vehicle.subModel}</td>
			<td>${vehicle.manufacturingYear}</td>
			<td><a href="<c:url value='/vehicle/${vehicle.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/vehicle/${vehicle.id}/view'/>"><s:message code="view" /></a></td>
			<td>
			<sf:form action="/etyre-spring-rest/vehicle/${vehicle.id}" method="DELETE">
				<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
			</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
