<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="tech.spec.list" />
</h1>
<a href="<c:url value='/techspec/add'/>"><s:message code="tech.spec.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="category.name" /></th>
		<th><s:message code="tech.spec.name" /></th>
	</tr>
	<c:forEach items="${requestScope.techSpecs}" var="techSpec">
		<tr>
			<td>${techSpec.category.name}</td>
			<td>${techSpec.name}</td>
			<td><a href="<c:url value='/techspec/${techSpec.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/techspec/${techSpec.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/techspec/${techSpec.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
