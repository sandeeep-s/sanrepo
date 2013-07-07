<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="dimension.property.list" />
</h1>
<a href="<c:url value='/dimensionproperty/add'/>"><s:message code="dimension.property.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="category.name" /></th>
		<th><s:message code="dimension.property.name" /></th>
	</tr>
	<c:forEach items="${dimensionPropertys}" var="dimensionProperty">
		<tr>
			<td>${dimensionProperty.category.name}</td>
			<td>${dimensionProperty.name}</td>
			<td><a href="<c:url value='/dimensionproperty/${dimensionProperty.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/dimensionproperty/${dimensionProperty.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/dimensionproperty/${dimensionProperty.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
