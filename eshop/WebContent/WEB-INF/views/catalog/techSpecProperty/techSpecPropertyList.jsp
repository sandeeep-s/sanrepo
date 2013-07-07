<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="tech.spec.property.list" />
</h1>
<a href="<c:url value='/techspecproperty/add'/>"><s:message code="tech.spec.property.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="category.name" /></th>
		<th><s:message code="tech.spec.property.name" /></th>
	</tr>
	<c:forEach items="${techSpecPropertys}" var="techSpecProperty">
		<tr>
			<td>${techSpecProperty.category.name}</td>
			<td>${techSpecProperty.name}</td>
			<td><a href="<c:url value='/techspecproperty/${techSpecProperty.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/techspecproperty/${techSpecProperty.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/techspecproperty/${techSpecProperty.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
