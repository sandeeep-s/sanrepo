<%@include file="../init.jsp"%>
<h1 align="center">
	<s:message code="product.list" />
</h1>
<a href="<c:url value='/product/add'/>"><s:message code="product.add" /></a>
<br />
<br />
<table>
	<tr>
		<th><s:message code="brand.name" /></th>
		<th><s:message code="product.name" /></th>
	</tr>
	<c:forEach items="${products}" var="product">
		<tr>
			<td>${product.brand.name}</td>
			<td>${product.name}</td>
			<td><a href="<c:url value='/product/${product.id}/edit'/>"><s:message code="edit" /></a></td>
			<td><a href="<c:url value='/product/${product.id}'/>"><s:message code="view" /></a></td>
			<td>
				<sf:form action="/eshop/product/${product.id}" method="DELETE">
						<a href="#" onclick="parentNode.submit()"><s:message code="delete" /></a>
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
