<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="dimension.list" />
</h1>
<a href="<c:url value='/dimension/add'/>"><s:message code="dimension.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="category.name" /></th>
		<th><s:message code="dimension.name" /></th>
	</tr>
	<c:forEach items="${requestScope.dimensions}" var="dimension">
		<tr>
			<td>${dimension.category.name}</td>
			<td>${dimension.name}</td>
			<td><a href="<c:url value='/dimension/${dimension.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/dimension/${dimension.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/dimension/${dimension.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
