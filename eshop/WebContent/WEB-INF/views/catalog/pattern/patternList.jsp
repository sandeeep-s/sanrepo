<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="pattern.list" />
</h1>
<a href="<c:url value='/pattern/add'/>"><s:message code="pattern.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="brand.name" /></th>
		<th><s:message code="pattern.name" /></th>
	</tr>
	<c:forEach items="${patterns}" var="pattern">
		<tr>
			<td>${pattern.brand.name}</td>
			<td>${pattern.name}</td>
			<td><a href="<c:url value='/pattern/${pattern.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/pattern/${pattern.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/pattern/${pattern.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
