<%@include file="/views/init.jsp"%>
<h1 align="center">
	<s:message code="category.list" />
</h1>
<a href="<c:url value='/category/add'/>"><s:message code="category.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="category.name" /></th>
	</tr>
	<c:forEach items="${requestScope.categorys}" var="category">
		<tr>
			<td>${category.name}</td>
			<td><a href="<c:url value='/category/${category.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/category/${category.id}'/>"><s:message code="view" /></a></td>
			<td>
			<sf:form action="/eshop/category/${category.id}" method="DELETE">
				<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
			</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
