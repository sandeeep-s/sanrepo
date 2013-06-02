<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="brand.list" />
</h1>
<a href="<c:url value='/brand/add'/>"><s:message code="brand.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="brand.name" /></th>
	</tr>
	<c:forEach items="${brands}" var="brand">
		<tr>
			<td>${brand.name}</td>
			<td><a href="<c:url value='/brand/${brand.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/brand/${brand.id}'/>"><s:message code="view" /></a></td>
			<td>
			<sf:form action="/eshop/brand/${brand.id}" method="DELETE">
				<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
			</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
